import java.util.Date;
import java.text.SimpleDateFormat;
public class Cuenta {
	String nombrePrimerTitular,apellidosPrimerTitular,nombreSegundoTitular,apellidosSegundoTitular,fechaApertura,fechaCierre;
	float saldo;
	boolean activa=false;
	public Cuenta(String nombrePrimerTitular,String apellidosPrimerTitular,float saldo) {
		this.nombrePrimerTitular=nombrePrimerTitular;
		this.apellidosPrimerTitular=apellidosPrimerTitular;
		this.saldo=saldo;
		activa=true;
		this.fechaApertura=obtener_Fecha_Actual();
	}
	public Cuenta(String nombrePrimerTitular,String apellidosPrimerTitular,String nombreSegundoTitular,String apellidosSegundoTitular,float saldo) {
		this.nombrePrimerTitular=nombrePrimerTitular;
		this.apellidosPrimerTitular=apellidosPrimerTitular;
		this.nombreSegundoTitular=nombreSegundoTitular;
		this.apellidosSegundoTitular=apellidosSegundoTitular;
		this.saldo=saldo;
		activa=true;
		this.fechaApertura=obtener_Fecha_Actual();
	}
	
	private String obtener_Fecha_Actual() {
		Date objDate = new Date();
		String strDateFormat= "dd-MMM-y";
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		return objSDF.format(objDate);
	}
	public String getNombrePrimerTitular() {
		return nombrePrimerTitular;
	}
	public void setNombrePrimerTitular(String nombrePrimerTitular) {
		this.nombrePrimerTitular = nombrePrimerTitular;
	}
	public String getApellidosPrimerTitular() {
		return apellidosPrimerTitular;
	}
	public void setApellidosPrimerTitular(String apellidosPrimerTitular) {
		this.apellidosPrimerTitular = apellidosPrimerTitular;
	}
	public String getNombreSegundoTitular() {
		return nombreSegundoTitular;
	}
	public void setNombreSegundoTitular(String nombreSegundoTitular) {
		this.nombreSegundoTitular = nombreSegundoTitular;
	}
	public String getApellidosSegundoTitular() {
		return apellidosSegundoTitular;
	}
	public void setApellidosSegundoTitular(String apellidosSegundoTitular) {
		this.apellidosSegundoTitular = apellidosSegundoTitular;
	}
	public String getFechaApertura() {
	
		return fechaApertura;
	}
	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public boolean getActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre=obtener_Fecha_Actual();
		this.fechaCierre = fechaCierre;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float ingresar (float ingreso) {
		saldo=this.saldo+ingreso;
		return saldo;
	}
	public float retiro (float retiro) {
		saldo=this.saldo-retiro;
		return saldo;
	}
	public boolean cerrar_cuenta() {
		activa = false;
		fechaCierre=obtener_Fecha_Actual();
		return activa;
	} 
}
