/**
 * @author Guillermo
 *
 */
import java.util.Scanner;
public class principal {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Vamos a crear la primera cuenta");
		Cuenta c2 = new Cuenta("Javier","Campo",10000);
		System.out.println("El titular de la cuenta es "+c2.getNombrePrimerTitular()+" "+c2.getApellidosPrimerTitular());
		System.out.println("La cuenta fue abierta en la siguiente fecha: "+c2.getFechaApertura());
		System.out.printf("El cuenta tiene un saldo de % ,.2f\n\n",c2.getSaldo());
		
		System.out.println("Vamos a crear la segunda cuenta");
		Cuenta c3 = new Cuenta("Felipe","Sanchez","Lucas","Perez",6000);
		System.out.println("El titular de la cuenta es "+c3.getNombrePrimerTitular()+" "+c3.getApellidosPrimerTitular());
		System.out.println("El cotitular de la cuenta es: "+c3.getNombreSegundoTitular()+" "+c3.getApellidosSegundoTitular());
		System.out.println("La cuenta fue abierta en la siguiente fecha: "+c3.getFechaApertura());
		System.out.printf("El cuenta tiene un saldo de % ,.2f\n\n",c3.getSaldo());
		
		System.out.println("Vamos a crear la tercera cuenta, pidiendo los datos por línea de comandos.");
		System.out.println("Introduce el nombre del titular: ");
		String nombre1 = teclado.nextLine();
		System.out.println("Introduce los apellidos del titular: ");
		String apellidos1 = teclado.nextLine();
		System.out.println("Introduce el saldo del titular: ");
		float saldo = teclado.nextFloat();
		Cuenta c1 = new Cuenta(nombre1,apellidos1,saldo);
		System.out.println("El titular de la cuenta es "+c1.getNombrePrimerTitular()+" "+c1.getApellidosPrimerTitular());
		System.out.println("La cuenta fue abierta en la siguiente fecha: "+c1.getFechaApertura());
		System.out.printf("El cuenta tiene un saldo de % ,.2f\n\n",c1.getSaldo());
		
		
		System.out.println("\tEscribe el ingreso de la cuenta ");
		float ingreso = teclado.nextFloat();
		System.out.println("Ahora la cuenta tiene un saldo de "+c2.ingresar(ingreso));
		
		System.out.println("\tEscribe el ingreso de la cuenta ");
		float retiro = teclado.nextFloat();
		System.out.println("Ahora la cuenta tiene un saldo de "+c2.retiro(retiro));
		
		System.out.println("Vamos a cerrar la cuenta ");
		c2.cerrar_cuenta();
		System.out.println("Ahora el estado de la cuenta es: "+((c2.getActiva()==false)?"cerrada":"abierta"));
		System.out.println(c2.getFechaCierre());
		teclado.close();
	}

}
