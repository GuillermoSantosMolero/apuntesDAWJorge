/**
 * @author Guillermo Santos Molero
 *
 */
public class DNI {
	private int DNI=0;
	private char letra;
	private static final String letras= "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public DNI() {
	}
	public void crearDni (int num, char letra)  throws Exception{
		if(comprobarNumero(num)) {
			if (letra==calcularLetra(num)) {
				this.DNI=num;
				this.letra=letra;
			}else {
				throw new Exception ("Letra inválida "+letra);
			}
		}else {
		throw new Exception ("DNI inválido: "+num);
		}
	}
	private boolean comprobarNumero(int num) {
		boolean correcto=true;
		if(num<0||num>100000000) {
			correcto=false;
		}else {
			correcto=true;
		}
		
		return correcto;
	}
	static int extraerNumNIF(String dnicompleto) throws Exception{
		int dni=0;
		try {
			dni=Integer.parseInt(dnicompleto.substring(0,dnicompleto.length()-1));
		}catch (NumberFormatException e) {
			throw new Exception ("El número del DNI es inválido");
		}
		return dni;
	}
	static char extraerLetraNIF (String dnicompleto) {
		char letra=dnicompleto.charAt(dnicompleto.length()-1);
		return letra;
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
