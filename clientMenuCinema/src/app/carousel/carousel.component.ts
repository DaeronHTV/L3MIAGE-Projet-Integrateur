import { Component, ɵConsole } from '@angular/core';
import {TmdbService} from '../tmdb.service';
import {environment} from '../../environments/environment';
import { MovieResult } from '../tmdb-data/searchMovie';
import { TVResult } from '../tmdb-data/SearchTV';
import {HaveABackPicture, HaveAPosterPicture, HaveIngredient, HaveVote} from '../package/function/boolean';
import { SearchService } from '../package/service/search.service';
import { DetailsService } from '../package/service/details.service';
import { Plat } from '../package/interface/Plat';
import {getARandomNumber} from '../package/function/calcul';
import { DetailCarouselService } from '../package/service/detail-carousel.service';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})

export class CarouselComponent{ 
  charger: boolean = false; //Vérifie le chargement des caroussels
  listplat: Plat[] = [];
  listmoviepopularity: MovieResult[]; //Les films les plus populaires
  listseriepopularity: TVResult[]; //Les séries les plus populaires
  listmovienote: MovieResult[]; //Les films les mieux notés
  listserienote: TVResult[]; //Les séries les mieux notées

  constructor(private tmdb: TmdbService, public ods: DetailsService, private srch: SearchService, public dtc: DetailCarouselService) {this.init();}
  async init(){ //Initialise l'ensemble des composants et des caroussels
    this.tmdb.init( environment.tmdbKey );
    this.listmoviepopularity = await (await this.tmdb.discoverMovie({sort_by: "popularity.desc"})).results;
    this.listseriepopularity = await (await this.tmdb.discoverTV({sort_by: "popularity.desc"})).results;
    this.listmovienote = await(await this.tmdb.discoverMovie({sort_by: "vote_average.desc"})).results;
    this.listserienote = await(await this.tmdb.discoverTV({sort_by: "vote_average.desc"})).results;
    await this.setRandomListPlat();
    this.charger = true;
  }
  estcharger(): boolean{return this.charger;} //Permet de vérifier si les caroussels sont bien chargés
  BackPicture(item: any): boolean{return HaveABackPicture(item);}
  PosterPicture(item: any): boolean{return HaveAPosterPicture(item);}
  HaveVote(item: any): boolean{return HaveVote(item);}
  Ingredient(item: any): boolean{return HaveIngredient(item);}
  async setMovie(item:any){
    console.log(item);
    this.ods.setMovieDetails(item);
  }
  async setSerie(item: any){this.ods.setSerieDetails(item);}
  async setRandomListPlat(){
    let temp = [];let i = 0;
    while(i != 20){
      let id = Math.trunc(getARandomNumber(0, 53));
      while(temp.includes(id)){id = Math.trunc(getARandomNumber(0, 53));}
      temp.push(id);
      i++;
    }
    while(i != 0){this.listplat.push(this.srch.getAllPlatResponse().plats[temp[i-1]]);i--;}
    console.log(this.listplat);
  }
}