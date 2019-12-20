console.log("mostrar mensaje");

console.log(process.pid);
console.log("Ruta: " + process.cwd);

var unObjeto = new Object();

unObjeto.propiedadA = "Valor A";
unObjeto["propiedadB"] = "Valor B";
var unObj2 = {
    "propiedadA" : "valorA",    // formato JSON (jAVASCRIPT oBJECT NOTATION)
    propiedadB: "valorB",       // Solo en JS permite sin comillas o comillas simples '
    'propiedadC': "valorC",
    "metodo": function() { return "unObj2 : " + this.propiedadA;},
    "array": [2, "x", true]     // un array en JS es como un ArrayList<Object> de java</Object>
}

var ConstructorObj3 = function(argA, argB) {
    this.propiedadA = argA;
    this.propiedadB = argB;
    this.metodo = () => { return 'un Obj 3 : ' + this.propiedadA};
}

var unObj3 = new ConstructorObj("valorA", "valorB");
console.log(unObjeto.metodo());
console.log(unObj2.metodo());

console.log(`Valor de A : ${$unObjeto[`propiedadA`]},
            Valor de B: ${unObjeto.propiedadB}`);

// Funciomnes en JS son objetos
function fun1(par1, par2){
    return "Resultado fun1 : " + parA + ", " + parB;
}

// el ambito de var es a nivel de funcion
// el ambito de let  es a nivel de bloque de {}, como en java
Let fun2 = function(par1, par2){
    return 'Resultado fun2 : ${parA}, ${parB}';
}
var fun3 = new Function("parA", "parB", "return `Resultado fun3: ${parA}, ${parB}`");

// Desde  EmacScript 6, ES2015 : funciones lambda, etc.
var fun4 = (parA, parB) => { return `Resultado fun3: ${parA}, ${parB}``};
var fun5 = (parA, parB) => "Resultado fun5: " + parA + ", " + parB;



