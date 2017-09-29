import { NgxPage } from './app.po';

describe('ngx App', () => {
  let page: NgxPage;

  beforeEach(() => {
    page = new NgxPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
