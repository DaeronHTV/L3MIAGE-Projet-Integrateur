import { Component } from '@angular/core';
import { SearchService } from 'src/app/package/service/search.service';
import { DetailsService } from 'src/app/package/service/details.service';
import { HaveABackPicture, HaveAPosterPicture, HaveADescription, HaveAnOriginalLanguage, HaveVote, ForAdult, HaveAPublishedYear } from 'src/app/package/function/boolean';
import { MovieResult } from 'src/app/tmdb-data/searchMovie';
import { DetailCarouselService } from 'src/app/package/service/detail-carousel.service';
import { MovieResponse } from 'src/app/tmdb-data/Movie';
import { environment } from 'src/environments/environment';
import { TmdbService } from 'src/app/tmdb.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss']
})
export class MovieComponent {
  pages: number[];
  totalpage: number;
  currentpage: number;
  lastpage: number;
  firstpage: number;
  listmovie: MovieResponse[];

  constructor(private tmdb: TmdbService,public det: DetailsService, private dtc: DetailCarouselService){
    this.init();
  }

  async init(){
    this.tmdb.init( environment.tmdbKey );
    if(this.dtc.getType() === 'populaire'){
      let temp = await (this.tmdb.discoverMovie({sort_by: "popularity.desc"}));
      this.listmovie = temp.results;
      this.totalpage = temp.total_pages;
    }else if(this.dtc.getType() === 'note'){
      let temp = await this.tmdb.discoverMovie({sort_by: "vote_average.desc"});
      this.listmovie = temp.results;
      this.totalpage = temp.total_pages;
    }
    this.pages = [1, 2, 3, 4, 5];
    this.lastpage = 5;
    this.firstpage = 1;
    this.pages.length = 5;
    this.currentpage = 1;
  }


  async setCurrentPage(currentpage: number){
    console.log(currentpage);
    console.log(this.totalpage);
    if(currentpage > 0 && currentpage < this.totalpage){ //Ca avance
      console.log("premier test passé");
      this.currentpage = currentpage;
      if(this.dtc.getType() === 'populaire'){
        this.listmovie = await (await (this.tmdb.discoverMovie({sort_by: "popularity.desc", page: this.currentpage}))).results; 
      }else if(this.dtc.getType() === 'note'){
        this.listmovie = await(await this.tmdb.discoverMovie({sort_by: "vote_average.desc", page: this.currentpage})).results;
      }
      if(this.currentpage >= this.lastpage){
        let i = 0;
        while(i != 5){
          this.pages[i] = this.pages[i] + 5;
          i++;
        }
        this.firstpage = this.pages[0];
        this.lastpage = this.pages[4];
      }else if(this.currentpage < this.firstpage){
        let i = 0;
        while(i != 5){
          this.pages[i] = this.pages[i] - 5;
          i++;
        }
        this.firstpage = this.pages[0];
        this.lastpage = this.pages[4];
      }
    }
    console.log(this.currentpage);
    console.log(this.lastpage);
  }

  BackPicture(item: any): boolean{return HaveABackPicture(item);}
  PosterPicture(item: any): boolean{return HaveAPosterPicture(item);}
  Description(item: any): boolean{return HaveADescription(item);}
  OriginalLanguage(item: any): boolean{return HaveAnOriginalLanguage(item);}
  Vote(item: any): boolean{return HaveVote(item);}
  Adult(item: any): boolean{return ForAdult(item);}
  PublishedYear(item: any): boolean{return HaveAPublishedYear(item);}
  async setMovie(item:any){this.det.setMovieDetails(item);}
  async setSerie(item: any){this.det.setSerieDetails(item);}
  getObject(): string{return this.dtc.getObject();}
  setObject(type: string): void{this.dtc.setObject(type);}
  getType(): string{return this.dtc.getType();}
  /*async setType(type: string){
    this.setType(type);
    if(type === 'populaire'){
      let temp = await (this.tmdb.discoverMovie({sort_by: "popularity.desc"}));
      this.listmovie = temp.results;
      this.totalpage = temp.total_pages;
    }else if(type === 'note'){
      let temp = await this.tmdb.discoverMovie({sort_by: "vote_average.desc"});
      this.listmovie = temp.results;
      this.totalpage = temp.total_pages;
    }
  }*/
}




  
  

  
