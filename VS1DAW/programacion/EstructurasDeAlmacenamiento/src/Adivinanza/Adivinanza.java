package Adivinanza;
import java.util.Scanner;
/**
 * @author Guillermo Santos Molero
 */
public class Adivinanza {
	private int numeroSeleccionado,numeroEntrante;
	public Adivinanza() {
		numeroSeleccionado= (int)(Math.random() *99)+1;
	}
	public void jugar() {
		int vidas=4;
		String linea;
		boolean semaforo=false;
		Scanner teclado=new Scanner(System.in);
		do {
			do{
				try {
					System.out.println("Introduzca un valor del 1 al 100");
					linea=teclado.nextLine();
					this.numeroEntrante=Integer.parseInt(linea);
					if(this.numeroEntrante>100) {
						System.out.println("El valor introducido debe ser menor que 100");
						semaforo=false;
					}else {
						if(this.numeroEntrante<0) {
							System.out.println("El numero debe ser mayor que 0");
							semaforo=false;
						}else {
							semaforo=true;
							vidas--;
						}
					}
				}catch(NumberFormatException e){
					System.out.println("No has introducido un número válido");
					semaforo=false;
				}
			}while(semaforo=false);
			menorOMayor();
			System.out.println("Tienes "+vidas+" vidas");
		}while(vidas>0 && comprobarNumero()==false);
		if(comprobarNumero()==false) {
			System.out.println("No has conseguido acertar el numero "+this.numeroSeleccionado+", suerte la próxima vez");
		}
	}
	private boolean comprobarNumero() {
		boolean correcto=false;
		if (this.numeroEntrante==this.numeroSeleccionado) {
			correcto=true;
		}else {
			correcto=false;
		}
		return correcto;
	}
	
	private void menorOMayor() {
		if(this.numeroEntrante==this.numeroSeleccionado) {
			System.out.println("Acertaste el numero seleccionado era el "+this.numeroSeleccionado);
		}else {
			if(this.numeroEntrante>this.numeroSeleccionado) {
				System.out.println("El numero que buscas es menor que el numero "+this.numeroEntrante);
			}else {
				System.out.println("El numero que buscas es mayor que el numero "+this.numeroEntrante);
			}
		}
	}

}
