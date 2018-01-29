import {Question} from "./question.model";
import {AnswerItemModel} from "./answer.item.model";

export class Poll {
  constructor(public question: Question,
              public answer: AnswerItemModel,
              public id?: number,) {
  }
}


