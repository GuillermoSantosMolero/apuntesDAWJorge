/**
 * @author Guillermo
 *
 */
import java.util.Scanner;
public class principal {
	public static void main(String[] args) {
		float operador1,operador2;
		Scanner teclado = new Scanner(System.in);
		MiMath a1 = new MiMath();
	
		System.out.println("Introduzca la base del tri�ngulo");
		operador1 = teclado.nextFloat();
		System.out.println("Introduzca la altura del tri�ngulo");
		operador2 = teclado.nextFloat();
		System.out.println("El area del tri�ngulo es: "+a1.area_triangulo(operador1, operador2));
	
		System.out.println("****************************************************************************");
	
		System.out.println("Introduzca el primer lado del rect�ngulo");
		operador1 = teclado.nextFloat();
		System.out.println("Introduzca el segundo lado del rect�ngulo");
		operador2 = teclado.nextFloat();
		System.out.println("El area del rect�ngulo es: "+a1.area_rectangulo(operador1, operador2));
		
		System.out.println("****************************************************************************");
		
		System.out.println("Introduzca el radio del c�rculo");
		operador1 = teclado.nextFloat();
		System.out.println("El area del c�rculo es: "+a1.area_circulo(operador1));
		
		System.out.println("********************************F***I****N**********************************");
		teclado.close();
	}

}
