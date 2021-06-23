import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VentasAdminPage } from './ventas-admin.page';

const routes: Routes = [
  {
    path: '',
    component: VentasAdminPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class VentasAdminPageRoutingModule {}
