import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pago } from '../models/pago';

@Injectable({
  providedIn: 'root'
})
export class PagoService {

  PagoURL ='http://localhost:8080/api/pago/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Pago[]> {
    return this.httpClient.get<Pago[]>(this.PagoURL + 'lista');
  }

  public detalle(id: number): Observable<Pago> {
    return this.httpClient.get<Pago>(this.PagoURL + `detail/${id}`);
  }
  public detalleByIdVenta(id: number): Observable<Pago[]> {
    return this.httpClient.get<Pago[]>(this.PagoURL + `pagosByIdVenta/${id}`);
  }

  public nuevo(Pago: Pago): Observable<any> {
    console.log(Pago.id_venta);
    Number(Pago.id_venta);
    Number(Pago.cantidad);
    return this.httpClient.post<any>(this.PagoURL + 'create', Pago);
  }

  public actualizar(id: number, Pago: Pago): Observable<any> {
    return this.httpClient.put<any>(this.PagoURL + `update/${id}`, Pago);
  }

  public eliminar(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.PagoURL + `delete/${id}`);
  }

}
