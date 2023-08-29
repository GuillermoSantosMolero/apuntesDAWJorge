import java.util.Scanner;

/**
 * 
 */

/**
 * @author Vespertino
 *
 */
public class principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				//Creación de la cuenta de una persona
				Scanner teclado = new Scanner(System.in);
				System.out.println("Vamos a crear la primera cuenta, pidiendo los datos por línea de comandos.");
				System.out.println("Escribe nombre del titular de la cuenta: ");
				String nombre = teclado.nextLine();
				System.out.println("Escribe primer apellido del titular de la cuenta: ");
				String apellidos1 = teclado.nextLine();
				System.out.println("Escribe segundo apellido del titular de la cuenta: ");
				String apellidos2 = teclado.nextLine();
				System.out.println("Escribe saldo de la cuenta: ");
				float saldo = teclado.nextFloat();
				Cuenta c3 = new Cuenta(nombre,apellidos1,apellidos2,saldo);
				System.out.println("El titular de la cuenta es : "+c3.verNombre1()+c3.verPrimerApellidos1()+c3.verSegundoApellidos1());
				System.out.println("La cuenta fue abierta en la siguiente fecha  : "+c3.verFechaApertura());
				System.out.printf("El cuenta tiene un saldo de % ,.2f\n",c3.verSaldo());
				System.out.println("\n\n");
				
				//Creación de la cuenta de una persona
				System.out.println("Vamos a crear la cuarta cuenta, pidiendo los datos por línea de comandos.");
				System.out.println("Escribe nombre del primer titular de la cuenta: ");
				String primerNombre = teclado.nextLine();
				System.out.println("Escribe primer apellido del primer titular de la cuenta: ");
				String primerApellidos1 = teclado.nextLine();
				System.out.println("Escribe segundo apellido del primer titular de la cuenta: ");
				String primerApellidos2 = teclado.nextLine();
				System.out.println("Escribe saldo de la cuenta: ");
				System.out.println("Escribe nombre del segundo titular de la cuenta: ");
				String segundoNombre = teclado.nextLine();
				System.out.println("Escribe primer apellido del segundo titular de la cuenta: ");
				String segundoApellidos1 = teclado.nextLine();
				System.out.println("Escribe segundo apellido del segundo titular de la cuenta: ");
				String segundoApellidos2 = teclado.nextLine();
				System.out.println("Escribe saldo de la cuenta: ");
				float saldo2 = teclado.nextFloat();
				Cuenta c4 = new Cuenta(primerNombre,primerApellidos1,primerApellidos2,segundoNombre,segundoApellidos1,segundoApellidos2,saldo2);
				System.out.println("El primer titular de la cuenta es : "+c4.verNombre1()+c4.verPrimerApellidos1()+c4.verPrimerApellidos2());
				System.out.println("El titular de la cuenta es : "+c4.verNombre2()+c4.verSegundoApellidos1()+c4.verSegundoApellidos2());
				System.out.println("La cuenta fue abierta en la siguiente fecha  : "+c4.verFechaApertura());
				System.out.printf("El cuenta tiene un saldo de % ,.2f\n",c4.verSaldo());
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
				teclado.close();

	}

}
