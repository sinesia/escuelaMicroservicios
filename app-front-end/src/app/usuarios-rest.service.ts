import { Injectable } from '@angular/core';
import { AlmacenLocalService } from './almacen-local.service';
import { Usuario } from './entidades/Usuario';
import { Observable, of  } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UsuariosService } from './usuarios.service';


@Injectable({
  providedIn: 'root'
})
export class UsuariosRestService {

  url = "http://localhost:8081/api/json/usuarios";
  listaUsuario: Usuario[];

  constructor(
    public almSrv : AlmacenLocalService, 
    public clienteHttp: HttpClient) { }

  getTodos(): Observable<Usuario[]> {
      /* this.listaUsuario =  
      [
          { id : 1, nombre: "Pako ", email: "pak@em.com", password: "1234", idTemaPreferido: 1 },
          { id : 2, nombre: "Choni ", email: "choni@em.com", password: "1234", idTemaPreferido: 1 }
      ];
    // creamos observable
    return of(this.listaUsuario); */

    let observableHttp = this.clienteHttp.get<Usuario[]>(this.url);
    return observableHttp;
  }

  registro(usuario: Usuario): Observable<Usuario> {
    return this.clienteHttp.post<Usuario>(this.url, usuario);
  }

  modificar(usuario: Usuario) {
    return this.clienteHttp.put<Usuario>(this.url, usuario);
  }

  // '${uri}/${id}'
  // uri + id
  eliminar(id: number) {
    return this.clienteHttp.delete<any>(`${this.url}/${id}`);
  }
}
