import { Component } from '@angular/core';

@Component({
    selector: 'app-comp-b',
    template:
    `<h2>Aqui estoy BB</h2>
    <div *ngFor="let cont of unArray">
        <app-comp-c [contador]="cont"></app-comp-c>
    </div>`
})
// entidad q se convierte en objeto JS
export /* = public */ class AppComponenteB {

    contador = 0;
    unArray = [1, 1, 2, 3, 5, 8];

    ngOnInit() {
        this.contador = 7;
    }
    alPulsarBtn() {
        this.contador++;
        console.log("Contador = " + this.contador);
    }
}
