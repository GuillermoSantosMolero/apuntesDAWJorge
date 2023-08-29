/**
 * @author Guillermo Santos Molero
 *
 */
import java.util.Date;
import java.text.SimpleDateFormat;
public class Cuenta {
	String nombre1,apellidos1,nombre2,apellidos2,fechaApertura,fechaCierre;
	boolean activa;
	float saldo,ingreso,retiro;
	//Constructor de una cuenta con un titular
	public Cuenta (String nombre1,String apellidos1,float saldo) {
		this.nombre1=nombre1;
		this.apellidos1=apellidos1;
		this.saldo=saldo;
		this.activa=true;
		this.fechaApertura=obtener_Fecha_Actual();
	}
	//Constructor de una cuenta con dos titulares
	public Cuenta (String nombre1,String apellidos1,String nombre2,String apellidos2,float saldo) {
		this.nombre1=nombre1;
		this.apellidos1=apellidos1;
		this.nombre2=nombre2;
		this.apellidos2=apellidos2;
		this.saldo=saldo;
		this.activa=true;
		this.fechaApertura=obtener_Fecha_Actual();
	}
	//método para obtener fecha ¡
	private String obtener_Fecha_Actual() {
		Date objDate = new Date();// Sistema actual la fecha y la hora se asignan a objDate
		String strDateFormat = "dd-MMM-y";// El formato de fecha está especificado
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		// La cadena de formato de fecha se pasa como un argumento al objeto de formato de fecha 
		return objSDF.format(objDate); //El formato de fecha se aplica a la fecha actual 
	}
	//Pedir distintos atributos a través de distintos métodos
	void dameNombre1 (String nombre1) {
		this.nombre1=nombre1;
	}
	void dameApellidos1 (String apellidos1) {
		this.apellidos1=apellidos1;
	}
	void dameNombre2 (String nombre2) {
		this.nombre2=nombre2;
	}
	void dameApellidos2 (String apellidos2) {
		this.apellidos2=apellidos2;
	}
	void dameSaldo (float saldo) {
		this.saldo=saldo;
	}
	void dameFechaApertura(String fechaApertura) {
		this.fechaApertura=fechaApertura;
	}
	void dameFechaCierre(String fechaCierre) {
		this.fechaCierre=fechaCierre;
	}
	//Ver distintos atributos a través de distintos métodos
	String verNombre1() {
		return this.nombre1;
	}
	String verApellidos1() {
		return this.apellidos1;
	}
	String verNombre2() {
		return this.nombre2;
	}
	String verApellidos2() {
		return this.apellidos2;
	}
	float verSaldo() {
		return this.saldo;
	}
	boolean verActiva(){
		return activa;
	}
	String verFechaApertura() {
		return fechaApertura;
	}
	String verfechaCierre() {
		return this.fechaCierre;
	}
	//Cerrar cuenta
	void cerrarCuenta() {
		this.activa=false;
		fechaCierre=obtener_Fecha_Actual();
	}
	//Ingresar en la cuenta
	void ingresar(float ingreso) {
		this.saldo=this.saldo+ingreso;
	}
	//Retirar de la cuenta
	void retirar(float retiro) {
		this.saldo=this.saldo-retiro;
	}
		
	}

