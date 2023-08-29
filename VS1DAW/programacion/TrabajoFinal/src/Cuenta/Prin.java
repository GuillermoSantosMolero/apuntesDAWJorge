package Cuenta;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Fichero.TratamientoFicheros;

public class Prin {

	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(1999, 12, 11);
		String Cuenta;
		Scanner teclado = new Scanner(System.in);
		boolean seguir=false;
		CuentaAhorro c1=null;
		CuentaCorrienteEmpresa c2=null;
		CuentaCorrientePersonal c3 =null;
		TratamientoFicheros tf1 = null;
		/*do {
			System.out.println("Inserte Cuenta bancaria");
			Cuenta=teclado.nextLine().toUpperCase();
			c1=new CuentaAhorro("Guillermo","Santos Molero","03949310A",(GregorianCalendar) cal.clone(),Cuenta,234);
			if(c1.isError()) {
				System.out.println(c1.getlineaError());;
			}
		}while(c1.isError()==true);
		tf1=new TratamientoFicheros ("CuentasAhorro.dat");
		try {
			tf1.guardarCuenta(c1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		do {
			System.out.println("Inserte Cuenta bancaria");
			Cuenta=teclado.nextLine().toUpperCase();
			c2=new CuentaCorrienteEmpresa("Hermanos","Lopez Ruiz","03949310A",(GregorianCalendar) cal.clone(),Cuenta,2000,1.3f,234);
			c2.addEntidadAutorizada("Iberdrola", 200);
			if(c2.isError()) {
				System.out.println(c1.getlineaError());;
			}
		}while(c2.isError()==true);
		tf1=new TratamientoFicheros ("CuentasCorrienteEmpresa.dat");
		try {
			tf1.guardarCuenta(c2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		do {
			System.out.println("Inserte Cuenta bancaria");
			Cuenta=teclado.nextLine().toUpperCase();
			c3=new CuentaCorrientePersonal("Pedro","Perez Gonzalez","03949310A",(GregorianCalendar) cal.clone(),Cuenta,1000,12.3f);
			c3.addEntidadAutorizada("Vodafone", 100);
			if(c3.isError()) {
				System.out.println(c1.getlineaError());;
			}
		}while(c3.isError()==true);
		
		tf1=new TratamientoFicheros ("CuentasCorrientePersonal.dat");
		try {
			tf1.guardarCuenta(c3);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		
		tf1=new TratamientoFicheros ("CuentasCorrientePersonal.dat");
		System.out.println(tf1.mostrarCuentas());
		//Parte de buscar una cuenta
		
		/*System.out.println("Introduce Cuenta Ahorro");
		Cuenta = teclado.nextLine();
		c1=TratamientoFicheros.buscarCuentaAhorro(Cuenta);
		if (c1==null) {
			System.out.println("No se ha encontrado una cuenta que coincida");
		}else {
			System.out.println(" "+c1.getNumeroCuenta()+c1.getNombreTitular()+" "+c1.getSaldo());
		}
		System.out.println("Introduce Cuenta Corriente de empresa");
		Cuenta = teclado.nextLine();
		c2=TratamientoFicheros.buscarCuentaCorrienteEmpresa(Cuenta);
		if (c2==null) {
			System.out.println("No se ha encontrado una cuenta que coincida");
		}else {
			System.out.println(" "+c2.getNumeroCuenta()+c2.getNombreTitular()+" "+c2.getSaldo()+" "+ c2.getEntidadesAutorizadas());
		}
		
		System.out.println("Introduce Cuenta Corriente Personal");
		Cuenta = teclado.nextLine();
		c3=TratamientoFicheros.buscarCuentaCorrientePersonal(Cuenta);
		if (c3==null) {
			System.out.println("No se ha encontrado una cuenta que coincida");
		}else {
			System.out.println(" "+c3.getNumeroCuenta()+c3.getNombreTitular()+" "+c3.getSaldo()+" "+ c3.getEntidadesAutorizadas());
		}*/
		System.out.println("Introduce la cuenta en la que quiere ingresar dinero");
		Cuenta=teclado.nextLine();
		System.out.println("Introduce la cantidad que quiere ingresar");
		String dinero=teclado.nextLine();
		float cantidad = Float.parseFloat(dinero);
		tf1.ingresarDinero(Cuenta, cantidad);
		
		System.out.println(tf1.mostrarCuentas());
		
		System.out.println("Introduce la cuenta en la que quiere sacar dinero");
		Cuenta=teclado.nextLine();
		System.out.println("Introduce la cantidad que quiere sacar");
		dinero=teclado.nextLine();
		cantidad = Float.parseFloat(dinero);
		tf1.retirarDinero(Cuenta, cantidad);
		
		System.out.println(tf1.mostrarCuentas());

	}

}
