import { Component, OnInit } from '@angular/core';
import {TmdbService} from '../../tmdb.service';
import { SearchService } from '../../package/service/search.service';
import { HaveIngredient } from '../../package/function/boolean';
import { Plat, BDDPlat } from '../../package/interface/Plat';
import {getARandomNumber} from '../../package/function/calcul';
import {environment} from '../../../environments/environment';
import { DetailsService } from '../../package/service/details.service';

@Component({
    selector: 'app-plat',
    templateUrl: './plat.component.html',
    styleUrls: ['./plat.component.scss']
})
export class PlatComponent {

    constructor(private tmdb: TmdbService, public ods: DetailsService, public srch: SearchService) { 
      this.tmdb.init( environment.tmdbKey );
    }

    getAllPlat(): BDDPlat{return this.srch.getAllPlatResponse();}
        

    Ingredient(item: any): boolean { return HaveIngredient(item); }
}