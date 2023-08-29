package Principal;
import Adivinanza.Adivinanza;
import Agenda.Agenda;
import Ordenar.Ordenar;
import java.util.Scanner;
/**
 * @author Guillermo Santos Molero
 *
 */
public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		Adivinanza a1= new Adivinanza();
		Agenda a2=new Agenda();
		Ordenar o1= new Ordenar ();
		boolean parar=false,semaforo=true;
		int opcion=0;
		String linea;
		do {
			do {
				try {
				System.out.println("[0]Adivinar un numero");
				System.out.println("[1]Agenda");
				System.out.println("[2]Array aleatorio y colocación del mismo");
				System.out.println("[3]Salir");
				
				linea=teclado.nextLine();
				opcion=Integer.parseInt(linea);
				if(opcion>3 || opcion<0) {
					semaforo=false;
					System.out.println("Sólo están pemtidos los valores del 0 al 3");
				}else {
					semaforo=true;
				}
				}catch(NumberFormatException e) {
					semaforo=false;
					System.out.println("Los únicos caracteres permitidos son 0, 1, 2 y 3");
				}
			}while (semaforo==false);
			
			switch(opcion) {
			case 0:
				a1.jugar();
				break;
			case 1:
				a2.jugar();
				break;
			case 2:
				o1.jugar();
				break;
			case 3:
				parar=true;
				break;
			}
			
		}while (parar==false);

	}

}
