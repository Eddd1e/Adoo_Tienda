export class JwtDto {
    token: string;
     nombreUsuario: string;
     authorities: Authorities[];
}
export class Authorities {
    authority:string;
}