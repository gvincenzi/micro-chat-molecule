import { TestBed } from '@angular/core/testing';

import { MicrochatService } from './microchat.service';

describe('MicrochatService', () => {
  let service: MicrochatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MicrochatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
