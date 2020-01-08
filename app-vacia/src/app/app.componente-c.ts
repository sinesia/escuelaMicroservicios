import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-comp-c', 
    template: 
    `<div> <strong>Aqui estoy CC</strong>
    {{ contador }} 
    <input type = "button" (click)="alPulsarBtn()" value="+" />
    </div>`
})
// entidad q se convierte en objeto JS
export /* = public */ class AppComponenteC {

    @Input() contador = 0;

    ngOnInit() {

    }
    alPulsarBtn() {
        this.contador++;
        console.log("Contador = " + this.contador);
    }
}