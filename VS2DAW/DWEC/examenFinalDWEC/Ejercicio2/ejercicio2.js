//Ejercicio 2 de Guillermo Santos Molero

//Array donde guardaremos los contactos
var arrayContactos=[];

//Añadimos los eventos necesarios a los elementos de nuestro html
document.getElementById("telefono").addEventListener('keydown', soloNumeros);
document.getElementById("nombre").addEventListener('keydown', soloLetras);
document.getElementById("apellido1").addEventListener('keydown', soloLetras);
document.getElementById("apellido2").addEventListener('keydown', soloLetras);
document.getElementById("grabar").addEventListener('click',preguntarConfirmacion);

//Método que impide que pueda entrar otra cosa que no sean letras
function soloLetras(e){
    if(e.key.match(/[a-zñçáéíóú\s]/i)===null) {
      e.preventDefault();
  }
}
//Método que impide que pueda entrar otra cosa que no sean números
function soloNumeros(e){
  var key = window.Event ? e.which : e.keyCode;
  if(document.getElementById("telefono").value.length==9){
      if(key!=8){
          e.preventDefault();
      }
  }
  if (e.key.match(/[0-9]/)===null && (key!==8))
      e.preventDefault();   
}

//Método que limpia los datos que hubiese en los distintos campos
function vaciarFormulario(){
    var arrayInputs = document.querySelectorAll('input');
    for (var i=0;i<=arrayInputs.length-1;i++){
        var result = arrayInputs[i];
        result.value="";
    }
    arrayInputs[arrayInputs.length-1].checked=0;
}

//Este método lanza un confirm que preguntará si queremos guardar nuestro contacto, en caso de ok
//llama a los métodos necesarios. En caso de cancel, solo limpia los campos
function preguntarConfirmacion(){
    var respuesta=confirm("¿Estas seguro de Grabar el contacto?");
    if(respuesta){
        guardarObjeto();
        vaciarFormulario();
        comprobarGuardados();
    }else{
        vaciarFormulario();
     }
}

//Método que guarda el objeto js en el arrayContactos
function guardarObjeto(){
    var arrayInput = document.querySelectorAll("input");
    var contacto =new Object();
    for(var j=0;j<arrayInput.length-1;j++){
        var result = arrayInput[j];
        Object.defineProperty(contacto,result.getAttribute("id"),{value: result.value, writable:true, enumerable:true, configurable:true});
    }
    var verano=false;
    if(document.getElementById("verano").checked!=false){
        verano=true;
    }
    Object.defineProperty(contacto,"verano",{value: verano, writable:true, enumerable:true, configurable:true});
    arrayContactos.push(contacto);
}
//Método que comprobará el número de contactos que tenemos guardados, en caso de que halla 2 o más
//lanzará un confirm que preguntará si desea finalizar de introducir contactos y llama al 
//método oportuno en caso de afirmativo
function comprobarGuardados(){
    if(arrayContactos.length>=2){
        var respuesta=confirm("¿Desea finalizar la introducción de contactos?");
        if(respuesta){
            transformarJson();
        }
    }
}

//Método que convierte el arrayContactos a JSON quitando los atributos correo y telefono 
//de los objetos y modificando el valor de verano en cada objeto en función de si tenía el 
//valor true o false. También lo muestra por pantalla mientras oculta el formulario.
function transformarJson(){
    var filtro = function (clave, valor) {
        if (clave === "telefono" || clave === "correo") {
          return undefined;
        }
        if (clave==="verano"){
            if(valor){
                return "Si";
            }else{
                return "No";
            }
        }
        return valor;
    }
    var myjson=JSON.stringify(arrayContactos,filtro,6);
    document.getElementById("formulario").style.display="none";
    var elementoResultado=document.getElementById("resultado");
    var lineaResultado=document.createTextNode(myjson)
    elementoResultado.appendChild(lineaResultado);
}