/**
 * @author Guillermo Santos Molero
 *
 */
public class Vehiculo {//Inicio clase Vehiculo
	//variables
	private String matricula;
	private String modelo;
	private int potencia;
	//Constructor
	public Vehiculo(String matricula,String modelo, int potencia) {
		this.matricula=matricula;
		this.modelo=modelo;
		this.potencia=potencia;
	}
	//Métodos get y set
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	} 
	
	//Método que comprueba que la matrícula sea correcta
	static boolean comprobarMatricula(String matricula) {
		boolean coincide=true;
		int numero;
		try {
			if(matricula.length()==7) {
				numero=Integer.parseInt(matricula.substring(0,4));
				int nLetra=4;
				if(numero<0) {
					coincide=false;
				}
				while(nLetra<7&coincide==true) {
					if(Character.isLetter(matricula.charAt(nLetra))==true){
						nLetra++;
					}else {
						coincide=false;
					}
				}
			}else {
				coincide=false;
			}
		}catch (NumberFormatException e) {
			coincide=false;
		}
		return coincide;
	}

}//Fin clase Vehiculo

