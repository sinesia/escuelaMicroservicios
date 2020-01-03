import { NgModule } from '@angular/core';
import { Browser } from 'protractor';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponente } from './app.componente';

// Los metadatos de un modulo/comp/serv ....
// es un objeto de JS q le pasamos al @Decorador
@NgModule( {
    // components, directives, pipes
    declarations: [ AppComponente ], 
    imports: [ BrowserModule ],
    bootstrap: [ AppComponente ]
} )
export class AppModulo { }