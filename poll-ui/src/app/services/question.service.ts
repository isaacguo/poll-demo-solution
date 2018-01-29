import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {Question} from "../dto/question.model";
import 'rxjs/add/operator/map';

@Injectable()
export class QuestionService {


  constructor(private http: Http) {
  }

  getQuestions(): Observable<Question[]> {
    let url = `/questions`;
    return this.http.get(url).map(this.extractData);
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

}
