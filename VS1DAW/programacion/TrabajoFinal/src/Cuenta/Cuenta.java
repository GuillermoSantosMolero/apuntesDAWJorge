package Cuenta;
import java.io.Serializable;
import java.util.GregorianCalendar;
import Persona.Persona;
//Guillermo Santos Molero
public abstract class Cuenta implements Serializable{
	private Persona titular;
	private String numeroCuenta;
	float saldo;
	
	protected String lineaError;
	protected boolean error=false;
	public Cuenta (String nombre, String apellidos, String NIF, GregorianCalendar fechaNacimiento,String numeroCuenta,float saldo) {
		try {
			titular= new Persona(nombre,apellidos,NIF,fechaNacimiento);
			validarCuenta(numeroCuenta);
			this.numeroCuenta=numeroCuenta;
			this.saldo=saldo;
			this.error=false;
		}catch(Exception e) {
			this.error=true;
			lineaError=e.getMessage();
		}
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public boolean isError() {
		return error;
	}
	public String getlineaError() {
		return lineaError;
	}
	public String getNombreTitular() {
		return this.titular.getNombre()+" "+this.titular.getApellidos()+" con NIF:"+titular.getNIF();
	}
	
	//Calcular un dígito de control para un código de 10 dígitos
	public static String calcular1DC (String codigo) throws Exception {
		String dc;
		if (codigo == null) {
			throw new Exception ("Elemento no válido.");
		}
		if (codigo.length() != 10) {
			throw new Exception ("Elemento no válido.");
		}
		
		int n;
		int suma=0;
		for (n=0;n<10;n++) {
			int factor, cifra;
			factor = ((int)(Math.pow(2, n))) %11;
			cifra = Integer.parseInt(codigo.substring(n, n+1));
			suma +=cifra * factor;
		}
		suma = suma% 11;
		suma = 11 - suma;
		if (suma == 10)
			suma=1;
		else if (suma == 11)
			suma = 0;
		dc = String.valueOf(suma);
		return dc;
	}
	//Calcula los dígitos de control de una combinación entidad-oficina-cuenta (18 dígitos)
	public static String calcularDigitosControl (String entidad,String oficina, String cuenta) throws Exception{
		String dc;
		String dc1,dc2;
		
		if (entidad == null || oficina == null || cuenta == null) {
			throw new Exception ("Elementos no válidos.");
		}
		if (entidad.length() != 4 || oficina.length() !=4 || cuenta.length() !=10) {
			throw new Exception ("Elementos no válidos.");
		}
		String entidadoficina ="00" + entidad + oficina;
		//System.out.println(entidadoficina);
		dc1 = Cuenta.calcular1DC(entidadoficina);
		//System.out.println(dc1);
		dc2 = Cuenta.calcular1DC(cuenta);
		//System.out.println(dc2);
		dc=dc1 + dc2;
		return dc;
	}
	
	public static void validarCuenta (String ccc) throws Exception {
		boolean valido= true;
		String entidad, oficina, dcExtraido, cuenta, dcCalculado="";
		if (ccc == null) {
			throw new Exception("Debes rellenar el campo cuenta");
		}
		ccc = Cuenta.normalizarCCC(ccc);
		if (ccc.length() == 20 && valido) {
			//System.out.println(ccc);
			entidad = ccc.substring(0, 4);
			oficina = ccc.substring(4, 8);
			dcExtraido = ccc.substring(8, 10);
			cuenta = ccc.substring(10, 20);
			//System.out.println(entidad+oficina+dcExtraido+cuenta);
			try {
				dcCalculado = Cuenta.calcularDigitosControl(entidad, oficina, cuenta);
				//System.out.println(dcCalculado);
			}catch (Exception e) {
				valido=false;
			}if (valido) {
				//System.out.println(valido);
				if (dcExtraido.compareTo(dcCalculado) != 0) {
					valido = false;
					//System.out.println(valido);
				}
			}
		}else 
			valido = false;
		if (valido == false) {
			System.out.println("Manda Exception");
			throw new Exception("Cuenta no válida.");
		}
			
	}
	
	public static String normalizarCCC (String ccc) {
		String cccNormalizada;
		if (ccc.length() == 23) {
			cccNormalizada = ccc.substring(0, 4)+ccc.substring(5, 9)+ccc.substring(10, 12)+ccc.substring(13, 23);
		} else {
			cccNormalizada = ccc;
		}
		return cccNormalizada;
	}
	abstract void ingresar(float cantidad);
	abstract void retirar(float cantidad);
}
