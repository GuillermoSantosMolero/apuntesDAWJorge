/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String linea;
		int opcion=0,num=0,dem=0;
		boolean semaforo=false;
		do {
			try {
			System.out.println("[1]Sumar dos fracciones");
			System.out.println("[2]Restar dos fracciones");
			System.out.println("[3]Salir");
			linea=teclado.nextLine();
			opcion=Integer.parseInt(linea);
			if(opcion>3 || opcion<1) {
				semaforo=false;
				System.out.println("Sólo están pemtidos los valores del 1 al 3");
			}
			}catch(NumberFormatException e) {
				semaforo=false;
				System.out.println("Los únicos caracteres permitidos son 1, 2 y 3");
			}
			switch (opcion) {
			case 1: //Suma de fracciones
				
				//PRIMERA FRACCION
						do {
							try {
								System.out.println("Introduzca el numerador de la primera fraccion");
								linea=teclado.nextLine();
								num=Integer.parseInt(linea);
								if (num<=0) {
									System.out.println("Sólo se permiten numeradores mayores que 0");
									semaforo=false;
								}else {
									semaforo=true;
								}
								
							}catch(NumberFormatException e) {
								semaforo=false;
							}
						}while(semaforo==false);
						do {
							try {
								System.out.println("Introduzca el denominador de la primera fraccion");
								linea=teclado.nextLine();
								dem=Integer.parseInt(linea);
								if (dem<=0) {
									System.out.println("Sólo se permiten denominadores mayores que 0");
									semaforo=false;
								}else {
									semaforo=true;
								}
							}catch(NumberFormatException e) {
								semaforo=false;
							}
						}while(semaforo==false);
						Fraccion f1=new Fraccion(num,dem);
				//SEGUNDA FRACCION
						do {
							try {
								System.out.println("Introduzca el numerador de la segunda fraccion");
								linea=teclado.nextLine();
								num=Integer.parseInt(linea);
								if (num<=0) {
									System.out.println("Sólo se permiten numeradores mayores que 0");
									semaforo=false;
								}else {
									semaforo=true;
								}
							}catch(NumberFormatException e) {
								semaforo=false;
							}
						}while(semaforo==false);
						do {
							try {
								System.out.println("Introduzca el denominador de la segunda fraccion");
								linea=teclado.nextLine();
								dem=Integer.parseInt(linea);
								if (dem<=0) {
									System.out.println("Sólo se permiten denominadores mayores que 0");
									semaforo=false;
								}else {
									semaforo=true;
								}
							}catch(NumberFormatException e) {
								semaforo=false;
							}
						}while(semaforo==false);
						Fraccion f2=new Fraccion(num,dem);
						System.out.println("La primera fracción es "+f1.getNum()+"/"+f1.getDem());
						System.out.println("La segunda fracción es "+f2.getNum()+"/"+f2.getDem());
				System.out.println("La suma de "+f1.getNum()+"/"+f1.getDem()+" + "+f2.getNum()+"/"+f2.getDem()+
						" es "+f1.sumar(f2.getNum(), f2.getDem()));
				System.out.println("**************************************************************");
				semaforo=false;
			break;
			case 2:
				//Restar fracciones
					//PRIMERA FRACCION
						do {
							try {
								System.out.println("Introduzca el numerador de la primera fraccion");
								linea=teclado.nextLine();
								num=Integer.parseInt(linea);
								if (num<=0) {
									System.out.println("Sólo se permiten numeradores mayores que 0");
									semaforo=false;
								}else {
									semaforo=true;
								}
							}catch(NumberFormatException e) {
								semaforo=false;
							}
						}while(semaforo==false);
						do {
							try {
								System.out.println("Introduzca el denominador de la primera fraccion");
								linea=teclado.nextLine();
								dem=Integer.parseInt(linea);
								if (dem<=0) {
									System.out.println("Sólo se permiten denominadores mayores que 0");
									semaforo=false;
								}else {
									semaforo=true;
								}
							}catch(NumberFormatException e) {
								semaforo=false;
							}
						}while(semaforo==false);
						f1=new Fraccion(num,dem);
					//SEGUNDA FRACCION
						do {
							try {
								System.out.println("Introduzca el numerador de la segunda fraccion");
								linea=teclado.nextLine();
								num=Integer.parseInt(linea);
								if (num<=0) {
									System.out.println("Solo se permiten numeradores mayores que 0");
									semaforo=false;
								}else {
									semaforo=true;
								}
							}catch(NumberFormatException e) {
								semaforo=false;
							}
						}while(semaforo==false);
						do {
							try {
								System.out.println("Introduzca el denominador de la segunda fraccion");
								linea=teclado.nextLine();
								dem=Integer.parseInt(linea);
								if (dem<=0) {
									System.out.println("Sólo se permiten denominadores mayores que 0");
									semaforo=false;
								}else {
									semaforo=true;
								}
							}catch(NumberFormatException e) {
								semaforo=false;
							}
						}while(semaforo==false);
						f2=new Fraccion(num,dem);
						System.out.println("La primera fracción es "+f1.getNum()+"/"+f1.getDem());
						System.out.println("La segunda fracción es "+f2.getNum()+"/"+f2.getDem());
				System.out.println("La resta de "+f1.getNum()+"/"+f1.getDem()+" - "+f2.getNum()+"/"+f2.getDem()+
						" es "+f1.restar(f2.getNum(), f2.getDem()));
				System.out.println("**************************************************************");
				semaforo=false;
			break;
			case 3:
				System.out.println("*********F  I  N - D  E  L - P  R  O  G  R  A  M  A **********");
				semaforo=true;
			break;
			}
		}while(semaforo==false);
		/*Las pruebas realizadas en este programa han sido las siguientes:
		 *En este progrma nos teniamos que asegurar que solo le entraran numeros positivos en el numerador y denominador :
		 *He probado con letras, numeros negativos, 0 y el programa responde correctamente devolviendo un mensaje y volviendo a pedir el valor.
		 *con numeros positivos dentro del rango de enteros continua con el programa.
		 *Para el menu:
		 *He probado con letras, numeros negativos, 0 y el programa responde con un mensaje y volviendo a pedir el valor.
		 *Con los valores 1, 2, 3 el programa pasa al case el cual funciona correctamente, haciendo la opcion que el usuario a seleccionado.
		 *
		*/
		teclado.close();
}
}
