package Cuenta;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class CuentaCorrienteEmpresa extends CuentaCorriente implements Serializable {
	private float tipoInteresDescubierto;
	private float maximoDescubierto;
	private static float comisionFijaDescubierto;


	public CuentaCorrienteEmpresa(String nombre, String apellidos, String NIF, GregorianCalendar fechaNacimiento,
		String numeroCuenta, float saldo,float tipoInteresDescubierto,float maximoDescubierto) {
		super(nombre, apellidos, NIF, fechaNacimiento, numeroCuenta, saldo);
		if (tipoInteresDescubierto<=0) {
			this.error=true;
			this.lineaError="El interés por descubierto debe tener un valor mayor que 0";
		}else {
			if(maximoDescubierto<=0) {
				this.error=true;
				this.lineaError="El máximo por descubierto debe tener un valor mayor que 0";
			}else {
				this.error=false;
				this.tipoInteresDescubierto=tipoInteresDescubierto;
				this.maximoDescubierto=maximoDescubierto;
			}
		}
	}

	public float getTipoInteresDescubierto() {
		return tipoInteresDescubierto;
	}

	public void setTipoInteresDescubierto(float tipoInteresDescubierto) {
		this.tipoInteresDescubierto = tipoInteresDescubierto;
	}

	public float getMaximoDescubierto() {
		return maximoDescubierto;
	}

	public void setMaximoDescubierto(float maximoDescubierto) {
		this.maximoDescubierto = maximoDescubierto;
	}

	public static float getComisionFijaDescubierto() {
		return comisionFijaDescubierto;
	}

	public static void setComisionFijaDescubierto(float comisionFijaDescubierto) {
		CuentaCorrienteEmpresa.comisionFijaDescubierto = comisionFijaDescubierto;
	}
	
	public void ingresar(float cantidad) {
		this.error=false;
		this.saldo=this.saldo+cantidad;
	}
	public void retirar(float cantidad) {
		float aux=0;
		if(cantidad<=saldo) {
			this.error=false;
			this.saldo=this.saldo-cantidad;
		}else {
			if (saldo>=0) {
				aux=cantidad-saldo;
			}else {
				aux=-saldo+cantidad;
				}
			if(aux<=this.maximoDescubierto) {
				aux=aux+((this.tipoInteresDescubierto/100)*aux)+this.comisionFijaDescubierto;
				this.saldo=-aux;
				this.error=false;
			}else {
				this.error=true;
				this.lineaError="Has sobrepasado el límite del Descubierto";
			}
		}
	}

}
