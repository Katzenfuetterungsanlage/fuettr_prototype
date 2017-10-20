import { TestBed, inject } from '@angular/core/testing';

import { TimesService } from './times.service';

describe('TimesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TimesService]
    });
  });

  it('should be created', inject([TimesService], (service: TimesService) => {
    expect(service).toBeTruthy();
  }));
});
