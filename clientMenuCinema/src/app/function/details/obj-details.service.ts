import { Injectable } from '@angular/core';
import { TVGenre } from '../../tmdb-data/TV';
import { MovieResponse } from '../../tmdb-data/Movie';


@Injectable({
  providedIn: 'root'
})
export class ObjDetailsService {
  private object: any;

  constructor() {this.init();}

  init(): void{this.object = null;}

//_________________________________________________________________
// OBJECT _________________________________________________________
//_________________________________________________________________
  getObject(): any{return this.object;}
  setObject(item: any): void{this.object = item;}

//_________________________________________________________________
// Propriétés communes de les Movies et TV_________________________
//_________________________________________________________________
  getDescription(): string{return this.object.overview;}
  getWebSite(): string{return this.object.homepage;}
  getPopularity(): string{return this.object.popularity;}
  getID(): number{return this.object.id;}
  getBackPicture(): string{return this.object.backdrop_path;}
  getPosterPictre(): string{return this.object.poster_path;}
  getNote(): number{return this.object.vote_average;}
  getNumNote(): number{return this.object.vote_count;}
  //_______________________________________________________________
  // Fonctions booléennes__________________________________________
  //_______________________________________________________________
    haveABackPicture(): boolean{return this.object.backdrop_path !== null}
    haveAPosterPicture(): boolean{return this.object.poster_path !== null}
    forAdult(): boolean{return this.object.adult;}
    haveVote(): boolean{return this.object.vote_count !==0}
    havePopularity():boolean{return this.object.popularity !==0;}
    haveAGender(): boolean{return this.object.genres.length !== 0;}
    haveADescription(): boolean{return this.object.overview !== "";}
    //______________________________________________________________//
    objHaveAGender(item: any): boolean{return item.genres.length !==0;}
    objHavePopularity(item: any): boolean{return item.popularity !==0;}
    objHaveVote(item: any): boolean{return item.vote_count !==0;}
    objForAdult(item: any): boolean{return item.adult;}
    objHaveABackPicture(item: any): boolean{return item.backdrop_path !== null;}
    objHaveAPosterPicture(item: any): boolean{return item.poster_path !== null}
    objHaveADescription(item: any): boolean{return item.overview !== "";}
    objHaveAnOriginalLanguage(item: any): boolean{return item.original_language !== null}
//_________________________________________________________________
// Propriétés spécifiques des séries TV____________________________
//_________________________________________________________________
  getNEpisodes(): number{return this.object.number_of_episodes;}
  getNSeasons(): number{return this.object.number_of_seasons;}
  getTVGenre(): TVGenre{return this.object.genres;}
  getCountries(): string[]{return this.object.origin_country;}
  getCreationYear(): string{return this.object.first_air_date;}
  //_______________________________________________________________
  // Fonctions booléennes__________________________________________
  //_______________________________________________________________
    haveACreationYear(): boolean{return this.object.first_air_date !== null}

    objHaveACreationYear(item: any){return item.first_air_date !== null;}

//_________________________________________________________________
// Propriétés spécifiques des films________________________________
//_________________________________________________________________

  //_______________________________________________________________
  // Fonctions booléennes__________________________________________
  //_______________________________________________________________
    haveAPublishedYear(): boolean{return this.object.release_date !== null;}

    objHaveAPublishedYear(item : any): boolean{return item.release_date !== null;}
}
