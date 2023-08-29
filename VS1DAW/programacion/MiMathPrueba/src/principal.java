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
	
		System.out.println("Introduzca la base del triángulo");
		operador1 = teclado.nextFloat();
		System.out.println("Introduzca la altura del triángulo");
		operador2 = teclado.nextFloat();
		System.out.println("El area del triángulo es: "+a1.area_triangulo(operador1, operador2));
	
		System.out.println("****************************************************************************");
	
		System.out.println("Introduzca el primer lado del rectángulo");
		operador1 = teclado.nextFloat();
		System.out.println("Introduzca el segundo lado del rectángulo");
		operador2 = teclado.nextFloat();
		System.out.println("El area del rectángulo es: "+a1.area_rectangulo(operador1, operador2));
		
		System.out.println("****************************************************************************");
		
		System.out.println("Introduzca el radio del círculo");
		operador1 = teclado.nextFloat();
		System.out.println("El area del círculo es: "+a1.area_circulo(operador1));
		
		System.out.println("********************************F***I****N**********************************");
		teclado.close();
	}

}
