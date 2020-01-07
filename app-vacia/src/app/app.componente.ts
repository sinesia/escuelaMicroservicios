import { Component } from '@angular/core';

@Component({
    selector: 'app-comp-raiz', 
    template: '<h2>Aqui estoy</h2>'
})
// entidad q se convierte en objeto JS
export /* = public */ class AppComponente {

    contador = 0;

    ngOnInit() {
        this.contador = 7;
    }
    alPulsarBtn() {
        this.contador++;
        console.log("Contador = " + this.contador);
    }
}