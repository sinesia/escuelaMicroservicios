import { Component, OnInit } from '@angular/core';
import { Usuario } from '../entidades/Usuario';
import { UsuariosRestService } from '../usuarios-rest.service';
import { from, observable } from 'rxjs';
import { UsuariosService } from '../usuarios.service';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {

  variable: string = "EMPIEZA POR ";
  password: string;
  usuario: Usuario; // = new Usuario();
  estaRegistrado: boolean = false;
  formVisible: boolean = false;

  constructor(private usuSrv: UsuariosRestService) {
    this.usuario =  new Usuario();
   }

  ngOnInit() {
    /* this.usuario = {
      id : null,
      nombre : "nnnnn",
      password : "1234",
      email : "aaaaa@jjjjj.es" 
    } */
  }

  enviarDatos() {
    this.usuario.password = this.password;

    this.usuSrv.registro(this.usuario).subscribe((usuRecibido) => { 
      this.usuario = usuRecibido;
      this.estaRegistrado = ( typeof this.usuario.id !== 'undefined');
    });

    console.log(this.usuario.nombre);
    console.log(this.usuario.nombre);
  }

  modificar(usuRecibido: Usuario) {
     
    this.usuSrv.modificar(this.usuario).subscribe((usuRecibido) => { 
      this.usuario = usuRecibido;
      this.estaRegistrado = ( typeof this.usuario.id !== 'undefined');
      // this.modificarUsu = true;
    }); 

    console.log(this.usuario.nombre);
    console.log(this.usuario.password);
  }

  eliminar(id: number) {

    this.usuSrv.eliminar(id).subscribe((usuRecibido) => { 
      this.usuario.id = id;
      this.estaRegistrado = ( typeof this.usuario.id !== 'undefined');
    }); 

    console.log(this.usuario.nombre);
    console.log(this.usuario.nombre);
  }

  pulsar() {
    console.log(this.variable);
    this.variable = "OTRO VALOR";
  }
}
