import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http'; 

// Third party imports
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { CarouselModule } from 'ngx-bootstrap/carousel';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';
import { VideoListComponent } from './video-list/video-list.component';
import { VideoDetailsComponent } from './video-details/video-details.component';
import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search/search.component';
import { SearchDetailComponent } from './search-detail/search-detail.component';
import { SafePipe } from './utility/safe.pipe';


@NgModule({
  declarations: [
    AppComponent,
    VideoListComponent,
    VideoDetailsComponent,
    HomeComponent,
    SearchComponent,
    SearchDetailComponent,
    SafePipe 
  ],
  imports: [
    // ngx-bootstrap
    BsDropdownModule.forRoot(),
    CarouselModule.forRoot(),
    
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
