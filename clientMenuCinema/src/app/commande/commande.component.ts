import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthClientService, Client } from '../auth-client.service';
import { Observable } from 'rxjs';
import { TmdbService } from '../tmdb.service';
import { MovieResponse } from '../tmdb-data/Movie';
import { PlatResponse } from '../package/interface/Plat';
import { ProductService } from '../package/service/product.service';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.scss']
})
export class CommandeComponent implements OnInit {

  nomFilm = []
  nomPlat = []

  constructor(private tmdb: TmdbService, private ps : ProductService, private activatedRoute: ActivatedRoute, private authClient: AuthClientService ) { 
    this.authClient.client.subscribe(c=>{
      this.nomFilm = [];
      this.nomPlat = [];
      c.commandes.forEach(comm => {
        comm.date = comm.date.substring(0,10);
        comm.idFilms.forEach(async (film : string) => {
          let nom;
          let id : number = Number(film.substring(1));
          
          console.log(id);
          if(film.substring(0,1) == "m"){
            
            nom = (await this.tmdb.getMovie(id)).title;
            
          }else{
            nom = await (await (this.tmdb.getTV(id))).name;
          }
          this.nomFilm.push({id:film, nom: nom})
        });

        comm.idPlats.forEach( async (plat : string) => {
          let nom = ( await this.ps.find(plat)).nom;
          this.nomPlat.push({id : plat, nom : nom})
        })
      }); 
      console.log(this.nomPlat);
      
    })

  }

  getNameOfFilm(id){
    return this.nomFilm.find(film => {return film.id == id}).nom
  }

  get clientObs(): Observable<Client> {
    return this.authClient.client;
  }


  ngOnInit(): void {
  }
  getNameOfPlat(id){
    return this.nomPlat.find(plat => {return plat.id == id}).nom
  }

  getFacture(id){
    this.ps.getFactureHisto(id);
  }
}
