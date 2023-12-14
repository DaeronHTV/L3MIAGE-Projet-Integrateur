import { Component, Input, Query, ɵConsole } from '@angular/core';
import { SearchService } from '../package/service/search.service';
import { HaveABackPicture, HaveAPosterPicture, HaveADescription, HaveAnOriginalLanguage, HaveVote, ForAdult, HaveAPublishedYear, HaveACreationYear, HaveIngredient } from '../package/function/boolean';
import { DetailsService } from '../package/service/details.service';

@Component({
  selector: 'app-queryresult',
  templateUrl: './queryresult.component.html',
  styleUrls: ['./queryresult.component.scss']
})
export class QueryresultComponent {
  pages: number[];
  currentpage: number;
  lastpage: number;
  firstpage: number;

  constructor(public srch: SearchService, public det: DetailsService) {
    this.pages = [1, 2, 3, 4, 5];
    this.lastpage = 5;
    this.firstpage = 1;
    this.pages.length = 5;
    this.currentpage = 1;
  }

  setCurrentPage(currentpage: number): void{
    console.log(currentpage);
    console.log(this.srch.getNumberPages());
    if(currentpage > 0 && currentpage < this.srch.getNumberPages()){ //Ca avance
      console.log("premier test passé");
      this.currentpage = currentpage;
      this.srch.researchMovie({query: this.srch.getRequete().query, page: this.currentpage});
      this.srch.researchSerie({query: this.srch.getRequete().query, page: this.currentpage});
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
  FirstAirDate(item: any): boolean{return HaveACreationYear(item);}
  Ingredient(item: any): boolean{return HaveIngredient(item);}
  async setMovie(item:any){this.det.setMovieDetails(item);}
  async setSerie(item: any){this.det.setSerieDetails(item);}
}