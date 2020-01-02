import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaUsuariosComponent } from './lista-usuarios/lista-usuarios.component';
import { RegistroUsuarioComponent } from './registro-usuario/registro-usuario.component';
import { from } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    ListaUsuariosComponent,
    RegistroUsuarioComponent
    // los servicios por defecto son singleton
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,// Para poder usar HTTP en toda la app
    FormsModule // para poder usar formularios

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
