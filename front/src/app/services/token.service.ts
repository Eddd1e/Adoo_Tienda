import { Injectable } from '@angular/core';
import * as jwt_decode from 'jwt-decode';

const TOKEN_KEY = 'AuthToken';
const USERNAME_KEY = 'AuthUsername';
const AUTHORITIES_KEY = 'AuthAuthorities';


@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  public setToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }

  public setAuthorities(rol: string): void {
    window.sessionStorage.removeItem(AUTHORITIES_KEY);
    window.sessionStorage.setItem(AUTHORITIES_KEY, rol);
  }

  public getAuthorities(): string {
    return window.sessionStorage.getItem(AUTHORITIES_KEY);
  }


  public getUserName(): string {
    let userName = '';
    if(this.getToken()) {
      const sub = jwt_decode(this.getToken()).sub;
      userName = sub;
    }
    return userName;
  }

  isAdmin(): boolean {
    if(this.getToken()) {
     // const sub = jwt_decode(this.getToken()).sub;
     var s = this.getAuthorities();
      return (s === 'admin');
    }
    return false;
  }

  getUser():string{
    if(this.getToken()) { 
       return  jwt_decode(this.getToken()).sub;
     }
  }

  public logOut(): void {
    window.sessionStorage.clear();
  }
}
