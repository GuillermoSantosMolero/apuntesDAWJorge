/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Scanner;
public class Principal {//Inicio de la clase principal
	
	public static void main(String[] args) { //Inicio m�todo main
		//Declaraci�n de objetos y variables
		Scanner teclado = new Scanner(System.in);
		Estructuras e1 = new Estructuras ();
		String frase,numero;
		int num=0;
		
		//Parte pal�ndromo
		
		System.out.println("Introduzca la frase que quiere saber si es palindromo: ");
		frase=teclado.nextLine().toLowerCase();
		if(e1.palindromo(frase)==true) {
			System.out.println("Tu frase "+frase+" es un palindromo");
		}else {
			System.out.println("Tu frase "+frase+" no es un palindromo");
		}
		/*He probado la frase alli es sevilla,1213131 y sale que no es pal�ndromo, he puesto alli ves sevilla 
		 * y sale que es un pal�ndromo, no pongo nada y pulso intro y sale que no es un pal�ndromo*/
		
		//Parte descomposicion en numeros primos
		
		System.out.println("�De que n�mero quiere saber sus descomposici�n en n�meros primos? ");
		try {
			numero=teclado.nextLine();
			num=Integer.parseInt(numero);
			e1.DescEnPrimos(num);
		}catch(NumberFormatException e) {
			System.out.println("El n�mero no entra dentro de los rangos de enteros");
		}
		/*He probado con as,2123131231231231232131 y salta la excepci�n correctament, pongo 4312 
		 * y devuelve la descomposici�n correcta 2*2*2*7*7*11, pongo el 0 y devuelve el mensaje que nos dice 
		 * que no se puede descomponer en primos un numero menor que 2, no pongo nada y pulso intro y salta la excepci�n*/
		
		//Parte suma de numeros que componen otro numero
		
		System.out.println("�De qu� numero quiere sacar la suma de los numeros que lo componen?");
		try {
			numero=teclado.nextLine();
			num=Integer.parseInt(numero);
			System.out.println("La suma de los numeros que compone a "+num+" es "+e1.sumaD�gitoPorComponente(num));
		}catch (NumberFormatException e) {
			System.out.println("El n�mero no entra dentro de los rangos enteros");
		}
		/*He probado con as,24322345241413134121 y salta la excepcion correctamente, pongo 23412311 y me devuelve 17,
		 * pongo 0 y me devuelve 0, no pongo nada, pulso intro y salta la excepci�n. */
	
		//Parte saber si es primo
		
		System.out.println("�De qu� numero quiere saber si es primo?");
		try {
			numero=teclado.nextLine();
			num=Integer.parseInt(numero);
			if(e1.esPrimo(num)==false) {
				System.out.println("Su numero "+num+" no es primo");
			}else {
				System.out.println("Su numero "+num+" es primo");
			}
		}catch (NumberFormatException e) {
			System.out.println("El n�mero no entra dentro de los rangos enteros");
		}
		/*He probado con as,11323178549037582 y salta la excepci�n, pongo 32140 y me sale que no es primo,
		 * pongo 32141,1 y me sale primo, cuando no pongo nada y pulso el intro salta la excepci�n */
		
		teclado.close();
	}

}
