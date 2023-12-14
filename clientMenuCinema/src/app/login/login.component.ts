import { Component, OnInit } from '@angular/core';
import {auth, User} from 'firebase/app';
import {AngularFireAuth} from '@angular/fire/auth';
import { HttpClient, HttpResponse, HttpParams } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { AuthClientService, Client } from '../auth-client.service';
import { Observable } from 'rxjs';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  isCollapsedAdresse : boolean;

  constructor(private authClient: AuthClientService, private modalService: NgbModal, config: NgbModalConfig) {
    authClient.client
    this.isCollapsedAdresse = true;
  }
 
  loginGoogle() {
    this.authClient.loginGoogle();
  }
 
  ngOnInit(): void {
  }
 
  get clientObs(): Observable<Client> {
    return this.authClient.client;
  }

  
  get alreadyLogged(): Observable<boolean> {
    return this.authClient.alreadyLogged;
  }

  logout() {
    this.authClient.logout();
  }

  async onSubmit(f: NgForm) {
    this.authClient.updateUser(f);
  }

  openVerticallyCentered(content) {
    this.modalService.open(content, { centered: true });
  }

  modale(){   
    document.getElementById("buttonModal").click();
  }
}
