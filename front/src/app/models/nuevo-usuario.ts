export class NuevoUsuario {
    nombre: string;
    telefono: string;
    correo: string;
    password: string;

    constructor(nombre: string, telefono: string, correo: string, password: string) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
    }

}
