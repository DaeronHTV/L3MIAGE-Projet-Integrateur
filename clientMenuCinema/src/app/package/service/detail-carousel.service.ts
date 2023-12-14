import { Injectable } from '@angular/core';
import { MovieResult } from 'src/app/tmdb-data/searchMovie';
import { TVResult } from 'src/app/tmdb-data/SearchTV';

@Injectable({
  providedIn: 'root'
})
export class DetailCarouselService {
  type: string;
  object: string;

  constructor(){ }

  setElement(type: string, object: string): void{
    this.setType(type);
    this.setObject(object);
  }
  setType(type: string): void{this.type = type;}
  getType(): string{return this.type;}
  setObject(object: string): void{this.object = object;}
  getObject(): string{return this.object;}
}
