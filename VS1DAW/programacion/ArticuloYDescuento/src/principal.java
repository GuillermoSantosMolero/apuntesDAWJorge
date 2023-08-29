/**
 * @author Guillermo Santos Molero
 */
import java.util.Scanner;
public class principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Articulo a1 = new Articulo ("FIFA 19","Videojuego simulador de futbol actualizado a la temporada 18/19",69.99f); //Iniciamos el objeto
		//Mostramos los atributos del objeto por pantalla al usuario
		System.out.println("El artículo que deseas comprar es "+a1.getNombre());
		System.out.println("La descripción del artículo que deseas comprar es "+a1.getDescripcion());
		System.out.println("El precio del "+a1.getNombre()  +"es "+a1.getPrecio());
		System.out.println("Escribe el descuento que va a ser aplicado al artículo: ");
		float descuento = teclado.nextFloat();
		a1.setDescuento(descuento);
		System.out.println("El precio del artículo con el descuento aplicado es: "+a1.getPrecioConDescuento());
		teclado.close();
	}
}
