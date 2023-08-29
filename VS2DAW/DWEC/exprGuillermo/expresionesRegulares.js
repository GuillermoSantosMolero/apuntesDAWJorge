var arraytexto="";
var arrayTresCaracteres=[];
var arrayCuatroCaracteres=[];
var arrayCincoCaracteres=[];
var arraySeisCaracteres=[];
var arraySieteCaracteres=[];
var arrayOchoCaracteres=[];
function desactivarTexto(){
    document.getElementById("texto").disabled=true;
    document.getElementById("contaPalabras").disabled=false;
}

function contarPalabras(){
    document.getElementById("resultados").style.display="block";
    document.getElementById("contaPalabras").disabled=true;
    document.getElementById("numLetras").disabled=false;
    var texto=document.getElementById("texto").value;
    arraytexto = texto.split(/\b\W+\b/);
    var numeroPalabras = arraytexto.length;
    document.getElementById("palabrasTotales").innerHTML="Palabras totales: "+numeroPalabras;
    var letras=document.getElementById("numLetras").value;
    for(var i=0;i<numeroPalabras;i++){
        var letrasPalabra = arraytexto[i].length;
        switch (letrasPalabra){
            case 1:
            case 2:
            case 3:
                arrayTresCaracteres.push(arraytexto[i]);
            break;
            case 4:
                arrayCuatroCaracteres.push(arraytexto[i]);
            break;
            case 5:
                arrayCincoCaracteres.push(arraytexto[i]);
            break;
            case 6:
                arraySeisCaracteres.push(arraytexto[i]);
            break;
            case 7:
                arraySieteCaracteres.push(arraytexto[i]);
            break;
            default:
                arrayOchoCaracteres.push(arraytexto[i]);
            break;
        }
    }
}
function sacarPalabrasPorCaracteres(){
   var numLetras = document.getElementById("numLetras").value;
   document.getElementById("opcion").style.display="none";
   switch(numLetras){
        case "3":
            document.getElementById("palabras").innerHTML=arrayTresCaracteres;
            document.getElementById("subtotalPalabras").innerHTML="El sobtotal de palabras es "+arrayTresCaracteres.length;
        break;
        case "4":
            document.getElementById("palabras").innerHTML=arrayCuatroCaracteres;
            document.getElementById("subtotalPalabras").innerHTML="El sobtotal de palabras es "+arrayCuatroCaracteres.length;
        break;
        case "5":
            document.getElementById("palabras").innerHTML=arrayCincoCaracteres;
            document.getElementById("subtotalPalabras").innerHTML="El sobtotal de palabras es "+arrayCincoCaracteres.length;
        break;
        case "6":
            document.getElementById("palabras").innerHTML=arraySeisCaracteres;
            document.getElementById("subtotalPalabras").innerHTML="El sobtotal de palabras es "+arraySeisCaracteres.length;
        break;
        case "7":
            document.getElementById("palabras").innerHTML=arraySieteCaracteres;
            document.getElementById("subtotalPalabras").innerHTML="El sobtotal de palabras es "+arraySieteCaracteres.length;
        break;
        case "8":
            document.getElementById("palabras").innerHTML=arrayOchoCaracteres;
            document.getElementById("subtotalPalabras").innerHTML="El sobtotal de palabras es "+arrayOchoCaracteres.length;
        break;
   }
   
}
