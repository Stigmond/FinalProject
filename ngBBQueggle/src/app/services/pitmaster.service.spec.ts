import { TestBed } from '@angular/core/testing';

import { PitmasterService } from './pitmaster.service';

describe('PitmasterService', () => {
  let service: PitmasterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PitmasterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
