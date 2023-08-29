window.onload = function () {
    //Determina si el navegador soporta getElementsByTagName
    if(!document.getElementsByTagName) return false;
    //Si lo soporta continua ejecutandolo
    var enlaces =document.getElementsByTagName("a");
    //enlaces es una array de elementos tipo <a>
    //Recorrido del array para definir el evento onclick para cada elemento 
    for(var i=0; i<enlaces.length;i++){
        enlaces[i].onclick = function () {  
            ajustar(this.getAttribute("href"),this.getAttribute("title"));
            return false;  
        }
    }
}
function ajustar(imgURL,titulo) {
    var lugar = document.getElementById("marco");
    lugar.setAttribute("src",imgURL);
    var pie = document.getElementById("pie_Foto");
    pie.firstChild.nodeValue = titulo;
}