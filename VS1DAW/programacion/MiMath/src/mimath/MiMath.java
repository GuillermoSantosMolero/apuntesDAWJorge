package mimath;
import java.util.Scanner;
/**
 * @author Guillermo Santos Molero
 */
public class MiMath {//Inicio clase
	public static void main(String[] args) {//Inicio método principal
		float base,altura,ancho,alto,radio; //Declaramos variables 
		Scanner teclado = new Scanner(System.in);
		//Area del triángulo
		Areas atriangulo = new Areas();
		System.out.print("Inserte la base del triángulo: ");
		base=(teclado.nextFloat());
		System.out.print("Inserte la altura del triángulo: ");
		altura=(teclado.nextFloat());
		System.out.printf("El área del triángulo es:  % ,.2f\n",atriangulo.area_triangulo(base, altura));
		
		System.out.println("*****************************************************************");
		
		//Área del rectángulo
		Areas arectangulo = new Areas();
		System.out.print("Inserte el ancho del rectángulo: ");
		ancho=(teclado.nextFloat());
		System.out.print("Inserte el alto del rectángulo: ");
		alto=(teclado.nextFloat());
		System.out.printf("El área del rectángulo es: % ,.2f\n",arectangulo.area_rectangulo(ancho, alto));
		
		System.out.println("*****************************************************************");
		
		//Área del círculo
		Areas acirculo = new Areas();
		System.out.print("Inserte el radio del circulo: ");
		radio=(teclado.nextFloat());
		System.out.printf("El área del círculo es: % ,.2f\n",acirculo.area_circulo(radio));
		System.out.println("********************F      I      N******************************");
		
		teclado.close();
	}//Fin método
	
}//Fin clase
