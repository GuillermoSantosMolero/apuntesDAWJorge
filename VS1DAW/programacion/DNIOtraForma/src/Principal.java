/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		String linea;
		int opcion=-1,dni=0;
		char letra='*';
		boolean valido=true, seguir=true;
		Scanner teclado= new Scanner(System.in);
		DNI dni1= new DNI();
		do {
			try {
				System.out.println("Escribe el numero del DNI (sin letra)");
				linea=teclado.nextLine();
				dni=Integer.parseInt(linea);
				System.out.println("Escribe la letra del DNI");
				linea=teclado.nextLine().toUpperCase();
				letra=linea.charAt(0);
				dni1.crearDni(dni, letra);
				valido=true;
			}catch (NumberFormatException e) {
				System.out.println("El número introducido no es válido");
				valido=false;
			}catch (Exception  e) {
				valido=false;
				System.out.println(e.getMessage());
			}
		}while(valido==false);
		/*He introducido valores que no deben valer como numero de dni y salta la excepción correspondiente,
		 * he probado con las letras y solo acepta la letra correspondiente al numero de dni*/
		System.out.println("Se ha introducido el DNI : "+dni);
		System.out.println("Se ha introducido el NIF : "+dni1.getNIF());
		
		do {	
				try {
					System.out.println("*************************************************************");
					System.out.println("*           S E L E C C I O N E  U N A  O P C I Ó N         *");
					System.out.println("*      0.-Salir                                             *");
					System.out.println("*      1.-Modificar número del DNI                          *");
					System.out.println("*      2.-Modificar NIF completo                            *");
					System.out.println("*      3.-Comprobar otro NIF                                *");
					System.out.println("*      4.-Calcular letra DNI                                *");
					System.out.println("*************************************************************");
						linea = teclado.nextLine();
						opcion = Integer.parseInt(linea);
						valido=true;
						if (opcion<0 | opcion>4) {
							System.out.println("Es obligatorio introducir un número entre el 1 y el 8");
							valido=false;
						}
					/*He probado con letras y repite el menu, he probado con numeros que no esten entre 0 y 4 y funciona correctamente*/
					switch(opcion) {
					case 0:
						seguir=false;
						System.out.println("Fin de la aplicación");
						break;
					case 1:
						System.out.println("Escribe el numero del DNI (sin letra) ");
						linea=teclado.nextLine().toUpperCase();
						dni=Integer.parseInt(linea);
						System.out.println("El nuevo valor del DNI es : "+dni );
						dni1.setDNI(dni);
						System.out.println("El nuevo valor del NIF es : "+dni1.getNIF());
						break;
						/*He probado a meterle el Nif y salta al menu, he probado con numeros muy grandes y salta al menu, 
						 * con un numero correcto para el dni funciona correctamente.*/
					case 2:
						System.out.println("Escribe el NIF (con letra) : ");
						linea=teclado.nextLine().toUpperCase();
						dni=DNI.extraerNumNIF(linea);
						letra=DNI.extraerLetraNIF(linea);
						System.out.println("El nuevo valor del DNI es : "+dni);
						if(DNI.comprobarNIF(dni,letra)==true) {
							System.out.println("El nuevo valor del NIF es : "+dni+"-"+letra);
						}else {
							System.out.println("El nuevo valor del NIF es : "+dni+"-"+	DNI.calcularLetra(dni));
						}
						dni1.setNIF(linea);
						break;
						/*He probado a introducir el nif con mas de una letra y devuelve el error correspondiente y salta el menu,
						 * he probado solo numeros, borra el último número y lo sustituye por la letra correspondiente de los demas números*/
					case 3:
						System.out.println("Escribe el NIF (con letra) : ");
						linea=teclado.nextLine().toUpperCase();
						dni=DNI.extraerNumNIF(linea);
						letra=DNI.extraerLetraNIF(linea);
						if(DNI.comprobarNIF(dni, letra)==true){
							System.out.println("EL NIF "+dni+"-"+letra+ " es correcto");
						}else {
							System.out.println("EL NIF "+dni+"-"+letra+ " no es correcto");
						}
						break;
						/*He probado con un nif incorrecto y devuelve el mensaje correcto, he probado con un nif correcto
						 * y devuelve el mensaje correcto*/
					case 4:
						System.out.println("Escribe el numero del DNI (sin letra)");
						linea=teclado.nextLine();
						dni=Integer.parseInt(linea);
						System.out.println("La letra del DNI "+dni+" es : "+DNI.calcularLetra(dni));
						break;
						/*He probado con letras y numeros y letras y salta el error correspondiente, y salta al menu, he probado
						 * con un numero correcto y devuelve su letra correctamente*/
					}
				}catch(NumberFormatException e) {	
					System.out.println("No has introducido un numero válido");
					seguir=true;
				}catch (Exception  e) {
					valido=false;
					System.out.println(e.getMessage());
				}
		}while (seguir==true);
		teclado.close();
	}

}