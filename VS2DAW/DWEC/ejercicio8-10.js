//Construir una funcion que reciba un string y que la retorne invertida
function darVueltaFrase(frase){
	var fraseInversa="";
	for(var i=frase.length-1;i>-1;i--){
		fraseInversa=fraseInversa+frase.charAt(i);
	}
	return fraseInversa;
}
function quitarEspacios(frase){
	var fraseBien=frase.replace(/ /g,"");
	/*for (var i=frase.length-1;i>-1;i--){
		if(frase.charAt(i)!= " "){
			fraseBien=fraseBien+frase.charAt(i);
		}
	}*/
	return fraseBien;
}
function palindromo (frase){
	//alert (frase);
	var frase1 = quitarEspacios(frase).toLowerCase();
	//alert (frase1);
	var inversa = darVueltaFrase(frase1);
	//alert(inversa);
	var respuesta="";
	if (frase1 == inversa){
		respuesta="La frase es un palindromo";
	}else{
		respuesta="La frase no es un palindromo";
	}
	return respuesta;
}