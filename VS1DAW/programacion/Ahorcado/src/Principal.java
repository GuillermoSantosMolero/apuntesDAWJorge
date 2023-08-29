/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Scanner;
public class Principal { //Inicio clase principal
	public static void main(String[] args) { //Inicio método principal
		//Declaracion de objetos
		Scanner teclado = new Scanner (System.in);
		Ahorcado a1 = new Ahorcado();
	//Primer do-while que llevará las partidas 
		do {
			//Mostramos informacion general de las partidas
			System.out.println();
			System.out.println("Tu has ganado "+a1.verPartHum()+ " partidas");
			System.out.println("La máquina ha ganado "+a1.verPartMaq()+" partidas");
			System.out.println();
			System.out.println("*********  Comienza la partida número "+a1.verJuego()+"  *********");
			a1.elegirPalabra();
			a1.verSolucion();
			//Este do-while llevará la partida, controlará el numero de vidas y si el usuario a acertado la palabra
			do {
			
				System.out.println("Introduzca una letra");
				String Stringletra = teclado.nextLine().toLowerCase();
				char letra = Stringletra.charAt(0);
				System.out.println(letra);
				a1.compararletra(letra);
				a1.verSolucion();
				a1.compararArrays();
				a1.meterEnLetrasUsadas(letra);
				System.out.println("Te quedan "+a1.verVidas()+" vidas");
				System.out.println("Has usado las letras:  "+a1.verLetrasUsadas());
				
				
			}while (a1.verVidas()>0 & a1.compararArrays()==false);
			//if que muestra si el usuario a perdido el juego o lo ha ganado
			if(a1.compararArrays()==false) {
				System.out.println("No has conseguido acertar la palabra");
				a1.sumarPartMaq();
			}else {
				System.out.println("Has conseguido acertar la palabra");
				a1.sumarPartHum();
			}
			a1.reiniciarVidas();
			a1.reiniciarLetrasUsadas();
			System.out.println("********* Fin juego "+a1.verJuego()+" *********");
			a1.incrementarJuego();

		}while(a1.verPartMaq()<2 & a1.verPartHum()<2);
		
		System.out.println("***********************************************************************");
		//if que mostrará si ha ganado la partida el usuario o la máquina
		if(a1.verPartHum()>a1.verPartMaq()) {
			System.out.println("	Felicidades has consequido ganar a la máquina "+a1.verPartHum()+" a "+a1.verPartMaq());
		}else {
			System.out.println("Lo sentimos no has consequido ganar a la máquina, has perdido "+a1.verPartMaq()+" a "+a1.verPartHum());
		}
		System.out.println("***********************************************************************");
	
	teclado.close();
	}
	
}
