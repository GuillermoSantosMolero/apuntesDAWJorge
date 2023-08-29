//En el siguiente array guardamos los patrimonios seleccionados, en el array cada posicion tendrá otro array en el que se encontrará la información del patrimonio en cuestión,
//es decir la posicion 3 del array de patrimonios tendrá un array en el que se encontrará todos los datos de Santiago de Compostela.
var patrimonios = [["Viena","https://www.wien.info/es","../fotos/ciudades/viena.jpg"],["Brujas","https://www.bruselas.net/brujas","../fotos/ciudades/brujas.jpg"]
,["Praga","https://www.prague.eu/es","../fotos/ciudades/praga.jpg"],["Santiago de Compostela","http://www.santiagoturismo.com/","../fotos/ciudades/santiago.jpg"]
,["Verona","http://www.italia.it/es/ideas-de-viaje/lugares-unesco/verona-ciudad-historica.html","../fotos/ciudades/verona.jpg"]
,["Angkor","http://angkor.com/","../fotos/monumentos/angkor.jpg"],["La gran muralla","https://www.chinahighlights.com/greatwall/","../fotos/monumentos/granmuralla.jpg"]
,["Catedral de Notre-Dame","https://www.notredamedeparis.fr/","../fotos/monumentos/notredame.jpg"]
,["Catedral de Aquisgrán","https://www.aachen-tourismus.de/en/discover/sights/aachen-cathedral/","../fotos/monumentos/aquisgran.jpg"]
,["Torre de hercules","http://www.turismocoruna.com/web/corTurServer.php?idSecweb=227&idFicha=566&id_secPadre=217&idCategoria=176","../fotos/monumentos/torrehercules.jpg"]
,["Los Glaciares","http://www.losglaciares.com/es/parque/","../fotos/parques/glaciaresarg.jpg"]
,["Montañas Rocosas Canadienses","https://es.wikipedia.org/wiki/Monta%C3%B1as_Rocosas_de_Canad%C3%A1","../fotos/parques/montanascanadienses.jpg"]
,["Parque Nacional de la Amistad","https://areasyparques.com/areasprotegidas/parque-internacional-la-amistad/","../fotos/parques/parqueamistad.jpg"]
,["Dolomitas","http://www.italia.it/es/ideas-de-viaje/lugares-unesco/dolomitas-las-montanas-rosas.html","../fotos/parques/dolomitas.jpg"]
,["Alpes Suizos","https://www.myswissalps.com/","../fotos/parques/alpessuizos.jpg"]];

//Creamos un nav y creamos un eventListener del selector que llame al método gestionarSeleccion() en caso de que el option del select cambie.
var elementonav=document.createElement("nav");
document.getElementById("menu").appendChild(elementonav);
window.onload=function(){
    document.getElementById("selector").addEventListener('change', function () {
        gestionarSeleccion();
	});
}
//La funcíon de este método será ,como indica su propio nombre, gestionar la opción que el usuario a seleccionado del select.
function gestionarSeleccion(){
    var opcion=document.getElementById("selector").value;
    switch (parseInt(opcion)){
        case 0:
            limpiarNav();
        break;
        case 1:
            limpiarNav();
            mostrarMenu(10,15);
        break;
        case 2: 
            limpiarNav();
            mostrarMenu(0,5);
        break;
        case 3: 
            limpiarNav();
            mostrarMenu(5,10);
        break;
    }
}
//Este método rellenará el nav que hemos creado anteriormente, tiene dos parámetros de entrada uno será la posición del array en el que debe de empezar, 
//y la otra será la posición del array hasta la que debe de llegar.
//Por ejemplo, los parques naturales irían de la posición 10 del array hasta el 15 (el 15 no entraría, la ultima posición del parque natural sería la 14).
//A los elementos "a" creados se le añadirá un id que corresponderá con la posición dentro del array de patrimonios.
//También creamos un eventListener que llamará a la función mostrarDatos() en el caso de que el usuario clicke sobre uno de los objetos "a".
function mostrarMenu(inicio,fin){
    for (var i=inicio; i<fin;i++){
        var elementoa=document.createElement("a");
        elementonav.appendChild(elementoa);
        var nombre = document.createTextNode(patrimonios[i][0]);
        elementoa.appendChild(nombre);
        elementoa.setAttribute("id",i);
        elementoa.addEventListener('click',function (){
            mostrarDatos(event);
        });
    }
}
//La función de este método será:
//Primero: limpiar la foto y el enlace que se haya seleccionado anteriormente, es decir si el usuario estaba en ciudades y tenía seleccionado Viena,
//cuando cambie de opción a parques naturales no le siga saliendo la imagen de Viena.
//Segundo: limpiar el contenido del nav en caso de que no sea la primera vez que se selecciona algo.
function limpiarNav(){
    document.getElementById("masInfo").setAttribute("href","#");
    document.getElementById("marco").setAttribute("src","../fotos/marco.gif");
    var alinks = document.querySelectorAll('a');
    if (alinks.length>1){
        for (var j=0;j<5;j++){
            var result = alinks[j];
            result.remove();
        }
    }
}
//Este método recogerá el id del "a" que le hemos dado en mostrarMenu(), con este id podremos saber que posición ocupa en el array por lo que solo quedaría modificar el href de masInfo
//y el src del marco para que nos muestre el enlace y la imagen correspondiente.
function mostrarDatos(evento){
    evento.preventDefault();
    var indice = evento.target.getAttribute("id");
    document.getElementById("masInfo").setAttribute("href",patrimonios[indice][1]);
    document.getElementById("marco").setAttribute("src",patrimonios[indice][2]);
}