import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {HttpModule} from "@angular/http";
import {IndexComponent} from "./components/index/index.component";
import {routing} from "../app.routing";
import {ArchwizardModule} from "ng2-archwizard/dist";
import {QuestionService} from "./services/question.service";
import {QRCodeModule} from "angular2-qrcode";
import {ResultComponent} from './components/result/result.component';
import {PollService} from "./services/poll.service";
import {ChartsModule} from "ng2-charts";

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    ResultComponent
  ],
  imports: [
    BrowserModule,
    routing,
    HttpModule,
    ArchwizardModule,
    QRCodeModule,
    ChartsModule

  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    QuestionService,
    PollService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
