/**
 * @author Guillermo Santos Molero
 *
 */
public class Estructuras { //Inicializamos la clase 
	
	public Estructuras () { //M�todo constructor
		
	}
	
	//M�todo que nos dira si la frase de entrada es un pal�ndromo o no
	public boolean palindromo(String frase) { 
		boolean coincide=true;
		String fraseBuena=frase.replace(" ", "");
		int principio=0,fin=fraseBuena.length()-1;
		while(principio<(fraseBuena.length()/2) & coincide==true) {
			if(fraseBuena.charAt(principio)==fraseBuena.charAt(fin)) {
				++principio;
				--fin;
			}else {
					coincide=false;
			}
		}
		return coincide;
	}
	
	//M�todo que nos descompondr� el numero de entrada en multiplicaciones de numeros primos
	public void DescEnPrimos (int num) {
		int divisor=2;
		if(num>=2) {
			while(divisor<num) {
				if (num%divisor==0) {
					num=num/divisor;
					System.out.print(divisor+"*");
				}else {
					divisor++;
				}
			}
			System.out.print(divisor);
		}else {
			System.out.println("No se puede descomponer en primos un numero menor que 2");
		}
	}
	
	//M�todo devolver� la suma de los numeros que componen el numero de entrada
	public int sumaD�gitoPorComponente (int num) {
	int resto=0,sumaResto=0;
	if (num<0) {
		num=-num;
	}
		while (num>0) {
			resto=num%10;
			sumaResto=sumaResto+resto;
			num=num/10;
		}
		
		return sumaResto;
	}
	
	//M�todo que nos dir� si el n�mero de entrada es primo o no
	public boolean esPrimo (int num) {
		boolean esPrimo=true;
		for (int i=2;i<num;i++) {
			if(num%i==0) {
				esPrimo=false;
			}
		}
		return esPrimo;
	}
}
