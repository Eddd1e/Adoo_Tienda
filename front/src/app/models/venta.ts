import { Usuario } from "./usuario";
import { ProductoVenta } from "./venta/productoVenta";

export class Venta{
    usuario:Usuario;
    id?: number;
    deuda?: number;
    pagado?: number;
    fecha: string;
    productoVenta:ProductoVenta[];

    /* constructor(id: number, deuda: number, pagado: number, fecha: string,productos:number[],usuario:Usuario) {
        this.id = id;
        this.deuda = deuda;
        this.pagado = pagado;
        this.fecha = fecha;
        this.productos = productos;
        this.usuario = usuario;
    } */

	constructor() {
	}

}

