import { Injectable } from '@angular/core';
import { User, auth } from 'firebase';

import { map } from 'rxjs/operators';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpResponse, HttpParams, HttpClient } from '@angular/common/http';
import { AngularFireAuth } from '@angular/fire/auth';


export interface Client {
  id: String;
  displayName: string;
  nom: string;
  prenom: string;
  photo: string;
  email: string;
  tel: string;
  adresse: string;
  commandes: any[];
}

@Injectable({
  providedIn: 'root'
})
export class AuthClientService {
  

  private clientSubj = new BehaviorSubject<Client>(undefined);
  client = this.clientSubj.asObservable();
  alreadyLogged: Observable<boolean> = this.client.pipe(
    map( (c: Client) => !!c )
  );
  private uid : String;


  constructor(private afAuth : AngularFireAuth, private http : HttpClient) {

    this.afAuth.user.subscribe( async (u: User) => {
      console.log("L’utilisateur Firebasse est ", u);
      // On contacte le serveur métier pour l'informer si un nouvel utilisateur existe :
      if (u !== null) {
        const reponseServeur = await this.POST('/api/authentification', {userId: u.uid, email : u.email, photo: u.photoURL});
        console.log('Le serveur répond auth:', reponseServeur);
        this.uid = u.uid;
        const clientServeur = JSON.parse(reponseServeur.body).client;
        const commandesServeur = JSON.parse(reponseServeur.body).commandes;
        const c: Client = { 
          id: undefined,
          displayName: undefined,
          nom: undefined,
          prenom: undefined,
          photo: undefined,
          email: undefined,
          tel: undefined,
          adresse: undefined,
          commandes: undefined
        };
        
        // On récupère les infos client...
        if(clientServeur.id != null){ c.id = clientServeur.id; }
        c.displayName = u.displayName;
        if(clientServeur.nom != null){ c.nom = clientServeur.nom };
        if(clientServeur.prenom != null){ c.prenom = clientServeur.prenom };
        c.photo = u.photoURL;
        c.email = u.email;
        if(clientServeur.tel){ c.tel = clientServeur.tel };
        if(clientServeur.adresse){ c.adresse = clientServeur.adresse };
        if(commandesServeur){ c.commandes = commandesServeur };
        console.log(c);
        
        this.clientSubj.next( c );
        if(c.nom == undefined || c.prenom == undefined || c.adresse == undefined){
          document.getElementById("buttonModal").click();
        }
      } else {
        // L'utilisateur se déconnecte, il n'y a plus d'utilisateur courant
        this.clientSubj.next( undefined );
      }
      
    });
   }

   loginGoogle() {
    this.afAuth.signInWithPopup(new auth.GoogleAuthProvider());
  }

   logout() {
    this.afAuth.signOut();
   }

   private POST(url: string, params: {[key: string]: any}): Promise<HttpResponse<string>> {
    const P = new HttpParams( {fromObject: params} );
    return this.http.post( url, P, {
      observe: 'response',
      responseType: 'text',
      headers: {'content-type': 'application/x-www-form-urlencoded'}
    }).toPromise();
  }

  async actuClient(){
    let cli : Client;
    this.client.subscribe(c => {
      cli = c;
    })

    const reponseServeur = await this.POST('/api/getCommandesClient', {uid: this.uid});
    
    const c: Client = { 
      id: undefined,
      displayName: undefined,
      nom: undefined,
      prenom: undefined,
      photo: undefined,
      email: undefined,
      tel: undefined,
      adresse: undefined,
      commandes: undefined
    };
    c.adresse = cli.adresse;
    c.displayName = cli.displayName;
    c.email = cli.email;
    c.id = cli.id;
    c.nom = cli.nom;
    c.photo = cli.photo;
    c.prenom = cli.prenom;
    c.tel = cli.tel;
    c.commandes = JSON.parse(reponseServeur.body);
    console.log("actuClient",c);
    this.clientSubj.next( c );
  }

  async updateUser(f: import("@angular/forms").NgForm) {
    const c: Client = { 
      id: undefined,
      displayName: undefined,
      nom: undefined,
      prenom: undefined,
      photo: undefined,
      email: undefined,
      tel: undefined,
      adresse: undefined,
      commandes: undefined
    };

    c.id = this.clientSubj.value.id;

    c.displayName = this.clientSubj.value.displayName;

    if(f.value.nom != ""){ c.nom = f.value.nom; }
    else { if(this.clientSubj.value.nom != undefined){ c.nom = this.clientSubj.value.nom } };
    
    if(f.value.prenom != ""){ c.prenom = f.value.prenom } 
    else { if(this.clientSubj.value.prenom != undefined){ c.prenom = this.clientSubj.value.prenom } };

    c.photo = this.clientSubj.value.photo;

    if(f.value.email != ""){ c.email = f.value.email } 
    else { if(this.clientSubj.value.email != undefined){ c.email = this.clientSubj.value.email } };

    if(f.value.tel != ""){ c.tel = f.value.tel } 
    else { if(this.clientSubj.value.tel != undefined){ c.tel = this.clientSubj.value.tel } };

    if(f.value.adresse != ""){ c.adresse = f.value.adresse + " " + f.value.codePostal + " " + f.value.ville } 
    else { if(this.clientSubj.value.adresse != undefined){ c.adresse = this.clientSubj.value.adresse } };
    
    c.commandes = this.clientSubj.value.commandes;
    console.log("adzfzf",c)
    const reponseServeur = await this.POST("/api/updateClient", c);
    console.log('Le serveur répond', reponseServeur);
    document.getElementById("closeModal").click();
  }

}
