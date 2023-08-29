function map(param1, tabla){
	var resultado = [];
	for (var i = 0;i != tabla.length;i++)
		resultado[i] = param1(tabla[i]);
	return resultado;
}
var f = function(x) {return x * x * x;};