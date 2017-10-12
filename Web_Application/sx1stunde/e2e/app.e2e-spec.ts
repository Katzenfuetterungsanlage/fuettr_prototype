import { Sx1stundePage } from './app.po';

describe('sx1stunde App', () => {
  let page: Sx1stundePage;

  beforeEach(() => {
    page = new Sx1stundePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
