/**
 * 
 */
package Cuenta;

import java.io.Serializable;
import java.util.GregorianCalendar;

//Guillermo Santos Molero
public class CuentaAhorro extends Cuenta implements Serializable{
	private static float tipoInteres = (float) 3.70;
	
	public CuentaAhorro(String nombre, String apellidos, String NIF, GregorianCalendar fechaNacimiento,String numeroCuenta,float saldo) {
		super(nombre,apellidos,NIF,fechaNacimiento,numeroCuenta,saldo);
	}
	
	public static float getTipoInteres() {
		return tipoInteres;
	}

	public static void setTipoInteres(float tipoInteres) {
		CuentaAhorro.tipoInteres = tipoInteres;
	}

	public void ingresar(float cantidad) {
		this.error=false;
		this.saldo=this.saldo+cantidad;
	}
	
	public void retirar(float cantidad) {
		if(this.saldo>=cantidad) {
			this.error=false;
			this.saldo=this.saldo-cantidad;
		}else {
			this.error=true;
			this.lineaError="No puedes sacar más dinero del que tienes.";
		}
	}
	
}

