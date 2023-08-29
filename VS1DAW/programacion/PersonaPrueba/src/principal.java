/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Scanner;
public class principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Persona p1 = new Persona();
		System.out.println("La persona se llama "+p1.getNombre()+" tiene "+p1.getEdad()+" años y mide "+p1.getAltura()+" m");
		Persona p2 = new Persona("Guillermo Santos",18,1.8f);
		System.out.println("La persona se llama "+p2.getNombre()+" tiene "+p2.getEdad()+" años y mide "+p2.getAltura()+" m");
		System.out.println("Introduzca el nombre ");
		String nombre = teclado.nextLine();
		System.out.println("Introduzca la edad ");
		int edad = teclado.nextInt();
		System.out.println("Introduzca la altura ");
		float altura = teclado.nextFloat();
		Persona p3 = new Persona(nombre,edad,altura);
		System.out.println("La persona se llama "+p3.getNombre()+" tiene "+p3.getEdad()+" años y mide "+p3.getAltura()+" m");
		teclado.close();
	}

}
