/**
 * 
 */

/**
 * @author Guillermo Santos Molero
 *
 */
import java.io.IOException;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) { //Inicio método pricipal que comienza ejecuta la aplicación 
		//Declaración de variables u objetos
		String linea;
		int opcion=0;
		Scanner teclado = new Scanner (System.in);
		MiMath m1 = new MiMath();
		//Menú de opciones 
			do {
				System.out.println("*************************************************************");
				System.out.println("*           S E L E C C I O N E  U N A  O P C I Ó N         *");
				System.out.println("*      1.-Comprobar si el número es par                     *");
				System.out.println("*      2.-Tabla de multiplicar                              *");
				System.out.println("*      3.-Número de días del mes introducido                *");
				System.out.println("*      4.-Cálculo de factores primos                        *");
				System.out.println("*      5.-Números pares entre el 1 y el 20                  *");
				System.out.println("*      6.-Calcular área del triángulo                       *");
				System.out.println("*      7.-Calcular área del rectángulo                      *");
				System.out.println("*      8.-Calcular área del círculo                         *");
				System.out.println("*************************************************************");
				try {
					linea = teclado.nextLine();
					opcion = Integer.parseInt(linea);
					if (opcion<1 | opcion>8) {
						System.out.println("Es obligatorio introducir un número entre el 1 y el 8");
					}
				}catch(NumberFormatException e) {
					System.out.println("Es obligatorio introducir un número entre el 1 y el 8");
				}
				
			}while (opcion>8 | opcion<1);
			/*He hecho pruebas con los valores: del 1 al 8 funciona correctamente y cada numero te da la opción correcta, (as) muestra 
			* la excepción deseada, (9, 9.5, 0) muestra también este mensaje, */
		
		//Usamos un swicth para hacer una determinada opción dependiendo de la que haya elegido el usuario
		switch (opcion){
		//Saber si es par admite negativos
		case 1:
			int par=0;
			do {
				System.out.println("Introduzca el número que quiere saber si es par: ");
				try {
					linea = teclado.nextLine();
					par = Integer.parseInt(linea);
					opcion=1;
				}catch(NumberFormatException e) {
					System.out.println("No has introducido un número válido ");
					opcion=0;
				}
			}while(opcion==0);
			System.out.println(m1.esPar(par));
			break;
			/*He probado a meterle los valores: 4 devuelve par,5 devuelve impar,(no, 9.5) salta la excepción que saca un mensaje por pantalla,
			* -3 saca impar,-6 saca par*/
		
		//Saber la tabla del número admite numeros negativos
		case 2:
			int numerotabla=0;
			do {
				System.out.println("¿De qué número quiere saber su tabla?");
				try {
				linea=teclado.nextLine();
				numerotabla = Integer.parseInt(linea);
				opcion=2;
				}catch(NumberFormatException e) {
					System.out.println("No has introducido un número válido");
					opcion=0;
				}
			}while (opcion==0);
			m1.tablaMultiplicar(numerotabla);
			break;
			/* He probado a meterle los valores: -5, 0 y 5 que devuelve sus respectivas tablas, (as, 9.5) salta la excepción */
		
		//Saber los dias de cada mes
		case 3:
			int mes=0,año=0;
			do { 
					System.out.println("¿De qué mes quiere saber sus días?");
					try {
						linea=teclado.nextLine();
						mes=Integer.parseInt(linea);
						opcion=3;
					}catch(NumberFormatException e) {
						System.out.println("No has introducido un número válido");
						opcion=0;
					}
					if(mes<1 | mes>12) {
						System.out.println("El número de meses debe estar entre el 1 y el 12 ");
					}
			/*He probado a meterle los valores: -1,0,13 salta la condicion if. 1 , 2, 11, 12 pasa a pedir el año. 
			 * (as) salta la excepción. 9.5 salta el mensaje de la excepcion y el de la condición if */
			}while (opcion==0 | mes<1 | mes>12);
			do {
					System.out.println("¿De qué año?");
					try {
						linea=teclado.nextLine();
						año=Integer.parseInt(linea);
						opcion=3;
					}catch (NumberFormatException e) {
						System.out.println("No has introducido un número válido");
						opcion=0;
					}
			}while (opcion==0);
			System.out.println("El mes tiene "+m1.numDias(mes, año)+" días");;
			break;
			/*He probado a meterle los valores: (-345,213) y muestra el número de dias de ese mes en ese año correctamente. 
			* (as, 9.5) salta la excepción. Cuando pedimos los dias de febrero el funcionamiento si es año bisiesto 
			* o no, funciona correctamente*/
		
		//Saber los factores del numero 
		case 4:
			int numero=0;
			do {
				System.out.println("¿De qué número quiere saber sus factores primos?");
				try {
					linea=teclado.nextLine();
					numero=Integer.parseInt(linea);
					opcion=4;
					if (numero<=0) {
						System.out.println("El número debe ser mayor que 0");
					}
				}catch(NumberFormatException e) {
					System.out.println("El número no es válido.");
					opcion=0;
				}
			}while (opcion==0 | numero<=0);
			m1.factoresPrimos(numero);
			break;
			
			/*He probado con los valores: (-12, 0) salta la condicion if. (12, 1) saca los factores del número.
			 * (as) salta la excepción */
		//Saber los numeros pares entre 1 y 20
		case 5:
			try {
				m1.numerosPares();
			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Error en el array.");
			}
			break;
			//El case funciona correctamente y realiza la acción deseada.
		//Área del triangulo
		case 6:
			float base=0, altura=0;
			do {
				try {
					System.out.print("Inserte la base del triángulo: ");
					linea = teclado.nextLine();
					base=Float.parseFloat(linea);
					opcion=6;
				}catch(NumberFormatException e) {
					System.out.println("El número no es válido.");
					opcion=0;
				}
				if(base<=0) {
					System.out.println("El valor de la base debe ser mayor que 0 ");
				}
			}while (opcion==0 | base<=0);
		/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a pedir el valor de la altura.
		 * (as) Salta la excepción*/
			do {
				try {
					System.out.print("Inserte la altura del triángulo: ");
					linea= teclado.nextLine();
					altura=Float.parseFloat(linea);
					opcion=6;
				}catch(NumberFormatException e) {
					System.out.println("El número no es válido");
					opcion=0;
				}
				if(altura<=0) {
					System.out.println("El valor de la altura debe ser mayor que 0 ");
				}
			}while(opcion==0 | altura<=0);
				System.out.printf("El área del triángulo es:  % ,.2f\n",m1.area_triangulo(base, altura));
			/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a llamar al método y 
			 * realiza la operacion deseada. (as) Salta la excepción*/
			break;
			
		//Área del rectángulo
		case 7:
			float ancho=0,alto=0;
			do {
				try {
					System.out.print("Inserte el ancho del rectángulo: ");
					linea=teclado.nextLine();
					ancho=Float.parseFloat(linea);
					opcion=7;
				}catch(NumberFormatException e) {
					System.out.println("El número no es válido ");
					opcion=0;
				}
				if(ancho<=0) {
					System.out.println("El valor del ancho debe ser mayor que 0 ");
				}
			}while(opcion==0 | ancho<=0);
			/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a pedir el valor del alto. 
			 *  (as) Salta la excepción*/
			
			do {
				try {
					System.out.print("Inserte el alto del rectángulo: ");
					linea=teclado.nextLine();
					alto=Float.parseFloat(linea);
					opcion=7;
				}catch (NumberFormatException e) {
					System.out.println("El número no es válido ");
				}
				if(alto<=0) {
					System.out.println("El valor del alto debe ser mayor que 0 ");
				}
			}while(opcion==0|alto<=0);
			System.out.printf("El área del rectángulo es: % ,.2f\n",m1.area_rectangulo(ancho, alto));
			/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a llamar al método y 
			 * realiza la operación correcta. (as) Salta la excepción*/
			break;
		//Área del círculo
		case 8:
			float radio=0;
			do {
				try {
					System.out.print("Inserte el radio del circulo: ");
					linea=teclado.nextLine();
					radio=Float.parseFloat(linea);
					opcion=8;
				}catch(NumberFormatException e) {
					System.out.println("El número no es válido ");
					opcion=0;
				}
				if(radio<=0) {
					System.out.println("El valor del radio debe ser mayor que 0 ");
				}
			}while(opcion==0 | radio<=0);
			System.out.printf("El área del círculo es: % ,.2f\n",m1.area_circulo(radio));
			/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a llamar al método y 
			 * realiza la operación correcta. (as) Salta la excepción*/
		}	
		teclado.close();
	}

}
