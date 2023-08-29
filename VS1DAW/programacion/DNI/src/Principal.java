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
		do {
			System.out.println("Escribe el numero del DNI (sin letra)");
			try {
				linea=teclado.nextLine();
				dni=Integer.parseInt(linea);
				valido=true;
			}catch (NumberFormatException e) {
				System.out.println("El número introducido no es válido");
				valido=false;
			}
			
		}while(valido==false);
	
		do {
			System.out.println("Escribe la letra del DNI");
			try {
				linea=teclado.nextLine().toUpperCase();
				letra=linea.charAt(0);
				valido=true;
			}catch (NumberFormatException e) {
				System.out.println("El número introducido no es válido");
				valido=false;
			}
			
		}while(valido==false);
		DNI dni1= new DNI(dni,letra);
		System.out.println("Se ha introducido el DNI : "+dni);
		System.out.println(dni1.getNIF());
		
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
					case 2:
						System.out.println("Escribe el NIF (con letra) : ");
						linea=teclado.nextLine().toUpperCase();
						dni=Integer.parseInt(linea.substring(0,linea.length()-1));
						letra=linea.charAt(linea.length()-1);
						System.out.println("El nuevo valor del DNI es : "+dni);
						if(DNI.comprobarNIF(dni,letra)==true) {
							System.out.println("El nuevo valor del NIF es : "+dni+"-"+letra);
						}else {
							System.out.println("El nuevo valor del NIF es : "+dni+"-"+	DNI.calcularLetra(dni));
						}
						dni1.setNIF(linea);
						break;
					case 3:
						System.out.println("Escribe el NIF (con letra) : ");
						linea=teclado.nextLine().toUpperCase();
						dni=Integer.parseInt(linea.substring(0,linea.length()-1));
						letra=linea.charAt(linea.length()-1);
						if(DNI.comprobarNIF(dni, letra)==true){
							System.out.println("EL NIF "+dni+"-"+letra+ " es correcto");
						}else {
							System.out.println("EL NIF "+dni+"-"+letra+ " no es correcto");
						}
						break;
					case 4:
						System.out.println("Escribe el numero del DNI (sin letra)");
						linea=teclado.nextLine();
						dni=Integer.parseInt(linea);
						System.out.println("La letra del DNI "+dni+" es : "+DNI.calcularLetra(dni));
						break;
					}
				}catch(NumberFormatException e) {	
					System.out.println("No has introducido un numero válido");
					seguir=true;
				}
		}while (seguir==true);
		teclado.close();
	}

}
