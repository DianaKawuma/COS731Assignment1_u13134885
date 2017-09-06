import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeatFishPoultryComponent } from './meat-fish-poultry.component';

describe('MeatFishPoultryComponent', () => {
  let component: MeatFishPoultryComponent;
  let fixture: ComponentFixture<MeatFishPoultryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeatFishPoultryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeatFishPoultryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
