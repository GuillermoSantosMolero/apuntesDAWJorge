/**
 * @author Guillermo Santos Molero
 *
 */
public class DNI {
	private int DNI=0;
	private char letra;
	private static final String letras= "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public DNI(int DNI, char letraEntrada) {
		this.DNI=DNI;
		this.letra=calcularLetra(this.DNI);
	}
	static char calcularLetra (int DNI) {
		int resto;
		resto=DNI%23;
		return letras.charAt(resto);
	}
	static boolean comprobarNIF(int numeros, char letra) {
		boolean coincide=true;
		if (calcularLetra(numeros)==letra) {
			coincide=true;
		}else {
			coincide=false;
		}
		return coincide;
	}
	public String getNIF() {
		String NIF=this.DNI+"-"+this.letra;
		return NIF;
	}
	public int getDNI() {
		return DNI;
	}

	public void setDNI(int DNI) {
		this.DNI = DNI;
		this.letra=calcularLetra(DNI);
	}
	
	public void setNIF (String NIF) {
		DNI=Integer.parseInt(NIF.substring(0, NIF.length()-1)) ;
		letra=calcularLetra(DNI);
	}
	public char getLetra() {
		return letra;
	}
	

}
