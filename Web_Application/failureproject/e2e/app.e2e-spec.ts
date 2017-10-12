import { FailureprojectPage } from './app.po';

describe('failureproject App', () => {
  let page: FailureprojectPage;

  beforeEach(() => {
    page = new FailureprojectPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
