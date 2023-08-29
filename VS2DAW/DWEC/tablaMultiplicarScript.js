function tablaMultiplicar() {
	for (var i=1;i<=10;i++){
		var tabla=i;
		var cabecera="<p>Tabla del "+tabla+"</p>";
		tabla="";
		for (var j=1;j<=10;j++){
			tabla=tabla+i+" x "+j+" = "+i*j+"<br />";
		}
		document.getElementById("t"+i).innerHTML=cabecera+tabla;	
	}
}

function tablaMultiplicar2() {
	var parrafo="<h2>Tablas de Multiplicar</h2>";
	for (var i=1;i<=10;i++){
		var cabecera="<p>Tabla del "+i+"</p>";
		var tabla="";
		var div="";
		for (var j=1;j<=10;j++){
			tabla=tabla+i+" x "+j+" = "+i*j+"<br />";
		}
		div="<div>"+cabecera+tabla+"</div>";
		parrafo=parrafo+div;
	}
	document.getElementById("cuerpo").innerHTML=parrafo;	
}
