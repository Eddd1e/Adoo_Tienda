import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { Pago } from 'src/app/models/pago';
import { PagoService } from 'src/app/services/pago.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-pago',
  templateUrl: './pago.page.html',
  styleUrls: ['./pago.page.scss'],
})
export class PagoPage implements OnInit {

  Pago: Pago;
  correo = '';
  id_metodo=null;
  id_venta=null;
  cantidad=null;

  msjOK = '';
  msjErr = '';

  constructor(
    private pagoService: PagoService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private tokenService: TokenService,
    private toastController: ToastController
  ) { }

  ngOnInit() {
  }

  onCreate() {
    const id = this.activatedRoute.snapshot.params.id;
    this.Pago = new Pago(this.tokenService.getUser(), 1,id,this.cantidad);
    this.pagoService.nuevo(this.Pago).subscribe(
      data => {
        this.presentToast(data.mensaje);
        this.volver(id);
      },
      err => {
        this.presentToast(err.error.mensaje);
      }
    );
  }

  vaciar() {
    this.correo = '';
    this.id_metodo= null;
    this.id_venta=null;
    this.cantidad= null;
  }

  volver(id:number) {
    this.router.navigate(['/venta/'+id]).then(() => {
      window.location.reload();
    });;
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
