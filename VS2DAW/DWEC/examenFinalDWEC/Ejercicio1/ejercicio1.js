//Ejercicio 1 de Guillermo Santos Molero

//Expresiones regulares que vamos a utilizar en distintos métodos
var expresionSimbolos=/([-_$@#])/g;
var expresionMayuculas=/[A-Z]/g;
var expresionNumeros=/[0-9]/g;

//Control de eventos de elementos existentes en el código html
document.getElementById("password").addEventListener('keydown', comprobarSimbolo);
document.getElementById("password").addEventListener('keyup', comprobarValorar);
document.getElementById("valorar").addEventListener('click',comprobarPass)

//Preparación a través del método onload de como se mostrará el código html
window.onload=prepararHtml;
function prepararHtml(){
    document.getElementById("valorar").disabled=true;
    document.getElementById("resultado").disabled=true;
}

//Método que comprueba si existe un símbolo de los seleccionados dentro de la contraseña, 
//si es así no deja que entre otro.
function comprobarSimbolo(e){
    var contra=document.getElementById("password").value;
    if(e.key.match(expresionSimbolos)!=null) {
      if(contra.match(expresionSimbolos)!=null){
        e.preventDefault();
      }
    }
}

//El método comprueba la longitud de la contraseña de manera que se habilitará el boton valorar
//únicamente cuando la longitud sea mayor o igual que ocho y menor o igual que 12
function comprobarValorar(){
    var contra=document.getElementById("password").value;
    if(contra.length<8 || contra.length>12){
        document.getElementById("valorar").disabled=true;
    }else{
        document.getElementById("valorar").disabled=false;
    }
}

//Este método comprobará si la contraseña contiene una mayuscula y un número como mínimo, y si es
// así llamará al método que calcule la puntuacion de la contraseña
function comprobarPass(){
    document.getElementById("password").disabled=true;
    document.getElementById("valorar").disabled=true;
    var contra=document.getElementById("password").value;
    var elementoResultado=document.getElementById("resultado");
    if(contra.match(expresionMayuculas)===null){
        elementoResultado.value="Debes introducir como mínimo una mayúscula";
    }else{
        if(contra.match(expresionNumeros)===null){
            elementoResultado.value="Debes introducir como mínimo un número";
        }else{
            calcularPuntuacion();
        }
    }
    mostrarBotonNuevo();
}

//Método que calculará la puntuación total y la mostrará por pantalla
function calcularPuntuacion(){
    var puntuacionFinal=0;
    puntuacionFinal+=puntosPorLongitud();
    puntuacionFinal+=puntosPorMayusculas();
    puntuacionFinal+=puntosPorNumeros();
    puntuacionFinal+=puntosPorSimbolo();
    var contra=document.getElementById("password").value;
    if(puntuacionFinal<=11){
        document.getElementById("resultado").value=puntuacionFinal+" (Mala)";
    }
    if(puntuacionFinal>=12 && puntuacionFinal<=16){
        document.getElementById("resultado").value=puntuacionFinal+" (Buena)";
    }
    if(puntuacionFinal>=17 && puntuacionFinal<=21){
        document.getElementById("resultado").value=puntuacionFinal+" (Muy Buena)";
    }
    if(puntuacionFinal>21){
        document.getElementById("resultado").value=puntuacionFinal+" (Excelente)";
    }
}

//Esta función devuelve el número de puntos ganados gracias a la longitud de la contraseña
function puntosPorLongitud(){
    var contra=document.getElementById("password").value;
    var longitud=contra.length;
    switch (longitud){
        case 8:
            return 1;
            break;
        case 9:
            return 2;
            break;
        case 10:
            return 4;
            break;
        case 11:
            return 6;
            break;
        case 12:
            return 8;
            break;
    }
}
//Esta función devuelve el número de puntos ganados gracias al número de mayúsculas de la contraseña
function puntosPorMayusculas(){
    var contra=document.getElementById("password").value;
    var nveces=contra.match(expresionMayuculas).length;
    return nveces;
}
//Esta función devuelve el número de puntos ganados gracias al número de números de la contraseña
function puntosPorNumeros(){
    var contra=document.getElementById("password").value;
    var nveces=contra.match(expresionNumeros).length;
    return nveces*2;
}
//Esta función devuelve el número de puntos ganados por incluir uno de los símbolos seleccionados en la contraseña
function puntosPorSimbolo(){
    var contra=document.getElementById("password").value;
    if(contra.match(expresionSimbolos)!=null){
        return 3;
    }else{
        return 0;
    }
}

//Este método dejará la página preparada para que el usuario pueda introducir una nueva contraseña
function nuevaValoracion(){
    document.getElementById("password").disabled=false;
    document.getElementById("valorar").disabled=true;
    document.getElementById("password").value="";
    document.getElementById("resultado").value="";
    document.getElementById("resetear").disabled=true;
}
//Este método creará un botón nuevo y le añadirá un evento o, habilitará el botón si este a ha sido creado
function mostrarBotonNuevo(){
    if(document.getElementById("resetear")==null){
        var elementoBoton = document.createElement("button");
        elementoBoton.setAttribute('id','resetear');
        elementoBoton.appendChild(document.createTextNode("Valorar nueva contraseña"));
        document.getElementById("volver").appendChild(elementoBoton);
        elementoBoton.addEventListener('click',nuevaValoracion);
    }else{
        document.getElementById("resetear").disabled=false;
    }
}