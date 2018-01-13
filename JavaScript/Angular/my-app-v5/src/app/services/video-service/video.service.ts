import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


const endpoint = 'assets/json/videos.json'

@Injectable()
export class VideoService {

  constructor(private http: Http) { }

  // Return full video list
  list(){
      return this.http.get(endpoint)
              .map(response=>response.json())
              .catch(this.handleError)
  }

  // Return a specific video
  get(slug){
      return this.http.get(endpoint)
              .map(response=>{
                     let data = response.json().filter(item=>{
                                      if (item.slug == slug) {
                                          return item
                                      }
                                  })
                     if (data.length == 1){
                         return data[0]
                     }
                     return {}
               })
              .catch(this.handleError)
  }

  search(query){
    return this.http.get(endpoint)
              .map(response=>{
                     let data = []
                     let req = response.json().filter(item=>{
                                    if (item.name.indexOf(query) >=0) {
                                         data.push(item)
                                    }
                                })
                     console.log(query)
                     console.log(data)
                     return data
               })
              .catch(this.handleError)

  }

  private handleError(error:any, caught:any): any{
      console.log(error, caught)
  }

}