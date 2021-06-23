import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { ProductoGuardGuard as guard } from './guards/producto-guard.guard';


const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'admin',
    loadChildren: () => import('./pages/admin/admin.module').then( m => m.AdminPageModule),
    canActivate: [guard], data: {requiredRoles: ['admin']}
  },
  {
    path: 'user',
    loadChildren: () => import('./pages/user/user.module').then( m => m.UserPageModule),
    canActivate: [guard], data: {requiredRoles: ['admin', 'cliente']}
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'registro',
    loadChildren: () => import('./pages/registro/registro.module').then( m => m.RegistroPageModule)
  },
  {
    path: 'nuevo',
    loadChildren: () => import('./pages/nuevo/nuevo.module').then( m => m.NuevoPageModule),
    canActivate: [guard], data: {requiredRoles: ['admin']}
  },
  {
    path: 'editar/:id',
    loadChildren: () => import('./pages/editar/editar.module').then( m => m.EditarPageModule),
    canActivate: [guard], data: {requiredRoles: ['admin']}
  },
  {
    path: 'detalle/:id',
    loadChildren: () => import('./pages/detalle/detalle.module').then( m => m.DetallePageModule),
    canActivate: [guard], data: {requiredRoles: ['admin', 'cliente']}
  },
  {
    path: 'ventasAdmin',
    loadChildren: () => import('./ventas/ventas-admin/ventas-admin.module').then( m => m.VentasAdminPageModule),
    canActivate: [guard], data: {requiredRoles: ['admin']}
  },
  {
    path: 'venta/:id',
    loadChildren: () => import('./ventas/venta/venta.module').then( m => m.VentaPageModule)
  },
  {
    path: 'pagos',
    loadChildren: () => import('./ventas/pagos/pagos.module').then( m => m.PagosPageModule)
  },
  {
    path: 'pago/:id',
    loadChildren: () => import('./ventas/pago/pago.module').then( m => m.PagoPageModule)
  },
  {
    path: '**',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'carrito',
    loadChildren: () => import('./pages/carrito/carrito.module').then( m => m.CarritoPageModule)
  }


 
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
