import { TestBed } from '@angular/core/testing';

import { DetailCarouselService } from './detail-carousel.service';

describe('DetailCarouselService', () => {
  let service: DetailCarouselService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DetailCarouselService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
