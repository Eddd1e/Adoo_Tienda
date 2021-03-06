import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { Pago } from 'src/app/models/pago';
import { PagoService } from 'src/app/services/pago.service';
import { VentaService } from 'src/app/services/ventaService';
import { Venta } from '../../models/venta';
import { Producto } from 'src/app/models/producto';
import { ProductoVenta } from 'src/app/models/venta/productoVenta';

@Component({
  selector: 'app-venta',
  templateUrl: './venta.page.html',
  styleUrls: ['./venta.page.scss'],
})
export class VentaPage implements OnInit {

 
  pagos: Pago [] = [];
  venta: Venta;

  msjOK = '';
  msjErr = '';
  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private toastController: ToastController,
    private pagoervice:PagoService,
   
    private ventaService:VentaService
  ) { }

  ngOnInit() {
    
    this.cargar();
  }
  cargar(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.pagoervice.detalleByIdVenta(id).subscribe(
      data => {
        this.pagos = data;
        console.log(this.pagos);
      
      },
      err => {
        console.log(err);
      }
    );
    this.ventaService.detalle(id).subscribe(
      data => {
        this.venta = data;
        console.log("bat i ned")
        console.log(this.venta.productoVenta[0].producto.nombre)
      
      },
      err => {
        console.log(err);
      }
    );
  }

  
  setPago() {
    this.router.navigate(['/pago/'+this.venta.id]);
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
