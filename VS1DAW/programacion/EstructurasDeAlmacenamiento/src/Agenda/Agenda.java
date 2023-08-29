package Agenda;
import java.util.Scanner;
/**
 * @author Guillermo Santos Molero
 *
 */
public class Agenda {
	private String[] dias= {"LUNES","MARTES","MIERCOLES","JUEVES","VIERNES","SABADO","DOMINGO"};
	private int numDias,horas;
	private String[][] agenda;
	public Agenda() {
		this.numDias=7;
		this.horas=24;
		this.agenda=new String[(this.horas)][(this.numDias)];
		rellenarAgendaVacios();
	}
	public void jugar() {
		Scanner teclado = new Scanner(System.in);
		int hora=0,dia=0;
		String mensaje;
		boolean semaforo=true;
		do {
			try {
			System.out.println("Introduzca la hora en la que quiere insertar la tarea (entre 0 y 23)");
			mensaje=teclado.nextLine();
			hora=Integer.parseInt(mensaje);
			if(hora<0 || hora>23) {
				System.out.println("El número introducido debe de estar entre el 0 y el 23");
				semaforo=false;
			}else {
				semaforo=true;
			}
			}catch(NumberFormatException e) {
				System.out.println("No has introducido un numero válido");
				semaforo=false;
			}
		}while(semaforo==false);
		do {
			try {
			System.out.println("Introduzca el dia en el que quiere insertar la tarea (entre 1 para el lunes y 7 para el domingo)");
			mensaje=teclado.nextLine();
			dia=Integer.parseInt(mensaje);
			if(dia<1 || dia>7) {
				System.out.println("El número introducido debe de estar entre el 1 y el 7");
				semaforo=false;
			}else {
				semaforo=true;
			}
			}catch(NumberFormatException e) {
				System.out.println("No has introducido un numero válido");
				semaforo=false;
			}
		}while(semaforo==false);
		System.out.println("Indroduzca el mensaje que quiere introducir en la hora "+hora+" del día"+dia);
		mensaje=teclado.nextLine();
		insertarTarea(hora,dia-1,mensaje);
		mostrarAgenda();
		
	}
	private void rellenarAgendaVacios() {
		for(int i=0;i<this.horas;i++) {
			for(int j=0;j<this.numDias;j++) {
				agenda[i][j]="No tengo planes.";
			}
		}
	}
	private void mostrarAgenda() {
		for(int a=0;a<dias.length;a++) {
			System.out.print(dias[a]+"                ");
		}
		
		for(int i=0;i<agenda.length;i++) {
			System.out.println();
			for(int j=0;j<agenda[i].length;j++) {
				System.out.print(agenda[i][j]+"     ");
			}
		}
		System.out.println();
		
	}
	private void insertarTarea (int hora,int dia,String mensaje) {
		this.agenda[hora][dia]=mensaje;
	}
	

}
