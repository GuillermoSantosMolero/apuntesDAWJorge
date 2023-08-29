package Cuenta;
import java.util.HashMap;
import java.io.Serializable;
import java.util.GregorianCalendar;

//Guillermo Santos Molero
public abstract class CuentaCorriente extends Cuenta implements Serializable{
	
	private HashMap<String,Double> entidadeAutorizadas=new HashMap<String,Double>();
	
	public CuentaCorriente(String nombre, String apellidos, String NIF, GregorianCalendar fechaNacimiento,String numeroCuenta,float saldo) {
		super(nombre,apellidos,NIF,fechaNacimiento,numeroCuenta,saldo);
		
	}
	
	public void addEntidadAutorizada(String entidad,double cantMax) {
		entidadeAutorizadas.put(entidad, cantMax);
	}
	
	public String getEntidadesAutorizadas() {
		String Entidades="";
		for (HashMap.Entry<String, Double> entry : entidadeAutorizadas.entrySet()) {
		    String entidad = entry.getKey();
		    double cantidadMaxima = entry.getValue();
		    Entidades=Entidades+"\n Entidad: "+entidad+". \t Cantidad máxima: "+cantidadMaxima;
		}
		return Entidades;
	}
	
	abstract void ingresar(float cantidad);
	abstract void retirar(float cantidad);
}
