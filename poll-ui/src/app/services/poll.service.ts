import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {Question} from "../dto/question.model";
import 'rxjs/add/operator/map';
import {Poll} from "../dto/poll.model";


@Injectable()
export class PollService {


  constructor(private http: Http) {
  }

  submitPoll(polls: Poll[]): Observable<boolean> {

    let headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    let options = new RequestOptions({headers: headers});

    let url = `/poll/submit`;
    return this.http.post(url, JSON.stringify(polls), options).map(r => {
      console.log(r);
      return true;
    })

  }


  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

}
