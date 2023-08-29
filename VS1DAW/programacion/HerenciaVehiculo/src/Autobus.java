/**
 * @author Guillermo Santos Molero
 *
 */
public class Autobus extends Vehiculo{ //Inicio clase que hereda de la clase vehiculo
	private int numerodeplazas=25;
	//M�todo constructor
	public Autobus(String matricula, String modelo, int potencia, int numeroPlazas) {
		super(matricula,modelo,potencia);
		this.numerodeplazas=numeroPlazas;
	}
	//M�todos get y set
	public int getNumerodeplazas() {
		return numerodeplazas;
	}

	public void setNumerodeplazas(int numerodeplazas) {
		this.numerodeplazas = numerodeplazas;
	}
	
}
