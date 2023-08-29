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

	public static void main(String[] args) { //Inicio m�todo pricipal que comienza ejecuta la aplicaci�n 
		//Declaraci�n de variables u objetos
		String linea;
		int opcion=0;
		Scanner teclado = new Scanner (System.in);
		MiMath m1 = new MiMath();
		//Men� de opciones 
			do {
				System.out.println("*************************************************************");
				System.out.println("*           S E L E C C I O N E  U N A  O P C I � N         *");
				System.out.println("*      1.-Comprobar si el n�mero es par                     *");
				System.out.println("*      2.-Tabla de multiplicar                              *");
				System.out.println("*      3.-N�mero de d�as del mes introducido                *");
				System.out.println("*      4.-C�lculo de factores primos                        *");
				System.out.println("*      5.-N�meros pares entre el 1 y el 20                  *");
				System.out.println("*      6.-Calcular �rea del tri�ngulo                       *");
				System.out.println("*      7.-Calcular �rea del rect�ngulo                      *");
				System.out.println("*      8.-Calcular �rea del c�rculo                         *");
				System.out.println("*************************************************************");
				try {
					linea = teclado.nextLine();
					opcion = Integer.parseInt(linea);
					if (opcion<1 | opcion>8) {
						System.out.println("Es obligatorio introducir un n�mero entre el 1 y el 8");
					}
				}catch(NumberFormatException e) {
					System.out.println("Es obligatorio introducir un n�mero entre el 1 y el 8");
				}
				
			}while (opcion>8 | opcion<1);
			/*He hecho pruebas con los valores: del 1 al 8 funciona correctamente y cada numero te da la opci�n correcta, (as) muestra 
			* la excepci�n deseada, (9, 9.5, 0) muestra tambi�n este mensaje, */
		
		//Usamos un swicth para hacer una determinada opci�n dependiendo de la que haya elegido el usuario
		switch (opcion){
		//Saber si es par admite negativos
		case 1:
			int par=0;
			do {
				System.out.println("Introduzca el n�mero que quiere saber si es par: ");
				try {
					linea = teclado.nextLine();
					par = Integer.parseInt(linea);
					opcion=1;
				}catch(NumberFormatException e) {
					System.out.println("No has introducido un n�mero v�lido ");
					opcion=0;
				}
			}while(opcion==0);
			System.out.println(m1.esPar(par));
			break;
			/*He probado a meterle los valores: 4 devuelve par,5 devuelve impar,(no, 9.5) salta la excepci�n que saca un mensaje por pantalla,
			* -3 saca impar,-6 saca par*/
		
		//Saber la tabla del n�mero admite numeros negativos
		case 2:
			int numerotabla=0;
			do {
				System.out.println("�De qu� n�mero quiere saber su tabla?");
				try {
				linea=teclado.nextLine();
				numerotabla = Integer.parseInt(linea);
				opcion=2;
				}catch(NumberFormatException e) {
					System.out.println("No has introducido un n�mero v�lido");
					opcion=0;
				}
			}while (opcion==0);
			m1.tablaMultiplicar(numerotabla);
			break;
			/* He probado a meterle los valores: -5, 0 y 5 que devuelve sus respectivas tablas, (as, 9.5) salta la excepci�n */
		
		//Saber los dias de cada mes
		case 3:
			int mes=0,a�o=0;
			do { 
					System.out.println("�De qu� mes quiere saber sus d�as?");
					try {
						linea=teclado.nextLine();
						mes=Integer.parseInt(linea);
						opcion=3;
					}catch(NumberFormatException e) {
						System.out.println("No has introducido un n�mero v�lido");
						opcion=0;
					}
					if(mes<1 | mes>12) {
						System.out.println("El n�mero de meses debe estar entre el 1 y el 12 ");
					}
			/*He probado a meterle los valores: -1,0,13 salta la condicion if. 1 , 2, 11, 12 pasa a pedir el a�o. 
			 * (as) salta la excepci�n. 9.5 salta el mensaje de la excepcion y el de la condici�n if */
			}while (opcion==0 | mes<1 | mes>12);
			do {
					System.out.println("�De qu� a�o?");
					try {
						linea=teclado.nextLine();
						a�o=Integer.parseInt(linea);
						opcion=3;
					}catch (NumberFormatException e) {
						System.out.println("No has introducido un n�mero v�lido");
						opcion=0;
					}
			}while (opcion==0);
			System.out.println("El mes tiene "+m1.numDias(mes, a�o)+" d�as");;
			break;
			/*He probado a meterle los valores: (-345,213) y muestra el n�mero de dias de ese mes en ese a�o correctamente. 
			* (as, 9.5) salta la excepci�n. Cuando pedimos los dias de febrero el funcionamiento si es a�o bisiesto 
			* o no, funciona correctamente*/
		
		//Saber los factores del numero 
		case 4:
			int numero=0;
			do {
				System.out.println("�De qu� n�mero quiere saber sus factores primos?");
				try {
					linea=teclado.nextLine();
					numero=Integer.parseInt(linea);
					opcion=4;
					if (numero<=0) {
						System.out.println("El n�mero debe ser mayor que 0");
					}
				}catch(NumberFormatException e) {
					System.out.println("El n�mero no es v�lido.");
					opcion=0;
				}
			}while (opcion==0 | numero<=0);
			m1.factoresPrimos(numero);
			break;
			
			/*He probado con los valores: (-12, 0) salta la condicion if. (12, 1) saca los factores del n�mero.
			 * (as) salta la excepci�n */
		//Saber los numeros pares entre 1 y 20
		case 5:
			try {
				m1.numerosPares();
			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Error en el array.");
			}
			break;
			//El case funciona correctamente y realiza la acci�n deseada.
		//�rea del triangulo
		case 6:
			float base=0, altura=0;
			do {
				try {
					System.out.print("Inserte la base del tri�ngulo: ");
					linea = teclado.nextLine();
					base=Float.parseFloat(linea);
					opcion=6;
				}catch(NumberFormatException e) {
					System.out.println("El n�mero no es v�lido.");
					opcion=0;
				}
				if(base<=0) {
					System.out.println("El valor de la base debe ser mayor que 0 ");
				}
			}while (opcion==0 | base<=0);
		/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a pedir el valor de la altura.
		 * (as) Salta la excepci�n*/
			do {
				try {
					System.out.print("Inserte la altura del tri�ngulo: ");
					linea= teclado.nextLine();
					altura=Float.parseFloat(linea);
					opcion=6;
				}catch(NumberFormatException e) {
					System.out.println("El n�mero no es v�lido");
					opcion=0;
				}
				if(altura<=0) {
					System.out.println("El valor de la altura debe ser mayor que 0 ");
				}
			}while(opcion==0 | altura<=0);
				System.out.printf("El �rea del tri�ngulo es:  % ,.2f\n",m1.area_triangulo(base, altura));
			/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a llamar al m�todo y 
			 * realiza la operacion deseada. (as) Salta la excepci�n*/
			break;
			
		//�rea del rect�ngulo
		case 7:
			float ancho=0,alto=0;
			do {
				try {
					System.out.print("Inserte el ancho del rect�ngulo: ");
					linea=teclado.nextLine();
					ancho=Float.parseFloat(linea);
					opcion=7;
				}catch(NumberFormatException e) {
					System.out.println("El n�mero no es v�lido ");
					opcion=0;
				}
				if(ancho<=0) {
					System.out.println("El valor del ancho debe ser mayor que 0 ");
				}
			}while(opcion==0 | ancho<=0);
			/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a pedir el valor del alto. 
			 *  (as) Salta la excepci�n*/
			
			do {
				try {
					System.out.print("Inserte el alto del rect�ngulo: ");
					linea=teclado.nextLine();
					alto=Float.parseFloat(linea);
					opcion=7;
				}catch (NumberFormatException e) {
					System.out.println("El n�mero no es v�lido ");
				}
				if(alto<=0) {
					System.out.println("El valor del alto debe ser mayor que 0 ");
				}
			}while(opcion==0|alto<=0);
			System.out.printf("El �rea del rect�ngulo es: % ,.2f\n",m1.area_rectangulo(ancho, alto));
			/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a llamar al m�todo y 
			 * realiza la operaci�n correcta. (as) Salta la excepci�n*/
			break;
		//�rea del c�rculo
		case 8:
			float radio=0;
			do {
				try {
					System.out.print("Inserte el radio del circulo: ");
					linea=teclado.nextLine();
					radio=Float.parseFloat(linea);
					opcion=8;
				}catch(NumberFormatException e) {
					System.out.println("El n�mero no es v�lido ");
					opcion=0;
				}
				if(radio<=0) {
					System.out.println("El valor del radio debe ser mayor que 0 ");
				}
			}while(opcion==0 | radio<=0);
			System.out.printf("El �rea del c�rculo es: % ,.2f\n",m1.area_circulo(radio));
			/* He probado con los valores: (-12, 0) salta la condicion if. (12, 1) Pasa a llamar al m�todo y 
			 * realiza la operaci�n correcta. (as) Salta la excepci�n*/
		}	
		teclado.close();
	}

}
