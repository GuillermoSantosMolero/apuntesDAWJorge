function sumaDivisores(numero){
	var suma=1;
	for(var i=2;i<=numero/2;i++){
		resto=numero%i;
		if(resto==0){
			suma=suma+i;
		}
	}
	return suma;
}

function numerosAmigos(){
	var num1=document.getElementById("numero1").value;
	var num2=document.getElementById("numero2").value;
	var suma1=sumaDivisores(num1);
	var suma2=sumaDivisores(num2);
	if(num2==suma1&&num1==suma2){
		window.alert("Los numeros SON amigos");
	}else{
		window.alert("Los numeros NO SON amigos");
	}
}