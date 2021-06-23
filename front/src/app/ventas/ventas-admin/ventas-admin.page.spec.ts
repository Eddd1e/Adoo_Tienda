import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { VentasAdminPage } from './ventas-admin.page';

describe('VentasAdminPage', () => {
  let component: VentasAdminPage;
  let fixture: ComponentFixture<VentasAdminPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VentasAdminPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(VentasAdminPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
