import { Component } from '@angular/core';

@Component({
    selector: 'app-comp-b', 
    template: '<h2>Aqui estoy B</h2>'
})
// entidad q se convierte en objeto JS
export /* = public */ class AppComponenteB {

    contador = 0;

    ngOnInit() {
        this.contador = 7;
    }
    alPulsarBtn() {
        this.contador++;
        console.log("Contador = " + this.contador);
    }
}