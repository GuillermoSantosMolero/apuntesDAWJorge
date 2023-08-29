function muestraImagen(objeto){
    var origen = objeto.getAttribute("href");
    var lugar = document.getElementById("marco");
    lugar.setAttribute("src",origen);
    var titulo = objeto.getAttribute("title")
    var pie = document.getElementById("pie_Foto");
    pie.firstChild.nodeValue = titulo;
}