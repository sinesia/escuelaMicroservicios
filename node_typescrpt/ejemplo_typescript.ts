var texto = "Typescript es Javascript";
console.log(texto);
texto = {};
texto["prop"] = "Con sus virtudes y defectos";
console.log(texto.prop);

class MiClase {
    private variableMiembro: number;
    public otraProp: String;

    constructor(num: number, op: String){
        this.variableMiembro = num;
        this.otraProp = op;
    }

    metodo(argumento: any){
        // tiene tipo any,
        // cualquier cosa
        console.log(`Valores: ${this.variableMiembro},
                            ${this.otraProp},
                            ${argumento}`);
    }
}
let elObj: MiClase = new MiClase(69, "A comer");
elObj.metodo("Pero ahora")
