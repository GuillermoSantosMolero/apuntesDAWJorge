/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Scanner;
public class Principal {//Inicio clase

	public static void main(String[] args) { //Inicio método main
		Scanner teclado = new Scanner(System.in); 
		String matricula, modelo, linea;
		int potencia, nLicencia,nPlazas;
		boolean correcto=true;
		
		//Todo lo del taxi
		do {
			try {
			//Pedir datos taxi
			System.out.println("Taxi: ");
			do {
				System.out.println("Introduce la matrícula del taxi");
				matricula=teclado.nextLine().toUpperCase();
				if(Vehiculo.comprobarMatricula(matricula) ){
					System.out.println("Matrícula correcta");
				}else {
					System.out.println("Matrícula incorrecta");
				}
			}while(Vehiculo.comprobarMatricula(matricula)!=true);
			System.out.println("Introduce el modelo del taxi");
			modelo=teclado.nextLine();
			System.out.println("Introduce el numero de licencia del taxi");
			linea=teclado.nextLine();
			nLicencia=Integer.parseInt(linea);
			System.out.println("Introduce la potencia del taxi");
			linea=teclado.nextLine();
			potencia=Integer.parseInt(linea);
			Taxi taxi1=new Taxi(matricula,modelo,potencia,nLicencia);
			//Mostrar datos taxi
			System.out.println();
			System.out.println("Datos del taxi");
			System.out.println("Matricula: "+taxi1.getMatricula());
			System.out.println("Modelo: "+taxi1.getModelo());
			System.out.println("Número de licencia: "+taxi1.getNumeroLicencia());
			System.out.println("Potencia: "+taxi1.getPotencia());
			System.out.println();
			//Modificar datos taxi
			System.out.println("Modificaciones de taxi: ");
			do {
				System.out.println("Introduce la matrícula del taxi");
				matricula=teclado.nextLine().toUpperCase();
				if(Vehiculo.comprobarMatricula(matricula) ){
					System.out.println("Matrícula correcta");
				}else {
					System.out.println("Matrícula incorrecta");
				}
			}while(Vehiculo.comprobarMatricula(matricula)!=true);
			taxi1.setMatricula(matricula);
			System.out.println("Introduce el modelo del taxi");
			modelo=teclado.nextLine();
			taxi1.setModelo(modelo);
			System.out.println("Introduce el numero de licencia del taxi");
			linea=teclado.nextLine();
			nLicencia=Integer.parseInt(linea);
			taxi1.setNumeroLicencia(nLicencia);
			System.out.println("Introduce la potencia del taxi");
			linea=teclado.nextLine();
			potencia=Integer.parseInt(linea);
			taxi1.setPotencia(potencia);
			//Mostrar nuevos datos taxi
			System.out.println();
			System.out.println("Datos del taxi");
			System.out.println("Matricula: "+taxi1.getMatricula());
			System.out.println("Modelo: "+taxi1.getModelo());
			System.out.println("Número de licencia: "+taxi1.getNumeroLicencia());
			System.out.println("Potencia: "+taxi1.getPotencia());
			System.out.println();
			correcto=true;
			}catch(NumberFormatException e) {
				System.out.println("El valor introducido no es valido");
				correcto=false;
			}catch (Exception e) {
				System.out.println(e.getMessage());
				correcto= false;
			}
		}while(correcto==false);
		
		//Todo lo del autobus
		do {
			try {
				//Pedir datos autobus
				System.out.println("Autobus: ");
				do {
					System.out.println("Introduce la matrícula del autobus");
					matricula=teclado.nextLine().toUpperCase();
					if(Vehiculo.comprobarMatricula(matricula) ){
						System.out.println("Matrícula correcta");
					}else {
						System.out.println("Matrícula incorrecta");
					}
				}while(Vehiculo.comprobarMatricula(matricula)!=true);
				System.out.println("Introduce el modelo del autobus");
				modelo=teclado.nextLine();
				System.out.println("Introduce el numero de plazas del autobus");
				linea=teclado.nextLine();
				nPlazas=Integer.parseInt(linea);
				System.out.println("Introduce la potencia del autobus");
				linea=teclado.nextLine();
				potencia=Integer.parseInt(linea);
				Autobus autobus1=new Autobus(matricula,modelo,potencia,nPlazas);
				//Mostrar datos autobus
				System.out.println("Datos del autobus");
				System.out.println("Matricula: "+autobus1.getMatricula());
				System.out.println("Modelo: "+autobus1.getModelo());
				System.out.println("Número de plazas: "+autobus1.getNumerodeplazas());
				System.out.println("Potencia: "+autobus1.getPotencia());
				System.out.println();
				//Modificar datos autobus
				System.out.println("Modificaciones del autobus: ");
				do {
					System.out.println("Introduce la matrícula del autobua");
					matricula=teclado.nextLine().toUpperCase();
					if(Vehiculo.comprobarMatricula(matricula) ){
						System.out.println("Matrícula correcta");
					}else {
						System.out.println("Matrícula incorrecta");
					}
				}while(Vehiculo.comprobarMatricula(matricula)!=true);
				autobus1.setMatricula(matricula);
				System.out.println("Introduce el modelo del autobus");
				modelo=teclado.nextLine();
				autobus1.setModelo(modelo);
				System.out.println("Introduce el numero de plazas del autobus");
				linea=teclado.nextLine();
				nPlazas=Integer.parseInt(linea);
				autobus1.setNumerodeplazas(nPlazas);
				System.out.println("Introduce la potencia del autobus");
				linea=teclado.nextLine();
				potencia=Integer.parseInt(linea);
				autobus1.setPotencia(potencia);
				//Mostrar datos autobus
				System.out.println("Datos del autobus");
				System.out.println("Matricula: "+autobus1.getMatricula());
				System.out.println("Modelo: "+autobus1.getModelo());
				System.out.println("Número de plazas: "+autobus1.getNumerodeplazas());
				System.out.println("Potencia: "+autobus1.getPotencia());
				System.out.println();
				correcto=true;
			}catch(NumberFormatException e) {
				System.out.println("El valor introducido no es valido");
				correcto=false;
			}catch (Exception e) {
				System.out.println(e.getMessage());
				correcto= false;
			}
		}while(correcto==false);
		teclado.close();
	}//Fin método main

}//Fin clase
