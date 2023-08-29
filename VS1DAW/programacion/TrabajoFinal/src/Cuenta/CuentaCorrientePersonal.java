package Cuenta;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class CuentaCorrientePersonal extends CuentaCorriente implements Serializable{
	private float comisionMantenimiento=13.2f;
	public CuentaCorrientePersonal(String nombre, String apellidos, String NIF, GregorianCalendar fechaNacimiento,
			String numeroCuenta, float saldo,float comisionMantenimiento) {
		super(nombre, apellidos, NIF, fechaNacimiento, numeroCuenta, saldo);
		if(comisionMantenimiento>0) {
			this.error=false;
			this.comisionMantenimiento=comisionMantenimiento;
		}else{
			this.error=true;
			this.lineaError="La comisión de mantenimiento debe tener algún coste";
		}
	}
	
	public  float getComisionMantenimiento() {
		return comisionMantenimiento;
	}
	public  void setComisionMantenimiento(float comisionMantenimiento) {
		comisionMantenimiento = comisionMantenimiento;
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
