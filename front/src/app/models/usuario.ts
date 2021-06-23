export class Usuario{
    nombre: string;
    telefono: string;
    correo: string;
    password: string;
    clienteFrecuente; number;
    constructor(nombre: string, telefono: string, correo: string, password: string,clienteFrecuente:number) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.clienteFrecuente = clienteFrecuente;
    }

}