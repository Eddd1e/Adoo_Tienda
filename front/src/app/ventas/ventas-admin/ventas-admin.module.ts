import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VentasAdminPageRoutingModule } from './ventas-admin-routing.module';

import { VentasAdminPage } from './ventas-admin.page';
import { ComponentsModule } from 'src/app/components/components.module';
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VentasAdminPageRoutingModule,
    ComponentsModule
  ],
  declarations: [VentasAdminPage]
})
export class VentasAdminPageModule {}
