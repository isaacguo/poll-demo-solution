import {AnswerItemModel} from "./answer.item.model";

export class Question {
  constructor(public id: number,
              public question: string,
              public availableAnswers: AnswerItemModel[]) {
  }
}
