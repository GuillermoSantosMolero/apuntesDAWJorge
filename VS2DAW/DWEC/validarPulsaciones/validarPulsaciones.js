function funcionNombre(event){
    var char = event.which || event.keyCode;
    if(((char>=97 & char<=122) | (char>=65 & char<=90) | char==209 | char==241| char==32)){
        return true;
    }else{

        return false;
    }   
}
function funcionApellidos(event){
    var char = event.which || event.keyCode;
    if(((char>=97 & char<=122) | (char>=65 & char<=90) | char==209 | char==241 | char==32| char==45)){
        return true;
    }
    else
        return false;
}
function funcionDomicilio(event){
    var char = event.which || event.keyCode;
    if(((char>=97 & char<=122) | (char>=65 & char<=90) | char==209 | char==241| char==32| char==45)){
        return true;
    }else
        return false;
}
function funcionCPostal(event){
    var char = event.which || event.keyCode;
    if(char>=48 & char<=57){
        return true;
    }else
        return false;
}
function funcionPoblacion(event){
    var char = event.which || event.keyCode;
    if(((char>=97 & char<=122) | (char>=65 & char<=90) | char==209 | char==241| char==32| char==45)){
        return true;
    }else
        return false;
}
function ponerAMayusculas(){
    var texto=document.getElementById("nombre").value;
    var textoMayus=texto.toUpperCase();
    document.getElementById("nombre").value=textoMayus;
    texto=document.getElementById("apellidos").value;
    textoMayus=texto.toUpperCase();
    document.getElementById("apellidos").value=textoMayus;
    texto=document.getElementById("domicilio").value;
    textoMayus=texto.toUpperCase();
    document.getElementById("domicilio").value=textoMayus;
    texto=document.getElementById("ciudad").value;
    textoMayus=texto.toUpperCase();
    document.getElementById("ciudad").value=textoMayus;



}
function comprobarCiudad(){
    var provincias = ['','Alava','Albacete','Alicante','Almería','Asturias','Avila','Badajoz','Barcelona','Burgos','Cáceres',
        'Cádiz','Cantabria','Castellón','Ciudad Real','Córdoba','La Coruña','Cuenca','Gerona','Granada','Guadalajara',
        'Guipúzcoa','Huelva','Huesca','Islas Baleares','Jaén','León','Lérida','Lugo','Madrid','Málaga','Murcia','Navarra',
        'Orense','Palencia','Las Palmas','Pontevedra','La Rioja','Salamanca','Segovia','Sevilla','Soria','Tarragona',
        'Santa Cruz de Tenerife','Teruel','Toledo','Valencia','Valladolid','Vizcaya','Zamora','Zaragoza','Ceuta','Melilla'];
    var codPostal = document.getElementById("cPostal").value;
    var numCiudad = codPostal.substr(0,2);
    var ciudad=provincias[numCiudad].toUpperCase();
    document.getElementById("ciudad").value=ciudad;
}