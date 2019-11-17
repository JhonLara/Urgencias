import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UrgenciasComponent } from './urgencias.component';

describe('BooksComponent', () => {
  let component: UrgenciasComponent;
  let fixture: ComponentFixture<UrgenciasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UrgenciasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UrgenciasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
