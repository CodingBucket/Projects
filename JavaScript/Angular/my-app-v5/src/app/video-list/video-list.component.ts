import { Component, OnInit, OnDestroy } from '@angular/core';
//import { Http } from '@angular/http';
import { VideoService } from '../services/video-service/video.service';
import { VideoItem } from '../model/video'; // importing video model

@Component({
  selector: 'video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css'],
  providers: [VideoService]
})

export class VideoListComponent implements OnInit, OnDestroy {
  
  private req: any;
  title = "Video List";

  videoList: [VideoItem];

  //constructor(private http:Http) { }
  constructor(private _video:VideoService) { }

  ngOnInit() {
    /*
    this.req = this.http.get('assets/json/videos.json').subscribe(data=>{
      console.log(data.json())
      this.videoList = data.json() as [any];
    }) */

    // Get data from service
    this.req = this._video.list().subscribe(data=>{
      this.videoList = data as [VideoItem];
    })

  }

  getEmbedUrl(item){
    //return 'https://www.youtube.com/embed/' + item.embed + '?ecver=2'
  }

  ngOnDestroy(){
    this.req.unsubscribe()
  }

}
