import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Http } from '@angular/http';
import { VideoService } from '../services/video-service/video.service';

@Component({
  selector: 'video-details',
  templateUrl: './video-details.component.html',
  styleUrls: ['./video-details.component.css'],
  providers: [VideoService]
})

export class VideoDetailsComponent implements OnInit, OnDestroy {

    private routeSub:any;
    private req:any;
    video: any;
    slug:string;

    //constructor(private route: ActivatedRoute, private http:Http) { }
    constructor(private route: ActivatedRoute, private _video:VideoService) { }

    ngOnInit() {

        // Get data from videoService
        this.routeSub = this.route.params.subscribe(params => {
            this.slug = params['slug']
            this.req = this._video.get(this.slug).subscribe(data=>{
              this.video = data
              console.log(data)
            })
        })

        /*
        // Get data from a json file using http
        this.routeSub = this.route.params.subscribe(params => {
            console.log(params)
            this.slug = params['slug']
            this.http.get('assets/json/videos.json').subscribe(data=>{
                data.json().filter(item=>{
                    if (item.slug == this.slug) {
                        this.video = item
                    }
                })
            })
        }) */
    }

    ngOnDestroy(){
        this.routeSub.unsubscribe()
    }

}
