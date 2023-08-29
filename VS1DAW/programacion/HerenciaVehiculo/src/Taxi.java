/**
 * @author Guillermo Santos Molero
 *
 */
public class Taxi extends Vehiculo { //Inicio clase que hereda de la clase vehiculo
	private int numeroLicencia;
	//Constructor
	public Taxi(String matricula, String modelo, int potencia, int numeroLicencia) {
		super(matricula,modelo,potencia);
		this.numeroLicencia=numeroLicencia;
	}
	//Métodos get y set
	public int getNumeroLicencia() {
		return numeroLicencia;
	}

	public void setNumeroLicencia(int numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}
}
