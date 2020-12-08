import { TestBed } from '@angular/core/testing';

import { SidedishService } from './sidedish.service';

describe('SidedishService', () => {
  let service: SidedishService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SidedishService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
