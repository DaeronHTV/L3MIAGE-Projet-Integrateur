import { Injectable } from '@angular/core';
import { MovieResult, SearchMovieResponse } from 'src/app/tmdb-data/searchMovie';
import { TVResult } from 'src/app/tmdb-data/SearchTV';
import { TVResponse } from 'src/app/tmdb-data/TV';
import { MovieResponse } from 'src/app/tmdb-data/Movie';
import { TmdbService } from 'src/app/tmdb.service';
import { environment } from 'src/environments/environment';
import { Plat } from '../interface/Plat';
import { SearchReviewResponse } from '../interface/Reviews';
import { CreditsResponse, PersonResult } from '../interface/Credits';

@Injectable({
  providedIn: 'root'
})
export class DetailsService {
  movie: MovieResponse; //Le film dont il faut afficher les détails
  serie: TVResponse; //La série dont il faut afficher les détails
  recommandedserie: TVResult[];
  recommandedmovie: MovieResult[];
  reviewsmovie: SearchReviewResponse;
  reviewsserie: SearchReviewResponse;
  creditmovie: CreditsResponse;
  creditserie: CreditsResponse;
  type: string;

  constructor(private tmdb: TmdbService) { this.tmdb.init( environment.tmdbKey );}

  getMovie(): MovieResponse {return this.movie;}
  getRecommandedMovie(): MovieResult[] {return this.recommandedmovie;}
  getReviewsMovie(): SearchReviewResponse {return this.reviewsmovie;}
  getCreditsMovie(): CreditsResponse{return this.creditmovie;}
  getCastingMovie(): PersonResult[]{return this.creditmovie.cast;}
  async setMovieDetails(item: MovieResult){ //Permet de récupérer l'ensemble des détails d'un film
    this.type = 'film';
    this.movie = await this.tmdb.getMovie(item.id);
    this.recommandedmovie = await (await this.tmdb.getRecommandedMovie(item.id)).results;
    this.reviewsmovie = await(this.tmdb.getReviewsMovie(item.id));
    this.creditmovie = await(this.tmdb.getCreditsMovie(item.id));
    let i = 0;
    while(i !== this.getCastingMovie.length){
      this.creditmovie.cast[i].picture_path = await (await(this.tmdb.getPicturePerson(this.creditmovie.cast[i].id))).profiles[0].filepath;
      i++;
    }
    console.log(this.recommandedmovie);
    console.log(this.reviewsmovie);
    console.log(this.creditmovie);
  }

  getSerie(): TVResponse{return this.serie;}
  getRecommandedSerie(): TVResult[]{return this.recommandedserie;}
  getReviewsSerie(): SearchReviewResponse {return this.reviewsserie;}
  getCreditsSerie(): CreditsResponse{return this.creditserie;}
  getCastingSerie(): PersonResult[]{return this.creditserie.cast;}
  async setSerieDetails(item: TVResult){ //Permet de récupérer l'ensemble des détails d'une série
    this.type = 'serie';
    this.serie = await this.tmdb.getTV(item.id);
    this.recommandedserie = await (await this.tmdb.getRecommandedTV(item.id)).results;
    this.reviewsserie = await(this.tmdb.getReviewsSerie(item.id));
    this.creditserie = await(this.tmdb.getCreditsTV(item.id));
    let i = 0;
    while(i !== this.getCastingSerie.length){
      this.creditserie.cast[i].picture_path = await (await(this.tmdb.getPicturePerson(this.creditserie.cast[i].id))).profiles[0].filepath;
      i++;
    }
    console.log(this.recommandedserie);
    console.log(this.reviewsserie);
    console.log(this.creditserie);
  }

  setType(type :string): void{this.type = type;}
  getType(): string{return this.type;}
  
  getAverageTime(): number{
    let result = 0;
    let i = 0;
    while(i !== this.serie.episode_run_time.length){
      result = result + this.serie.episode_run_time[0];
      i++;
    }
    return (result/this.serie.episode_run_time.length);
  }
}



