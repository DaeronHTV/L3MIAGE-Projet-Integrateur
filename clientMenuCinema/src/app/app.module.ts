import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
/*import firebase*/
import { AngularFireModule } from '@angular/fire';
import { AngularFireAnalyticsModule } from '@angular/fire/analytics';
import { AngularFirestoreModule } from '@angular/fire/firestore';
import {AngularFireAuthModule} from '@angular/fire/auth';
/*****************/
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {TmdbService} from './tmdb.service';
import {SearchService} from './package/service/search.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { from } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoginComponent } from './login/login.component';
import { CarouselComponent } from './carousel/carousel.component';
import { QueryresultComponent } from './queryresult/queryresult.component';
import { FormsigninComponent } from './formsignin/formsignin.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AuthClientService } from './auth-client.service';
import { DetailsComponent } from './details/details.component';
import { ContactComponent } from './contact/contact.component';
import { CartComponent } from './cart/cart.component';
import { MovieComponent } from './carousel/movie/movie.component';
import { SerieComponent } from './carousel/serie/serie.component';
import { ProductService } from './package/service/product.service';
import { CommandeComponent } from './commande/commande.component';
import { PlatComponent } from './carousel/plat/plat.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CarouselComponent,
    QueryresultComponent,
    FormsigninComponent,
    DetailsComponent,
    ContactComponent,
    MovieComponent,
    SerieComponent,
    CommandeComponent,
    CartComponent,
    PlatComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AngularFireModule.initializeApp(environment.firebase, 'MenuCinema'),
    AngularFireAuthModule,
    AngularFireAnalyticsModule,
    AngularFirestoreModule,
    NgbModule
  ],
  providers: [TmdbService, HttpClient, AuthClientService, SearchService,ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
