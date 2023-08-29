/**
 * @author Guillermo
 *
 */
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		float operador1,operador2;
		Scanner teclado = new Scanner(System.in);
		
		Areas a1 = new Areas();
		System.out.println("Escribe la base del triangulo: ");
		operador1=teclado.nextFloat();
		System.out.println("Escribe la altura del triangulo: ");
		operador2=teclado.nextFloat();
		System.out.println("El area del triangulo es "+a1.area_triangulo(operador1, operador2));
		
		Areas a2 = new Areas();
		System.out.println("Escribe el primer lado del rectangulo: ");
		operador1=teclado.nextFloat();
		System.out.println("Escribe el segundo lado del rectangulo: ");
		operador2=teclado.nextFloat();
		System.out.println("El area del rectangulo es "+a2.area_rectangulo(operador1, operador2));
		
		Areas a3 = new Areas();
		System.out.println("Escribe el radio del circulo: ");
		operador1=teclado.nextFloat();
		System.out.println("El area es "+a3.area_circulo(operador1));
		
		teclado.close();
	}

}
