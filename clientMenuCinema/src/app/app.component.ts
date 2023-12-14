import {Component, OnInit} from '@angular/core';
import {TmdbService} from './tmdb.service';
import {environment} from '../environments/environment';
import {SearchService} from './package/service/search.service';
import { DetailsService } from './package/service/details.service';
import { ProductService } from './package/service/product.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  constructor(private tmdb: TmdbService, private srch: SearchService) {
    this.init();
  }
  async init() {
    this.tmdb.init( environment.tmdbKey );
    await this.srch.getPlats();
  }

  ngOnInit() {
  }

  //Récupère l'ensemble des informations et objets pour la recherche
  async Reasearch(query: string, categorie: string){
    let requete = {query: query};
    await this.srch.doResearch(requete, categorie, query);
  }
}
