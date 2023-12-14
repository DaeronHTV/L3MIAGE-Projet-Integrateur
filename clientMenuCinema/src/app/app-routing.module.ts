import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { QueryresultComponent } from './queryresult/queryresult.component';
import { DetailsComponent } from './details/details.component';
import { AppComponent } from './app.component';
import { CarouselComponent } from './carousel/carousel.component';
import { ContactComponent } from './contact/contact.component';
import { MovieComponent } from './carousel/movie/movie.component';
import { SerieComponent } from './carousel/serie/serie.component';
import { PlatComponent } from './carousel/plat/plat.component';
import { CartComponent } from './cart/cart.component';
import { CommandeComponent } from './commande/commande.component';


const routes: Routes = [
  {path: 'queryresult', component: QueryresultComponent},
  {path: 'details', component: DetailsComponent},
  {path: '', component: CarouselComponent},
  {path: 'contact', component: ContactComponent},
  { path: 'cart', component: CartComponent },
  { path: 'carousel/movie', component: MovieComponent},
  { path: 'carousel/serie', component: SerieComponent},
  { path: 'carousel/plat', component: PlatComponent},
  { path: 'login/commande', component: CommandeComponent},
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    scrollPositionRestoration: 'enabled'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }


