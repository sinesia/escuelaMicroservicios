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
  private usuarioParaModificar: Usuario;

  // Como usuarios service es @Injectable, Angular lo instancia
  // pasa como argumento del constructor automaticamente. IoD
  // esto es como @AUTOWIRE
  constructor(srvUsu: UsuariosRestService) {
      this.srvUsu = srvUsu;
   }

  // importa q este o no metodo para capturr interfaz,
  // independientemente de interfaz
  ngOnInit() {
 
    // Le decimos al objeto observable, q cuando reciba datos
    // invoque a esta funcion callback
    let observableConDatos: Observable<Usuario[]> = this.srvUsu.getTodos();
    observableConDatos.subscribe( datos => this.listaUsu = datos );
    observableConDatos.subscribe( datos => console.log(JSON.stringify(datos)) );

    // hasta q no nos suscribimos, no hace peticion

    let subscriptor = function(datos) {
      let textoJSON = JSON.stringify(datos);
      console.log(textoJSON);
    };
  }

  prepararUsuParaModificar(usu: Usuario) :Usuario {

    this.usuarioParaModificar = new Usuario(usu);
    return this.usuarioParaModificar;
  }
  modificar() {
    this.srvUsu.modificar(this.usuarioParaModificar).subscribe((usuModificado) => { 
      alert(`Usuario con id ${usuModificado.id} modificado`);
      this.ngOnInit();
    });
  }

  eliminar(id: number) {
    this.srvUsu.eliminar(id).subscribe(() => { 
      alert('Usuario con id ${id} eliminado');
      this.ngOnInit();
    });
  }
}
