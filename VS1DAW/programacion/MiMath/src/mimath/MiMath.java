package mimath;
import java.util.Scanner;
/**
 * @author Guillermo Santos Molero
 */
public class MiMath {//Inicio clase
	public static void main(String[] args) {//Inicio m�todo principal
		float base,altura,ancho,alto,radio; //Declaramos variables 
		Scanner teclado = new Scanner(System.in);
		//Area del tri�ngulo
		Areas atriangulo = new Areas();
		System.out.print("Inserte la base del tri�ngulo: ");
		base=(teclado.nextFloat());
		System.out.print("Inserte la altura del tri�ngulo: ");
		altura=(teclado.nextFloat());
		System.out.printf("El �rea del tri�ngulo es:  % ,.2f\n",atriangulo.area_triangulo(base, altura));
		
		System.out.println("*****************************************************************");
		
		//�rea del rect�ngulo
		Areas arectangulo = new Areas();
		System.out.print("Inserte el ancho del rect�ngulo: ");
		ancho=(teclado.nextFloat());
		System.out.print("Inserte el alto del rect�ngulo: ");
		alto=(teclado.nextFloat());
		System.out.printf("El �rea del rect�ngulo es: % ,.2f\n",arectangulo.area_rectangulo(ancho, alto));
		
		System.out.println("*****************************************************************");
		
		//�rea del c�rculo
		Areas acirculo = new Areas();
		System.out.print("Inserte el radio del circulo: ");
		radio=(teclado.nextFloat());
		System.out.printf("El �rea del c�rculo es: % ,.2f\n",acirculo.area_circulo(radio));
		System.out.println("********************F      I      N******************************");
		
		teclado.close();
	}//Fin m�todo
	
}//Fin clase
