import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Guillermo Santos Molero
 *
 */
public class Cuenta {
	String fechaApertura,fechaCierre;
	boolean activa;
	float saldo,ingreso,retiro;
	private Persona titular1;
	private Persona titular2;
	public Cuenta() {
		
	}
	//Constructor de una cuenta con un titular
	public Cuenta (String nombre1,String apellidos1,String apellidos2,float saldo) {
		this.titular1 = new Persona(nombre1,apellidos1,apellidos2);
		this.saldo=saldo;
		this.activa=true;
		this.fechaApertura=obtener_Fecha_Actual();
	}
	//Constructor de una cuenta con dos titulares
	public Cuenta (String nombre1,String primerApellido1,String segundoApellido1,String nombre2,String primerApellido2,String segundoApellido2,float saldo) {
		this.titular1 = new Persona (nombre1,primerApellido1,segundoApellido1);
		this.titular2 = new Persona (nombre2,primerApellido2,segundoApellido2);
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
	void damePrimerNombre (String nombre1) {
		this.titular1.setNombre(nombre1);
	}
	void damePrimerApellido1 (String apellidos1) {
		this.titular1.setApellido1(apellidos1);
	}
	void dameSegundoApellido1(String apellidos2) {
		this.titular1.setApellido2(apellidos2);
	}
	void dameSegundoNombre (String nombre2) {
		this.titular2.setNombre(nombre2);
	}
	void damePrimerApellidos2 (String apellido1) {
		this.titular2.setApellido1(apellido1);
	}
	void dameSegundoApellidos2 (String apellidos2) {
		this.titular2.setApellido2(apellidos2);
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
		return this.titular1.getNombre();
	}
	String verPrimerApellidos1() {
		return this.titular1.getApellido1();
	}
	String verSegundoApellidos1() {
		return this.titular1.getApellido2();
	}
	String verNombre2() {
		return this.titular2.getNombre();
	}
	String verPrimerApellidos2() {
		return this.titular2.getApellido1();
	}
	String verSegundoApellidos2() {
		return this.titular2.getApellido2();
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

	

