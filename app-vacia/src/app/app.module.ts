import { NgModule } from '@angular/core';
import { Browser } from 'protractor';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponenteA } from './app.componente-a';
import { AppComponenteB } from './app.componente-b';
import { AppComponenteC } from './app.componente-c';
import { PagNoEncontradaComponent } from './pag-no-encontrada/pag-no-encontrada.component';
import { AppRaizComponent } from './app-raiz/app-raiz.component';

const rutasApp: Routes = [ 
   /*  {  path: "raiz", component: AppRaizComponent }, */
    { path: "compa", component: AppComponenteA }, 
    { path: "compb", component: AppComponenteB }, 
    { path: "", redirectTo: "/compa", pathMatch: 'full' },
    { path: "**", component: PagNoEncontradaComponent }

];
// public static void main 
// Los metadatos de un modulo/comp/serv ....
// es un objeto de JS q le pasamos al @Decorador
@NgModule( {
    // components, directives, pipes
    declarations: [AppRaizComponent,  
        AppComponenteA, 
        AppComponenteB, 
        AppComponenteC, 
        PagNoEncontradaComponent ], 
    imports: [ BrowserModule, 
        RouterModule.forRoot(rutasApp, 
        {enableTracing: true } ) // solo para  depuracion
    ],
    bootstrap: [ AppRaizComponent ]
} )
export class AppModulo { }