import { Component } from '@angular/core';
import { TmdbService } from '../tmdb.service';
import { environment } from 'src/environments/environment';
import {HaveABackPicture, HaveAPosterPicture, HaveBudget, HaveDuration, HaveARealisator, HaveVote, HaveAGender, HaveACreationYear, HaveAEpisodeRuntime, HaveADescription, HaveAFilm, HaveASerie, haveAFacePicture} from '../package/function/boolean';
import { DetailsService } from '../package/service/details.service';
import { MovieResponse } from '../tmdb-data/Movie';
import { TVResponse } from '../tmdb-data/TV';
import { MovieResult } from '../tmdb-data/searchMovie';
import { TVResult } from '../tmdb-data/SearchTV';
import { SearchReviewResponse } from '../package/interface/Reviews';
import { PersonResult } from '../package/interface/Credits';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent{
  constructor(private tmdb: TmdbService, public det: DetailsService){ this.init();}

  async init(){this.tmdb.init( environment.tmdbKey );}

  getMovie(): MovieResponse{return this.det.getMovie();}
  getRecommandedMovie(): MovieResult[]{return this.det.getRecommandedMovie();}
  getReviewsMovie(): SearchReviewResponse{return this.det.getReviewsMovie();}
  getCastingMovie(): PersonResult[]{
    console.log(this.det.getCastingMovie());
    return this.det.getCastingMovie();
  }
  async setMovie(item:any){this.det.setMovieDetails(item);}

  getSerie(): TVResponse{return this.det.getSerie();}
  getRecommandedSerie(): TVResult[]{return this.det.getRecommandedSerie();}
  getReviewsSerie(): SearchReviewResponse {return this.det.getReviewsSerie();}
  getCastingSerie(): PersonResult[]{return this.det.getCastingSerie();}
  async setSerie(item: any){this.det.setSerieDetails(item);}
  




  Film(item: any): boolean{return HaveAFilm(item);}
  Serie(item: any): boolean{return HaveASerie(item);}
  BackPicture(item: any): boolean{return HaveABackPicture(item);}
  PosterPicture(item: any): boolean{return HaveAPosterPicture(item);}
  HaveBudget(item: any): boolean{return HaveBudget(item);}
  HaveDuration(item: any): boolean{return HaveDuration(item);}
  HaveRealisator(item: any): boolean{return HaveARealisator(item);}
  HaveVoteCount(item: any): boolean{return HaveVote(item);}
  HaveGender(item: any): boolean{return HaveAGender(item);}
  HaveAirDate(item: any): boolean{return HaveACreationYear(item);}
  HaveEpisodeRuntime(item: any): boolean{return HaveAEpisodeRuntime(item);}
  HaveDescription(item: any): boolean{return HaveADescription(item);}
  FacePicture(item: any): boolean{return haveAFacePicture(item);}
}
