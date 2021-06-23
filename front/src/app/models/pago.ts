import { MetodoPago } from './metodoPago';
import { Usuario } from './usuario';
import { Venta } from './venta';
export class Pago{
    id:number;
    usuario:Usuario;
    metodoPago:MetodoPago;
    venta:Venta;
    cantidad:number;
    fecha:string;

    correo:string;
    id_metodo:number;
    id_venta:number;
	constructor(correo:string,id_metodo:number,id_venta:number,cantidad:number) {
        this.correo = correo;
        this.id_metodo = id_metodo;
        this.id_venta = id_venta;
        this.cantidad = cantidad;
	}
    
}