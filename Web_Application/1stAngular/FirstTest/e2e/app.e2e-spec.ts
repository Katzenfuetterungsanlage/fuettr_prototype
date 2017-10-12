import { FirstTestPage } from './app.po';

describe('first-test App', () => {
  let page: FirstTestPage;

  beforeEach(() => {
    page = new FirstTestPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
