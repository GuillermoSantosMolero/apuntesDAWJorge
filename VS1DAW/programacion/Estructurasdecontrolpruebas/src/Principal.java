/**
 * @author Guillermo Santos Molero
 *
 */
import java.io.IOException;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		EstructurasPrueba e1 = new EstructurasPrueba ();
		
		System.out.println("Introduzca la frase que quiere saber si es un palindromo ");
		String frase=teclado.nextLine().toLowerCase();
		if(e1.palindromo(frase)==true) {
			System.out.println("Su frase "+frase+ " es un palíndromo");
		}else {
			System.out.println("Su frase "+frase+ " no es un palíndromo");
		}
		
		int num=0;
		String numero;
		try {
			System.out.println("Introduzca el numero del que quiere saber su descomposicion en numeros primos");
			numero=teclado.nextLine();
			num=Integer.parseInt(numero);
			e1.DescomposicionEnPrimos(num);
		}catch (NumberFormatException e) {
			System.out.println("Los caracteres que has introducido no son numeros o no entran en el rango de enteros");
		}
		System.out.println();
		
		try {
			System.out.println("Introduzca el numero del cual quiere saber la suma de sus componentes");
			numero=teclado.nextLine();
			num=Integer.parseInt(numero);
			System.out.println("La suma de los Componentes del numero "+num +" es "+e1.SumaComponentes(num));
		}catch (NumberFormatException e){
			System.out.println("Los caracteres que has introducido no son numeros o no entran en el rango de enteros");
		}
		
		try {
			System.out.println("Introduzca el numero del cual quiere saber si es primo");
			numero=teclado.nextLine();
			num=Integer.parseInt(numero);
			if(e1.esPrimo(num)==true){
				System.out.println("Su número "+num+" es primo");
			}else {
				System.out.println("Su número "+num+" no es primo");
			}
		}catch (NumberFormatException e){
			System.out.println("Los caracteres que has introducido no son numeros o no entran en el rango de enteros");
		}
		
		teclado.close();
	}
	

}
