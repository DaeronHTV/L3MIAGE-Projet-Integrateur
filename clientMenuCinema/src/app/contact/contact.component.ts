import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../package/model/user';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent{
  envoie: boolean;
  private users: User;
  userSubject = new Subject<User>();

  constructor(private http: HttpClient){this.envoie=false;}
  
  setEnvoye(envoie: boolean): void{this.envoie = envoie;}
  Envoye(): boolean{return this.envoie;}
}
