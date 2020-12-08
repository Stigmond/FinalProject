import { TestBed } from '@angular/core/testing';

import { MaindishService } from './maindish.service';

describe('MaindishService', () => {
  let service: MaindishService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MaindishService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
