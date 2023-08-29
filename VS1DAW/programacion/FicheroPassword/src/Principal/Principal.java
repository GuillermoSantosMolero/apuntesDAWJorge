/**
 * 
 */
package Principal;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import FuncionesInterfaz.FuncionesInterfaz;
/**
 * @author Guillermo Santos Molero
 *
 */
public class Principal {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner teclado = new Scanner(System.in);
		FuncionesInterfaz fi = new FuncionesInterfaz();
		String linea;
		int opcion=0;
		boolean seguir=true;
		do {
		//Menú de opciones 
			do {
				System.out.println("*************************************************************");
				System.out.println("*           S E L E C C I O N E  U N A  O P C I Ó N         *");
				System.out.println("*      1.-Añadir mail                                       *");
				System.out.println("*      2.-Listar mail                                       *");
				System.out.println("*      3.-Comprobar mail                                    *");
				System.out.println("*      4.-Borrar mail                                       *");
				System.out.println("*      5.-Borrar fichero de mails entero                    *");
				System.out.println("*      6.-Salir                                             *");
				System.out.println("*************************************************************");
				try {
					linea = teclado.nextLine();
					opcion = Integer.parseInt(linea);
					if (opcion<1 | opcion>6) {
						System.out.println("Es obligatorio introducir un número entre el 1 y el 6");
					}
				}catch(NumberFormatException e) {
					System.out.println("Es obligatorio introducir un número entre el 1 y el 6");
				}
				
			}while (opcion>6 | opcion<1);
			teclado.reset();
			switch (opcion) {
			case 1:
				fi.crearUsuario();
				break;
			case 2:
				fi.listarUsuarios();
				break;
			case 3:
				System.out.println("Introduzca el email que quiere comprobar si está registrado");
				linea= teclado.nextLine();
				if(fi.comprobarMail(linea)) {
					System.out.println("Ya existe un usuario con ese mail");
				}else {
					System.out.println("El mail introducido no existe");
				}
				break;
			case 4:
				System.out.println("Introduzca el email que quiere borrar: ");
				linea=teclado.nextLine();
				fi.borrarUsuario(linea);
				break;
			case 5:
				fi.borrarFicheroEntero();
				System.out.println("El fichero ha sido borrado");
				break;
			case 6:
				seguir=false;
				break;
			}
			
		
		}while(seguir!=false);
			teclado.close();
	}

}
