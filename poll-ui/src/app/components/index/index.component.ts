import {AfterViewInit, Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {QuestionService} from "../../services/question.service";
import {Question} from "../../dto/question.model";
import {DOCUMENT} from '@angular/common';
import {PollService} from "../../services/poll.service";
import {Poll} from "../../dto/poll.model";
import {AnswerItemModel} from "../../dto/answer.item.model";
import {el} from "@angular/platform-browser/testing/src/browser_util";
import {Router} from "@angular/router";


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit, OnDestroy {


  questions: Question[] = [];
  answers: number[] = [];
  url: string;
  showQRCode: boolean = false;
  polls: Poll[] = [];
  hasSubmitted: boolean = false;
  secondsToJump: number = 5;
  jumperInterval: any;

  constructor(private questionService: QuestionService,
              @Inject(DOCUMENT) private document: Document,
              private pollService: PollService, private router: Router) {
    this.url = this.document.location.href;
    console.log(this.url);
  }

  canGoNextStep(qIndex): boolean {
    if (this.polls.length >= qIndex + 1) return true
    else return false;
  }

  ngOnInit() {
    this.questionService.getQuestions().subscribe(r => {
      this.questions = r;


    });
  }

  ngOnDestroy(): void {
    if (this.jumperInterval)
      clearInterval(this.jumperInterval);
  }

  onSubmitButtonClicked() {
    this.pollService.submitPoll(this.polls).subscribe(r => {
      this.hasSubmitted = true;
      this.polls = [];


      setTimeout(() => {
        this.router.navigate(['/result']);
      }, 5000);
      setInterval(() => {
        if (this.secondsToJump > 0)
          this.secondsToJump -= 1;
      }, 1000);

    });
  }


  onItemClick(qIndex: number, answerId: AnswerItemModel) {
    let poll = new Poll(this.questions[qIndex], answerId);
    this.polls[qIndex] = poll;
  }

  isHighlighted(qIndex: number, answerId: AnswerItemModel): boolean {

    if (this.polls.length < qIndex) return false;

    if (this.polls[qIndex] != null && this.polls[qIndex].answer.id === answerId.id) return true;
    else return false;
  }


  onShowQRButonClicked() {
    this.showQRCode = !this.showQRCode;
  }

  onShowResultButtonClicked() {
    this.router.navigate(['/result']);
  }
}
