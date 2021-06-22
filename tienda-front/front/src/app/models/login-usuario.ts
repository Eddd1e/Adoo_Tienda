export class LoginUsuario {
    correoUsuario: string;
    password: string;
    constructor(nombreUsuario: string, password: string) {
        this.correoUsuario = nombreUsuario;
        this.password = password;
    }
}
