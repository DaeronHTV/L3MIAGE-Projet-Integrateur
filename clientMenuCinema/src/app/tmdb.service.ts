import { Injectable } from '@angular/core';
import {MovieQuery, MovieResponse} from './tmdb-data/Movie';
import {HttpClient, HttpParams, HttpResponse} from '@angular/common/http';
import {PersonQuery, PersonResponse} from './tmdb-data/Person';
import {SearchMovieQuery, SearchMovieResponse} from './tmdb-data/searchMovie';
import {SearchPeopleQuery, SearchPeopleResponse} from './tmdb-data/SearchPeople';
import {TVQuery, TVResponse} from './tmdb-data/TV';
import {SearchTVQuery, SearchTVResponse} from './tmdb-data/SearchTV';
import { SearchReviewResponse } from './package/interface/Reviews';
import { PlatQuery, PlatResponse, Query, Plat } from './package/interface/Plat';

const tmdbApi = 'https://api.themoviedb.org/3';
type HTTP_METHOD = 'GET' | 'POST' | 'DELETE' | 'PUT';

function AlxToObjectString(data?: object): {[key: string]: string} {
  const res = {};
  for (const k of Object.keys(data || {}) ) {
    const v = data[k];
    res[k] = typeof v === 'string' ? v : JSON.stringify(v);
  }
  return res;
}

@Injectable({
  providedIn: 'root'
})
export class TmdbService {
  private apiKey: string;

  private async get<T>(url: string, data: object): Promise<HttpResponse<T>> {
    return this.http.get<T>( url, {
      observe: 'response',
      params: {...AlxToObjectString(data), api_key: this.apiKey}
    }).toPromise();
  }

  constructor(private http: HttpClient) {}

  init(key: string): this {
    this.apiKey = key;
    return this;
  }

  // _______________________________________________________________________________________________________________________________________
  // Movies ________________________________________________________________________________________________________________________________
  // _______________________________________________________________________________________________________________________________________
  async getMovie(id: number, options?: MovieQuery): Promise<MovieResponse> {
    const url = `${tmdbApi}/movie/${id}`;
    const res = await this.get<MovieResponse>(url, options);
    return res.body;
  }

  async searchMovie(query: SearchMovieQuery): Promise<SearchMovieResponse> {
    const url = `${tmdbApi}/search/movie`;
    const res = await this.get<SearchMovieResponse>(url, query);
    return res.body;
  }

  async discoverMovie(query: any): Promise<SearchMovieResponse>{
    const url = `${tmdbApi}/discover/movie`;
    const res = await this.get<SearchMovieResponse>(url, query);
    return res.body;
  }

  async getRecommandedMovie(id: number, options?: MovieQuery): Promise<SearchMovieResponse> {
    const url = `${tmdbApi}/movie/${id}/recommendations`;
    const res = await this.get<SearchMovieResponse>(url, options);
    return res.body;
  }

  async getReviewsMovie(id: number, options?: MovieQuery): Promise<SearchReviewResponse>{
    const url = `${tmdbApi}/movie/${id}/reviews`;
    const res = await this.get<SearchReviewResponse>(url, options);
    return res.body;
  }

  async getCreditsMovie(id: number, options?: MovieQuery): Promise<any>{
    const url = `${tmdbApi}/movie/${id}/credits`;
    const res = await this.get<any>(url, options);
    return res.body;
  }
  // _______________________________________________________________________________________________________________________________________
  // Person / People _______________________________________________________________________________________________________________________
  // _______________________________________________________________________________________________________________________________________
  async getPerson(id: number, options?: PersonQuery): Promise<PersonResponse> {
    const url = `${tmdbApi}/person/${id}`;
    const res = await this.get<PersonResponse>(url, options);
    return res.body;
  }

  async getPicturePerson(id: number, options?: PersonQuery): Promise<any>{
    const url = `${tmdbApi}/person/${id}/images`;
    const res = await this.get<any>(url, options);
    return res.body;
  }

  async searchPerson(query: SearchPeopleQuery): Promise<SearchPeopleResponse> {
    const url = `${tmdbApi}/search/person`;
    const res = await this.get<SearchPeopleResponse>(url, query);
    return res.body;
  }

  // _______________________________________________________________________________________________________________________________________
  // TV ____________________________________________________________________________________________________________________________________
  // _______________________________________________________________________________________________________________________________________
  async getTV(id: number, options?: TVQuery): Promise<TVResponse> {
    const url = `${tmdbApi}/tv/${id}`;
    const res = await this.get<TVResponse>(url, options);
    return res.body;
  }

  async searchTV(query: SearchTVQuery): Promise<SearchTVResponse> {
    const url = `${tmdbApi}/search/tv`;
    const res = await this.get<SearchTVResponse>(url, query);
    return res.body;
  }

  async discoverTV(query: any): Promise<SearchTVResponse>{
    const url = `${tmdbApi}/discover/tv`;
    const res = await this.get<SearchMovieResponse>(url, query);
    return res.body;
  }

  async getRecommandedTV(id: number, options?: TVQuery): Promise<SearchTVResponse> {
    const url = `${tmdbApi}/tv/${id}/recommendations`;
    const res = await this.get<SearchTVResponse>(url, options);
    return res.body;
  }

  async getReviewsSerie(id: number, options?: MovieQuery): Promise<SearchReviewResponse>{
    const url = `${tmdbApi}/tv/${id}/reviews`;
    const res = await this.get<SearchReviewResponse>(url, options);
    return res.body;
  }
  async getCreditsTV(id: number, options?: MovieQuery): Promise<any>{
    const url = `${tmdbApi}/tv/${id}/credits`;
    const res = await this.get<any>(url, options);
    return res.body;
  }

// _______________________________________________________________________________________________________________________________________
  // Plats ____________________________________________________________________________________________________________________________________
  // _______________________________________________________________________________________________________________________________________
  async getPlat(id: number, options?: Query): Promise<Plat> {
    const url = `${tmdbApi}/plat/${id}`;
    const res = await this.get<Plat>(url, options);
    return res.body;
  }

  async searchPlat(query: PlatQuery): Promise<PlatResponse> {
    const url = `${tmdbApi}/search/plat`;
    const res = await this.get<PlatResponse>(url, query);
    return res.body;
  }
}