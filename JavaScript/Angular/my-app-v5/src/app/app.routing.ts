import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { VideoListComponent } from './video-list/video-list.component';
import { VideoDetailsComponent } from './video-details/video-details.component';
import { SearchDetailComponent } from './search-detail/search-detail.component';

const appRoutes: Routes = [
    {
        path: "videos/:slug",
        component: VideoDetailsComponent,
    },
    {
        path: "videos",
        component: VideoListComponent,
    },
    {
        path:"search",
        component: SearchDetailComponent,
    },
    {
        path: "",
        component: HomeComponent,
    },

]

@NgModule({
    imports: [
        RouterModule.forRoot(
            appRoutes
        )
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule{}