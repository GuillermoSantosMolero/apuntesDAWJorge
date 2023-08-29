/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Scanner;
public class Principal {//Inicio de la clase principal
	
	public static void main(String[] args) { //Inicio método main
		//Declaración de objetos y variables
		Scanner teclado = new Scanner(System.in);
		Estructuras e1 = new Estructuras ();
		String frase,numero;
		int num=0;
		
		//Parte palíndromo
		
		System.out.println("Introduzca la frase que quiere saber si es palindromo: ");
		frase=teclado.nextLine().toLowerCase();
		if(e1.palindromo(frase)==true) {
			System.out.println("Tu frase "+frase+" es un palindromo");
		}else {
			System.out.println("Tu frase "+frase+" no es un palindromo");
		}
		/*He probado la frase alli es sevilla,1213131 y sale que no es palíndromo, he puesto alli ves sevilla 
		 * y sale que es un palíndromo, no pongo nada y pulso intro y sale que no es un palíndromo*/
		
		//Parte descomposicion en numeros primos
		
		System.out.println("¿De que número quiere saber sus descomposición en números primos? ");
		try {
			numero=teclado.nextLine();
			num=Integer.parseInt(numero);
			e1.DescEnPrimos(num);
		}catch(NumberFormatException e) {
			System.out.println("El número no entra dentro de los rangos de enteros");
		}
		/*He probado con as,2123131231231231232131 y salta la excepción correctament, pongo 4312 
		 * y devuelve la descomposición correcta 2*2*2*7*7*11, pongo el 0 y devuelve el mensaje que nos dice 
		 * que no se puede descomponer en primos un numero menor que 2, no pongo nada y pulso intro y salta la excepción*/
		
		//Parte suma de numeros que componen otro numero
		
		System.out.println("¿De què numero quiere sacar la suma de los numeros que lo componen?");
		try {
			numero=teclado.nextLine();
			num=Integer.parseInt(numero);
			System.out.println("La suma de los numeros que compone a "+num+" es "+e1.sumaDígitoPorComponente(num));
		}catch (NumberFormatException e) {
			System.out.println("El número no entra dentro de los rangos enteros");
		}
		/*He probado con as,24322345241413134121 y salta la excepcion correctamente, pongo 23412311 y me devuelve 17,
		 * pongo 0 y me devuelve 0, no pongo nada, pulso intro y salta la excepción. */
	
		//Parte saber si es primo
		
		System.out.println("¿De què numero quiere saber si es primo?");
		try {
			numero=teclado.nextLine();
			num=Integer.parseInt(numero);
			if(e1.esPrimo(num)==false) {
				System.out.println("Su numero "+num+" no es primo");
			}else {
				System.out.println("Su numero "+num+" es primo");
			}
		}catch (NumberFormatException e) {
			System.out.println("El número no entra dentro de los rangos enteros");
		}
		/*He probado con as,11323178549037582 y salta la excepción, pongo 32140 y me sale que no es primo,
		 * pongo 32141,1 y me sale primo, cuando no pongo nada y pulso el intro salta la excepción */
		
		teclado.close();
	}

}
