import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { SearchTVResponse, SearchTVQuery } from './../../tmdb-data/SearchTV';
import { SearchMovieResponse, SearchMovieQuery, MovieResult } from './../../tmdb-data/searchMovie';
import { TmdbService } from './../../tmdb.service';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BDDPlat, Plat, PlatResponse, PlatQuery, Ingredient } from '../interface/Plat';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private requete: any;
  private categorie: string;
  private type: string;
  private listmovie: SearchMovieResponse;
  private listserie: SearchTVResponse;
  private listallplat: BDDPlat = {
    total: 0,
    plats: [],
  };
  private listplat: PlatResponse = {
    page: 1,
    listplat: [],
    total_result: 0,
    total_pages: 0,
  };
  private gender: string[] = [];

  constructor(private router: Router, private tmdb: TmdbService, private http: HttpClient) {this.tmdb.init(environment.tmdbKey);}

  /****Getters et Setters****/
  setRequete(requete: any): void {this.requete = requete;}
  getRequete(): any {return this.requete;}

  setCategorie(categorie: string): void {this.categorie = categorie;}
  getCategorie(): string {return this.categorie;}

  setType(type: string): void {this.type = type;}
  getType(): string {return this.type;}

  setMovieResponse(listmovie: SearchMovieResponse): void {this.listmovie = listmovie;}
  getMovieResponse(): SearchMovieResponse {return this.listmovie;}

  setTVResponse(listserie: SearchTVResponse): void {this.listserie = listserie;}
  getTVResponse(): SearchTVResponse {return this.listserie;}

  setPlatResponse(listplat: PlatResponse): void {this.listplat = listplat;}
  getPlatResponse(type: string): PlatResponse {
    let i = 0;
    let j = 0;
    let tmp: Plat[] = [];
    while (i !== this.listallplat.plats.length) {
      if (this.listallplat.plats[i].type === type) {
        tmp[j] = this.listallplat.plats[i];
        j = j + 1;
      }
      i = i + 1;
    }
    this.listplat.listplat = tmp;
    this.listplat.total_result = tmp.length;
    return this.listplat;
  }
  getPlat(): PlatResponse {
    let tmp: Plat[] = [];
    this.listplat.listplat = this.listallplat.plats;
    this.listplat.total_result = this.listallplat.plats.length;
    return this.listplat;
  }

  getAllPlatResponse(): BDDPlat {return this.listallplat;}
  setGenres(checkbox, a: string): void {
    if (checkbox.checked) { this.gender.push(a); }
    else { const index: number = this.gender.indexOf(a); this.gender.splice(index, 1); }
    console.log(this.gender);
  }
  getNumberPages(): number{
    let i = 0;
    if (this.categorie === "film") { i = this.listmovie.total_pages; }
    else if (this.categorie === "serie") { i = this.listserie.total_pages; }
    else if (this.categorie === "plat") { i = this.listplat.total_pages; }
    return i;
  } 

  /******Fonctions booléennes******/
  Resultat(): boolean { return this.listmovie.results != null || this.listserie.results != null || this.listplat.listplat != null; }
  ResultatMovie(): boolean {return this.listmovie.results.length !== 0;}
  ResultatSerie(): boolean {return this.listserie.results.length !== 0;}
  ResultatPlat(): boolean {return this.listplat.listplat.length !== 0;}

  /****Fonctions de recherches*****/
  async researchMovie(requete: SearchMovieQuery) {
    let temp = await (this.tmdb.searchMovie(requete));
    this.setMovieResponse(temp);
  }

  async researchSerie(requete: SearchTVQuery) {
    let temp = await (this.tmdb.searchTV(requete));
    this.setTVResponse(temp);
  }

  researchPlat(requete: any): void {
    let i = 0;
    let j = 0;
    let tmp: PlatResponse;
    while(i !== this.listallplat.plats.length){
      console.log("plat : " + this.listallplat.plats);
      const index = this.listallplat.plats[i].nom.indexOf(requete.query);
      console.log("index : " + index);
      if(index !== -1){
        tmp.listplat[j] = this.listallplat.plats[i];
        console.log("tmp : " + tmp);
        j = j + 1;
        console.log("j : " + j);
      }
      i = i + 1;
    }
    console.log(tmp);
    this.setPlatResponse(tmp);
  }

  async doResearch(requete: any, categorie: string, query:string) {
    this.setCategorie(categorie);
    this.setRequete(requete);
    await this.researchMovie(requete);
    await this.researchSerie(requete);
    //this.researchPlat(requete);
  }

  /*****Fonctions des plats*******/
  private GET(url: string): Promise<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json ; charset=UTF-8');
    return this.http.get<any>(url, { responseType: 'json', headers: headers, observe: 'response' }).toPromise();
  }

  async getPlats() {
    const plats = await this.GET('/api/plats');
    var platJson = plats.body.plats;
    this.listallplat.total = platJson.length;
    console.log("les plats", platJson);
    console.log(this.listallplat.total);
    let i = 0;
    while (i != this.listallplat.total) {
      this.listallplat.plats.push(platJson[i].plat[0]);
      i++;
    }
    console.log(this.listallplat);
    console.log(this.listallplat.plats[0].type);
  }

  /*********Fonctions de tri***********/
  tri = function (a: string, list: SearchMovieResponse) {
    if (a === "popularitedec") { this.tri_popularitedec(list); }
    else if (a === "popularitecro") { this.tri_popularitecro(list); }
    else if (a === "preferencedes") { this.tri_preferencedes(list); }
    else if (a === "preferenceasc") { this.tri_preferencecro(list); }
    else if (a === "anneedes") { this.tri_anneedes(list); }
    else if (a === "anneeasc") { this.tri_anneeasc(list); }
    else if (a === "alphaAZ") { this.tri_alphabetiqueAZ(list); }
    else if (a === "alphaZA") { this.tri_alphabetiqueZA(list); }
  }
  tri_popularitedec(list: SearchMovieResponse) {
    this.listmovie.results = list.results.sort((a, b) => b.popularity - a.popularity);
  }
  tri_popularitecro(list: SearchMovieResponse) {
    this.listmovie.results = list.results.sort((a, b) => a.popularity - b.popularity);
  }
  tri_preferencedes(list: SearchMovieResponse) {
    this.listmovie.results = list.results.sort((a, b) => b.vote_average - a.vote_average);
  }
  tri_preferencecro(list: SearchMovieResponse) {
    this.listmovie.results = list.results.sort((a, b) => a.vote_average - b.vote_average);
  }
  triDec(a: string, b: string) {
    if (a > b) return -1;
    else if (a == b) return 0;
    else return 1;
  }
  triCro(a: string, b: string) {
    if (a < b) return -1;
    else if (a == b) return 0;
    else return 1;
  }
  tri_anneedes(list: SearchMovieResponse) {
    this.listmovie.results = list.results.sort((a, b) => this.triDec(a.release_date, b.release_date));
  }
  tri_anneeasc(list: SearchMovieResponse) {
    this.listmovie.results = list.results.sort((a, b) => this.triCro(a.release_date, b.release_date));
  }
  tri_alphabetiqueZA(list: SearchMovieResponse) {
    this.listmovie.results = list.results.sort((a, b) => this.triDec(a.title, b.title));
  }
  tri_alphabetiqueAZ(list: SearchMovieResponse) {
    this.listmovie.results = list.results.sort((a, b) => this.triCro(a.title, b.title));
  }
  /********Tri des Plats **************/
  tri_plat = function (a: string, list: PlatResponse) {
    console.log("a : " + a);
    console.log("list : " + list);
    if (a === "prixcro") { this.tri_prixCroissant(list); }
    else if (a === "prixdesc") { this.tri_prixDecroissant(list); }
    else if (a === "alphaAZ") { this.tri_PlatalphabetiqueAZ(list); }
    else if (a === "alphaZA") { this.tri_PlatalphabetiqueZA(list); }
  }
  tri_prixCroissant(list: PlatResponse) {
    this.listplat.listplat = list.listplat.sort((a, b) => a.prix - b.prix);
  }
  tri_prixDecroissant(list: PlatResponse) {
    this.listplat.listplat = list.listplat.sort((a, b) => b.prix - a.prix);
  }
  tri_PlatalphabetiqueZA(list: PlatResponse) {
    this.listplat.listplat = list.listplat.sort((a, b) => this.triDec(a.nom, b.nom));
  }
  tri_PlatalphabetiqueAZ(list: PlatResponse) {
    this.listplat.listplat = list.listplat.sort((a, b) => this.triCro(a.nom, b.nom));
  }

  /********Fonctions de filtres********/
  /* ouvrirFermerFiltres = function (id: string) {
     console.log(id);
     var contenu = document.getElementById(id);
     console.log(contenu);
     if (contenu.style.display == 'none') {
       contenu.style.display = 'grid';
     } else {
       contenu.style.display = 'none';
     }
   }*/
  /*filtreNote(list: SearchMovieResponse) {
    var slidders = document.querySelectorAll(".note input")
    var val1 = parseFloat(slidders[0].value);
    var val2 = parseFloat(slidders[1].value);
    if (val1 >= val2) {
      slidders[0].value = val2;
      slidders[1].value = val1;
    }
    console.log(slidders);
    let i = 0;
    let j = 0;
    let tmp: MovieResult[] = null;
    while (i != this.listmovie.results.length) {
      if (this.listmovie.results[i].vote_average >= val1 && this.listmovie.results[i].vote_average <= val2) {
        tmp[j] = this.listmovie.results[i];
        j = j + 1;
      }
      i = i + 1;
    }
    this.listmovie.results = tmp;
  }*/
  /*filtreGenre(list: SearchMovieResponse) {
    let i = 0;
    let j = 0;
    let tmp: MovieResult[] = null;
    while (i != this.listmovie.results.length) {
      if (this.listmovie.results[i].genre_ids) {
        tmp[j] = this.listmovie.results[i];
        j = j + 1;
      }
      i = i + 1;
    }
    this.listmovie.results = tmp;
  }
  filtreLangue(id: string, list: SearchMovieResponse) {
    var contenu = document.getElementById(id).innerHTML;
    let tmp: MovieResult[] = null;
    let i = 0;
    let j = 0;
    if (contenu == "Toutes les langues") {
      this.listmovie = this.listmovie;
    } else {
      while (i != this.listmovie.results.length) {
        if (this.listmovie.results[i].original_language == contenu) {
          tmp[j] = this.listmovie.results[i];
          j = j + 1;
        }
        i = i + 1;
      }
    }
    this.listmovie.results = tmp;
  }*/
}
