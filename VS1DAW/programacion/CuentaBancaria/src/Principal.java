/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Scanner;
public class Principal {	
	public static void main(String[] args) {
		//Creación de la primera cuenta
		Cuenta c1 = new Cuenta("Javier","Campo",10000);
		System.out.println("Vamos a crear la primera cuenta");	
		System.out.println("El titular de la cuenta es : "+c1.verNombre1()+c1.verApellidos1());
		System.out.println("La cuenta fue abierta en la siguiente fecha  : "+c1.verFechaApertura());
		System.out.printf("El cuenta tiene un saldo de % ,.2f\n",c1.verSaldo());
		System.out.println("\n\n");
		//Creación de la segunda
		Cuenta c2 = new Cuenta("Javier","Campo","Felipe","Sanchez",6000);
		System.out.println("Vamos a crear la segunda cuenta");
		System.out.println("El titular de la cuenta es : "+c2.verNombre1()+c2.verApellidos1());
		System.out.println("El cotitular de la cuenta es : "+c2.verNombre2()+c2.verApellidos2());
		System.out.println("La cuenta fue abierta en la siguiente fecha  : " +c2.verFechaApertura());
		System.out.printf("El cuenta tiene un saldo de % ,.2f\n",c2.verSaldo());
		System.out.println("\n\n");
		//Creación de la tercera 
		Scanner teclado = new Scanner(System.in);
		System.out.println("Vamos a crear la tercera cuenta, pidiendo los datos por línea de comandos.");
		System.out.println("Escribe nombre del titular de la cuenta: ");
		String nombre = teclado.nextLine();
		System.out.println("Escribe apellidos del titular de la cuenta: ");
		String apellidos = teclado.nextLine();
		System.out.println("Escribe saldo de la cuenta: ");
		float saldo = teclado.nextFloat();
		Cuenta c3 = new Cuenta(nombre,apellidos,saldo);
		System.out.println("El titular de la cuenta es : "+c3.verNombre1()+c3.verApellidos1());
		System.out.println("La cuenta fue abierta en la siguiente fecha  : "+c3.verFechaApertura());
		System.out.printf("El cuenta tiene un saldo de % ,.2f\n",c3.verSaldo());
		System.out.println("\n\n");
		//Ingresamos dinero en la cuenta
		System.out.println("\t Escribe ingreso en la cuenta: ");
		float ingreso = teclado.nextFloat();
		c3.ingresar(ingreso);
		System.out.printf("El cuenta tiene un saldo de % ,.2f\n",c3.verSaldo());
		//Retiramos dinero de la cuenta
		System.out.println("\t Escribe saldo retirado de la cuenta: ");
		float retiro = teclado.nextFloat();
		c3.retirar(retiro);
		System.out.printf("El cuenta tiene un saldo de % ,.2f\n",c3.verSaldo());
		//Cierre de la primera cuenta
		System.out.println("Vamos a cerrar la primera cuenta");
		c1.cerrarCuenta();
		System.out.println("Ahora el estado de la cuenta es: "+((c1.verActiva()==false)?"cerrada":"abierta"));
		System.out.println(c1.verfechaCierre());
		teclado.close();
	}

}
