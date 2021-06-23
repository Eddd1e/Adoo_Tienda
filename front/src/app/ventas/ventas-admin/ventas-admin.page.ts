import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { Venta } from 'src/app/models/venta';
import { VentaService } from 'src/app/services/ventaService';

@Component({
  selector: 'app-ventas-admin',
  templateUrl: './ventas-admin.page.html',
  styleUrls: ['./ventas-admin.page.scss'],
})
export class VentasAdminPage implements OnInit {

  ventas: Venta [] = [];

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
        console.log(this.ventas[0].productoVenta[0].producto.nombre);
        console.log(data);
      },
      err => {
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
