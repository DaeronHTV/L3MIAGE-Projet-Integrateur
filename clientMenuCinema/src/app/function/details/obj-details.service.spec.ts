import { TestBed } from '@angular/core/testing';

import { ObjDetailsService } from './obj-details.service';

describe('ObjDetailsService', () => {
  let service: ObjDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ObjDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
