import { Component, OnInit } from '@angular/core';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { UsuariosService } from '../usuarios.service';
import { Usuario } from '../entidades/Usuario';
import { Observable } from 'rxjs';
import { UsuariosRestService } from '../usuarios-rest.service';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {
  listaUsu: Usuario[];
  public srvUsu: UsuariosRestService;

  // Como usuarios service es @Injectable, Angular lo instancia
  // pasa como argumento del constructor automaticamente. IoD
  // esto es como @AUTOWIRE
  constructor(srvUsu: UsuariosRestService) {
      this.srvUsu = srvUsu;
   }

  // importa q este o no metodo para capturr interfaz,
  // independientemente de interfaz
  ngOnInit() {
    let obserConDatos: Observable<Usuario[]> = this.srvUsu.getTodos();
    // Le decimos al objeto observable, q cuando reciba datos
    // invoque a esta funcion callback
    obserConDatos.subscribe( datos => this.listaUsu = datos );
   // obserConDatos.subscribe( datos => this.listaUsu = datos );

    // hasta q no nos suscribimos, no hace peticion
  }
}
