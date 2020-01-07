import { Component, OnInit } from '@angular/core';
import { Usuario } from '../entidades/Usuario';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {

  variable: string = "EMPIEZA POR ";
  password: string;
  usuario: Usuario; // = new Usuario();

  constructor() {
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
    console.log(this.usuario.nombre);
    console.log(this.usuario.nombre);
  }

  pulsar() {
    console.log(this.variable);
    this.variable = "OTRO VALOR";
  }

}
