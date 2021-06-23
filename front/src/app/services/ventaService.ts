import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Venta } from '../models/venta';

@Injectable({
  providedIn: 'root'
})
export class VentaService{
    VentaURL ='http://localhost:8080/api/venta/';

    constructor(private httpClient: HttpClient) { }
  
    public lista(): Observable<Venta[]> {
      return this.httpClient.get<Venta[]>(this.VentaURL + 'lista');
    }
  
    public detalle(id: number): Observable<Venta> {
      return this.httpClient.get<Venta>(this.VentaURL + `detail/${id}`);
    }
  
    public nuevo(Venta: Venta): Observable<any> {
      return this.httpClient.post<any>(this.VentaURL + 'create', Venta);
    }
  
    public actualizar(id: number, Venta: Venta): Observable<any> {
      return this.httpClient.put<any>(this.VentaURL + `update/${id}`, Venta);
    }
  
    public eliminar(id: number): Observable<any> {
      return this.httpClient.delete<any>(this.VentaURL + `delete/${id}`);
    }
}