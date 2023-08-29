/**
 * 
 */
package Persona;

import java.io.Serializable;
import java.util.GregorianCalendar;

//Guillermo Santos Molero
public class Persona implements Serializable{
	private String nombre;
	private String apellidos;
	private String NIF;
	private GregorianCalendar fechaNacimiento;
	
	public Persona(String nombre,String apellidos,String NIF,GregorianCalendar fechaNacimiento) throws Exception {
		this.nombre=nombre;
		this.apellidos=apellidos;
		comprobarNIF(NIF);
		this.fechaNacimiento=fechaNacimiento;
	}
	private int extraerNumNIF(String NIF) throws Exception{
		int dni=0;
		try {
			dni=Integer.parseInt(NIF.substring(0,8));
		}catch (NumberFormatException e) {
			throw new Exception ("El número del DNI es inválido");
		}
		return dni;
	}
	private char extraerLetraNIF(String NIF) throws Exception {
		char letra=NIF.charAt(NIF.length()-1);
		if (letra=='1'||letra=='2'||letra=='3'||letra=='4'||letra=='5'||letra=='6'||letra=='7'||letra=='8'||letra=='9'||letra=='0') {
			throw new Exception("La letra del NIF no es correcta");
		}
		return letra;
	}
	private char calcularLetra (int DNI) {
		String letras= "TRWAGMYFPDXBNJZSQVHLCKE";
		int resto;
		resto=DNI%23;
		return letras.charAt(resto);
	}
	private void comprobarNIF(String NIF) throws Exception {
		boolean coincide=true;
		try {
			
			if(NIF.length()==9) {
				//System.out.println(NIF.length());
				int numeros = extraerNumNIF(NIF);
				//System.out.println(numeros);
				char letra=extraerLetraNIF(NIF);
				//System.out.println(letra);
				char letraCorrecta=calcularLetra(numeros);
				//System.out.println(letraCorrecta);
				
				if (letraCorrecta==letra) {
					coincide=true;
				}else {
					coincide=false;
				}
			}else {
				coincide=false;
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		if(coincide==false) {
			throw new Exception("El NIF es incorrecto");
		}else {
			this.NIF=NIF;
		}
	}

	//Métodos getters y setters 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) throws Exception {
		comprobarNIF(nIF);
	}

	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
