import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Product } from '../entity/product.entity';
import { Item } from '../entity/item.entity';
import { ProductService } from '../package/service/product.service';
import { DetailsService } from 'src/app/package/service/details.service';
import { MovieResponse } from 'src/app/tmdb-data/Movie';
import { TVResponse } from 'src/app/tmdb-data/TV';
import { AuthClientService, Client } from '../auth-client.service';
import { Observable, throwError } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
	templateUrl: 'cart.component.html',
	styleUrls: ['cart.component.scss']
})

export class CartComponent implements OnInit {

	public items: Item[] = [];
	private itemtype: string ;
	public total: number = 0;
	private idCommande: string ;
	private nomFilms: string[];
	public price: number = 3.75 ; 
	public commandeSaved : boolean = false ;
	public date : Date;


	constructor(
		private activatedRoute: ActivatedRoute,
		private productService: ProductService,
		private DetailsService : DetailsService,
		private authClient: AuthClientService
	) { authClient.client}
		
	ngOnInit() {
		this.activatedRoute.params.subscribe(params => {
			var id = params['id'];

			let itemo = null ;
		
			if (id) {

				var type = id.split('-');
				this.itemtype = type[1]; 
				switch(type[1]){

					case 'plat':
						itemo =  this.productService.find(type[0]);
						break; 

					case 'film':
						itemo = this.DetailsService.getMovie();
						break;

					case 'serie':
						itemo = this.DetailsService.getSerie();
						break;
					default:
						console.log("Type non trouvé")

				}
				
				id = type[0];

				var item: Item = {
					product : itemo,
					quantity: 1
				};

				if (localStorage.getItem('cart') == null) {
					let cart: any = [];
					cart.push(JSON.stringify(item));
					localStorage.setItem('cart', JSON.stringify(cart));

				} else {
					let cart: any = JSON.parse(localStorage.getItem('cart'));
					let index: number = -1;
					
					for (var i = 0; i < cart.length; i++) {
						let item: Item = JSON.parse(cart[i]);
						if (item.product.id == id) {
							index = i;
							break;
						}
					}
					if (index == -1) {
						cart.push(JSON.stringify(item));
						localStorage.setItem('cart', JSON.stringify(cart));
					} else {
						let item: Item = JSON.parse(cart[index]);
						item.quantity += 1;
						cart[index] = JSON.stringify(item);
						localStorage.setItem("cart", JSON.stringify(cart));
					}
				}
				this.loadCart();
			} else {
				this.loadCart();
			}
		});
	}

	loadCart(): void {
		this.total = 0;
		this.items = [];
		let cart = JSON.parse(localStorage.getItem('cart'));
		for (var i = 0; i < cart.length; i++) {
			let item = JSON.parse(cart[i]);
			this.items.push({
				product: item.product,
				quantity: item.quantity
			});
			if(item.product.prix != null)
				{this.total += item.product.prix * item.quantity;}
			else
				{this.total += this.price * item.quantity;}
		}
	}

	remove(id: string): void {
		let cart: any = JSON.parse(localStorage.getItem('cart'));
		let index: number = -1;
		for (var i = 0; i < cart.length; i++) {
			let item: Item = JSON.parse(cart[i]);
			if (item.product.id == id) {
				cart.splice(i, 1);
				break;
			}
		}
		localStorage.setItem("cart", JSON.stringify(cart));
		this.loadCart();
	}

	quantiteUP(id : string){

		let cart: any = JSON.parse(localStorage.getItem('cart'));
		let index: number = -1;
					
					for (var i = 0; i < cart.length; i++) {
						let item: Item = JSON.parse(cart[i]);
						if (item.product.id == id) {
							index = i;
							break;
						}
					}
					
						let item: Item = JSON.parse(cart[index]);
						item.quantity += 1;
						cart[index] = JSON.stringify(item);
						localStorage.setItem("cart", JSON.stringify(cart));
						this.loadCart();

	}

	quantiteDown(id: string){
	let cart: any = JSON.parse(localStorage.getItem('cart'));
					let index: number = -1;
					
					for (var i = 0; i < cart.length; i++) {
						let item: Item = JSON.parse(cart[i]);
						if (item.product.id == id) {
							index = i;
							break;
						}
					}
					
						let item: Item = JSON.parse(cart[index]);
						item.quantity -= 1;
						cart[index] = JSON.stringify(item);
						localStorage.setItem("cart", JSON.stringify(cart));
						this.loadCart();

	}

	saveCommande(){

		let idFilms : string[] = []
		let idPlats : string[] = []
		let nomFilms : string[] = [] 

		for(let item of this.items ){

			if(this.isPlat(item)){

				for(let  i=0; i<item.quantity ; i++){
				console.log(item.product.id) ;
				idPlats.push(String(item.product.id)); 
				}

			}else{

				if(this.isFilm(item)){

					for(let  i=0; i<item.quantity ; i++){
						console.log(item.product.id) ;
						idFilms.push(String('m'+item.product.id));
						nomFilms.push(item.product.title); 
					}

				}else{

					for(let  i=0; i<item.quantity ; i++){
						console.log(item.product.id) ;
						idFilms.push(String('s'+item.product.id));
						nomFilms.push(item.product.name) ; 
					}

				}
			
			}
		}

		this.productService.saveCommande(idPlats, idFilms, nomFilms).catch(
			(error: HttpErrorResponse) => {
			let errorMessage = '';
			if (error.error instanceof ErrorEvent) {
			  // client-side error
			  errorMessage = `Error: ${error.error.message}`;
			} else {
			  // server-side error
			  errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
			}
			window.alert(errorMessage);
			return throwError(errorMessage);
		  });
		this.nomFilms = nomFilms;
		this.commandeSaved = true ; 
		localStorage.clear();
	}

	itemSize() : number{

		return this.items.length ;
	}

	isFilm( itemo : Item ){

		return itemo.product.title != null ;

	}

	isSerie( itemo : Item ){

		return itemo.product.name != null ;

	}

	isPlat( itemo : Item ){

		return itemo.product.prix != null ;

	}

	date_commande() : string{
		this.date = new Date();
		let date_jour : string;
		let mois;
		mois = this.date.getMonth() + 1;
		date_jour = this.date.getDate() + "/" + mois + "/" + this.date.getFullYear() + " à " + this.date.getHours() + ":" + this.date.getMinutes();
		console.log(date_jour);
		return date_jour;
	}
	
	getFacture(){

		this.idCommande = this.productService.getIdCmd();
		this.productService.getFacture(this.idCommande,this.nomFilms);


	}
	get alreadyLogged(): Observable<boolean> {
		return this.authClient.alreadyLogged;
	}

	get clientObs(): Observable<Client> {
		return this.authClient.client;
	  }
	

}
