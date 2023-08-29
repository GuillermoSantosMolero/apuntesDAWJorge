/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Articulo raton = new Articulo ("Logitech g203","Raton gaming con 6 botones e iluminación rgb para poner el color y el efecto que mas le guste",49.45f);
		System.out.println("El producto es: "+raton.getNombre());
		System.out.println(raton.getDescripcion());
		System.out.println("Cuyo precio es el de "+raton.getPrecio());
		
		System.out.println("Introduzca el descuento a aplicar ");
		int descuento = teclado.nextInt();
		raton.setDescuento(descuento);
		System.out.println("Ahora el precio del producto con el descuento del "+raton.getDescuento()+"% es de "+raton.precioConDescuento(descuento));
		teclado.close();
	}

}
