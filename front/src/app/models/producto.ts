import { Catalogo } from "./catalogo";
import { Proveedor } from "./proveedor";

export class Producto {
    id?: number;
    proveedor:Proveedor;
    catalogo:Catalogo;
    nombre: string;
    descripcion: string;
    fecha_cad: string;
    precio: number;
    constructor(nombre: string, precio: number)  {
        this.nombre = nombre;
        this.precio = precio;
    }
}
