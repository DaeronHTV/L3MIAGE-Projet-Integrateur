import { Injectable } from '@angular/core';

import { Product } from '../../entity/product.entity';
import { AppComponent } from '../../app.component';
import { HttpHeaders, HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { SearchService } from './search.service';
import { BDDPlat, Plat, PlatResponse, PlatQuery } from '../interface/Plat';
import { DetailsService } from '../../package/service/details.service';
import { MovieResponse } from 'src/app/tmdb-data/Movie';
import { AuthClientService, Client } from 'src/app/auth-client.service';


@Injectable()
export class ProductService {

    private products: BDDPlat["plats"];
    private idCmd : string;
    commande = {
      idClient : null,
      adresseLivraison : null,
      idPlats : null,
      idFilms : null,
      date : null,
      prix : null
    };
    private client : Client;

    constructor(private authClient: AuthClientService, private srch: SearchService , private DetailsServie : DetailsService, private http: HttpClient) {

      this.products = this.srch.getAllPlatResponse().plats;
      this.authClient.client.subscribe(cli => {this.client = cli});
    }

    findAll(): BDDPlat["plats"] {
    
        return this.products;
    
    }


    find(id: string): Plat {
        
         return  this.products[this.getSelectedIndex(id)];
        
    }

    private getSelectedIndex(id: string) {
        for (var i = 0; i < this.products.length; i++) {
            if (this.products[i].id == id) {
                return i;
            }
        }
        return -1;
    }

    private POST(url: string, params: {[key: string]: string}): Promise<HttpResponse<string>> {
      const P = new HttpParams( {fromObject: params} );
      return this.http.post( url, P, {
        observe: 'response',
        responseType: 'text',
        headers: {'content-type': 'application/x-www-form-urlencoded'}
      }).toPromise();
    }
    async saveCommande( idPlats : string[] , idFilms : string[], nomFilms : string[]) {

        this.commande.idClient = this.client.id;
        this.commande.adresseLivraison = this.client.adresse;

        var idFilmsJson = JSON.stringify( idFilms );
        var idPlatsJson = JSON.stringify( idPlats );
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); // janvier c'est 0 !
        var yyyy = today.getFullYear();

        let day =   yyyy+"-"+mm+"-"+dd ;
 
        this.commande.idFilms = idFilmsJson; 
        this.commande.idPlats = idPlatsJson; 
        this.commande.date = day ;
        
       const reponseServeur =  await this.POST('api/commande', this.commande);

        console.log('Le serveur répond', reponseServeur);	
        console.log('reponse', reponseServeur.body);
        this.authClient.actuClient()
        this.idCmd = reponseServeur.body;
        this.getFacture(this.idCmd,nomFilms);
      

	}


    getIdCmd(){
      
      return this.idCmd ;

    }

    getFacture(id : string, nomFilms : string[]){

        const headers = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');
        var nomFilmsJson = JSON.stringify( nomFilms );
        let laCommande = {
          idcmd : id ,
          nomFilms : nomFilmsJson 
        };
        const P = new HttpParams( {fromObject: laCommande} );

        this.http.post('/api/fact.xml', P,
        {
          responseType: 'arraybuffer',
          headers : headers}
         ).subscribe(response => this.downLoadFile(response,id));
    
    
      }
      
    
    getFactureHisto(id){
      const headers = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');
        
        const P = new HttpParams( {fromObject: {idcmd : id}} );

        this.http.post('/api/factureHisto', P,
        {
          responseType: 'arraybuffer',
          headers : headers}
         ).subscribe(response => this.downLoadFile(response,id));
    }


    downLoadFile(data: any, id : any) {
        const blob: Blob = new Blob([data], {type: 'text/xml'});
        const fileName: string = 'facture_'+id+'.xml';
        const objectUrl: string = URL.createObjectURL(blob);
        const a: HTMLAnchorElement = document.createElement('a') as HTMLAnchorElement;
    
        a.href = objectUrl;
        a.download = fileName;
        document.body.appendChild(a);
        a.click();        
    
        document.body.removeChild(a);
        URL.revokeObjectURL(objectUrl);
    }
    
    private GET(url: string): Promise<any> {
      const headers = new HttpHeaders().set('Content-Type', 'application/json ; charset=UTF-8');
      return this.http.get<any>(url, { responseType: 'json', headers: headers, observe: 'response' }).toPromise();
    }

    private getCMD(id : string ): Promise<any> {

      const headers = new HttpHeaders().set('Content-Type', 'application/json ; charset=UTF-8');
      let idcmd = new HttpParams();
      idcmd = idcmd.set('idCommande',id)
      return this.http.post('/api/commandeInfos', idcmd,
      {
        responseType: 'json', headers: headers, observe: 'response'
      }
       ).toPromise();
  
      
    }
  
    async getCommande(id : string) {
      const cmd = await this.getCMD(id);
      var commande = cmd.body.commande;
      console.log("la commande", commande);
      return commande;     
      }
    
  

}
