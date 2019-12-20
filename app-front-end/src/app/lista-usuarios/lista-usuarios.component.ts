import { Component, OnInit } from '@angular/core';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { UsuariosService } from '../usuarios.service';
import { Usuario } from '../entidades/Usuario';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {
  listaUsu: Usuario[];
  // Como usuarios service es @Injectable, Angular lo instancia
  // pasa como argumento del constructor automaticamente. IoD
  constructor(public srvUsu: UsuariosService) { }

  ngOnInit() {
    this.listaUsu = this.srvUsu.getTodosUsuarios();
  }
}
