import { PollUiPage } from './app.po';

describe('poll-ui App', () => {
  let page: PollUiPage;

  beforeEach(() => {
    page = new PollUiPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
