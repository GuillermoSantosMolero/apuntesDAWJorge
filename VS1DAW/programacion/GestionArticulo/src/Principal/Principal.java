package Principal;

/**
 * @author Guillermo Santos Molero
 *
 */
import GestionArticulo.GestionArticulo;
public class Principal {

	public static void main(String[] args) {
		GestionArticulo ga = new GestionArticulo("txt");
		ga.filtrarFicheros();
		ga.mostrarArticulos();
	}

}
