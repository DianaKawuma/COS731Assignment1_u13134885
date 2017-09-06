import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiaryEggsMilkComponent } from './diary-eggs-milk.component';

describe('DiaryEggsMilkComponent', () => {
  let component: DiaryEggsMilkComponent;
  let fixture: ComponentFixture<DiaryEggsMilkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiaryEggsMilkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiaryEggsMilkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
