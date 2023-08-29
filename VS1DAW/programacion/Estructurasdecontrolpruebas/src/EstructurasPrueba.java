/**
 * @author Guillermo Santos Molero
 *
 */
public class EstructurasPrueba {

	public EstructurasPrueba() {

		
	}

public boolean palindromo (String frase) {
	boolean palindromo = true;
	
	String fraseBuena=frase.replace(" ", "");
	int principio=0, fin=fraseBuena.length()-1;
	
	while (principio<fraseBuena.length()/2 & palindromo==true) {
		if(fraseBuena.charAt(principio)!=fraseBuena.charAt(fin)) {
			palindromo=false;
		}else {
			++principio;
			--fin;
		}
	}
	return palindromo;
}

public void DescomposicionEnPrimos (int num) {
	int divisor=2;
	
	if(num>=divisor){
		while (divisor<num) {
			if(num%divisor==0) {
				System.out.print(divisor+"*");
				num=num/divisor;
			}else {
				++divisor;
			}
		}
		System.out.print(divisor);
	}else {
		System.out.println("El número debe ser mayor o igual que dos");
	}

	
}

public int SumaComponentes (int num) {
	int sumaNum=0,resto;
	
	while(num>0) {
		resto=num%10;
		num=num/10;
		sumaNum=sumaNum+resto;
	}
	return sumaNum;
}

public boolean esPrimo (int num) {
	boolean esPrimo=true;
	for(int i=2;i<num;i++) {
		if(num%i==0) {
			esPrimo=false;
		}
	}
	return esPrimo;
}
}
