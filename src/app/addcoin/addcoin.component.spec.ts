import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddcoinComponent } from './addcoin.component';

describe('AddcoinComponent', () => {
  let component: AddcoinComponent;
  let fixture: ComponentFixture<AddcoinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddcoinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddcoinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
