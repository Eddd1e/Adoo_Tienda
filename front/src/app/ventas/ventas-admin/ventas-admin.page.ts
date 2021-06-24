
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { Venta } from 'src/app/models/venta';
import { Producto } from 'src/app/models/producto';
import { ProductoVenta } from 'src/app/models/venta/productoVenta';
import { VentaService } from 'src/app/services/ventaService';

@Component({
  selector: 'app-ventas-admin',
  templateUrl: './ventas-admin.page.html',
  styleUrls: ['./ventas-admin.page.scss'],
})
export class VentasAdminPage implements OnInit {

  ventas: Venta [] = [];
  ready = false;

  msjOK = '';
  msjErr = '';
  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private toastController: ToastController,
    private ventaService:VentaService
  ) { }

  ngOnInit() {
    this.cargar();
  }
  cargar(): void {
  
    this.ventaService.lista().subscribe(
      data => {
        this.ventas = data;
        
        this.ready = true;
      },
      err => {
        console.log("error")
        console.log(err);
      }
    );
  }

  
  volver() {
    this.router.navigate(['/admin']);
  }

  async presentToast(mensaje: string) {
    const toast = await this.toastController.create({
      message: mensaje,
      duration: 2000,
      position: 'middle'
    });
    toast.present();
  }

}
