package Fichero;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import Cuenta.CuentaAhorro;
import Cuenta.CuentaCorrienteEmpresa;
import Cuenta.CuentaCorrientePersonal;
import Usuario.Usuario;

public class TratamientoFicheros {
	private String fichero;
	private String cuentas="";
	private ArrayList<CuentaAhorro>cuentasAhorro=new ArrayList<CuentaAhorro>();
	private ArrayList<CuentaCorrienteEmpresa>cuentasCorrientesEmp=new ArrayList<CuentaCorrienteEmpresa>();
	private ArrayList<CuentaCorrientePersonal>cuentasCorrientesPer=new ArrayList<CuentaCorrientePersonal>();
	

	public TratamientoFicheros(String fichero) {
		this.fichero=fichero;
	}

	private static boolean tieneRegistros(String direccion) {
		boolean tiene = false;
		FileInputStream fiPassLec;
		ObjectInputStream flujoEntrada;
		Object u = null;
		
		try {
			fiPassLec = new FileInputStream(direccion);
			flujoEntrada = new ObjectInputStream(fiPassLec);
			
			//Leer el objeto del fichero
			u=flujoEntrada.readObject();
			if(u !=null) {
				tiene=true;
			}
			fiPassLec.close();
			flujoEntrada.close();
		} catch (FileNotFoundException e) {
			//System.out.println("Error: "+e.getMessage());
		} catch (Exception ex) {
			//System.out.println("Capturada excepción en tieneRegistros() ");
		}
		return (tiene);
	}
	
	public void guardarCuenta (Object cuenta) throws IOException {
		ObjectOutputStream escritorObjetos=null;
		if(this.tieneRegistros(this.fichero)) {
			escritorObjetos = new MiObjectOutPutStream(new FileOutputStream(this.fichero,true));
		}else {
			escritorObjetos = new ObjectOutputStream(new FileOutputStream(this.fichero));
		}	
		escritorObjetos.writeObject(cuenta);
		escritorObjetos.close();
	}
	
	private void leerCuentasAhorro() {
		cuentasAhorro.removeAll(cuentasAhorro);
		ObjectInputStream lectorDeObjetos = null;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream("CuentasAhorro.dat"));
			CuentaAhorro retorno = null;
			do {
				//System.out.println("Lee un objeto");
				retorno=(CuentaAhorro) lectorDeObjetos.readObject();
				this.cuentas=this.cuentas+"\n\n"+retorno.getNumeroCuenta()+"\t"+retorno.getNombreTitular()+"\t"+retorno.getSaldo()+"\t";
				cuentasAhorro.add(retorno);
			}while (retorno!=null);
			lectorDeObjetos.close();
		} catch (FileNotFoundException e) {
			//System.out.println("Todavía no hay ningún usuario");
		} catch (EOFException e) {
			try {
				lectorDeObjetos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void leerCuentasCorrienteEmpresa() {
		cuentasCorrientesEmp.removeAll(cuentasCorrientesEmp);
		ObjectInputStream lectorDeObjetos = null;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream("CuentasCorrienteEmpresa.dat"));
			CuentaCorrienteEmpresa retorno = null;
			do {
				//System.out.println("Lee un objeto");
				retorno=(CuentaCorrienteEmpresa) lectorDeObjetos.readObject();
				this.cuentas=this.cuentas+"\n\n"+retorno.getNumeroCuenta()+"\t"+retorno.getNombreTitular()+"\t"+retorno.getSaldo()+"\t"+retorno.getEntidadesAutorizadas();
				cuentasCorrientesEmp.add(retorno);
			}while (retorno!=null);
			lectorDeObjetos.close();
		} catch (FileNotFoundException e) {
			//System.out.println("Todavía no hay ningún usuario");
		} catch (EOFException e) {
			try {
				lectorDeObjetos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void leerCuentasCorrientePersonal() {
		cuentasCorrientesPer.removeAll(cuentasCorrientesPer);
		ObjectInputStream lectorDeObjetos = null;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream("CuentasCorrientePersonal.dat"));
			CuentaCorrientePersonal retorno = null;
			do {
				//System.out.println("Lee un objeto");
				retorno=(CuentaCorrientePersonal) lectorDeObjetos.readObject();
				this.cuentas=this.cuentas+"\n\n"+retorno.getNumeroCuenta()+"\t"+retorno.getNombreTitular()+"\t"+retorno.getSaldo()+"\t"+retorno.getEntidadesAutorizadas();
				cuentasCorrientesPer.add(retorno);
			}while (retorno!=null);
			lectorDeObjetos.close();
		} catch (FileNotFoundException e) {
			//System.out.println("Todavía no hay ningún usuario");
		} catch (EOFException e) {
			try {
				lectorDeObjetos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String mostrarCuentas() {
		cuentas="";
		this.leerCuentasAhorro();
		this.leerCuentasCorrienteEmpresa();
		this.leerCuentasCorrientePersonal();
		return this.cuentas;
	}
	
	public static CuentaAhorro buscarCuentaAhorro (String cuenta) {
		ObjectInputStream lectorDeObjetos = null;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream("CuentasAhorro.dat"));
			CuentaAhorro retorno = null;
			do {
				//System.out.println("Lee un objeto");
				retorno=(CuentaAhorro) lectorDeObjetos.readObject();
				if (retorno.getNumeroCuenta().equalsIgnoreCase(cuenta)) {
					lectorDeObjetos.close();
					return retorno;
				}
			}while (retorno!=null);
			lectorDeObjetos.close();
		} catch (FileNotFoundException e) {
			//System.out.println("Todavía no hay ningún usuario");
		} catch (EOFException e) {
			try {
				lectorDeObjetos.close();
			} catch (IOException e1) {
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static CuentaCorrienteEmpresa buscarCuentaCorrienteEmpresa (String cuenta) {
		ObjectInputStream lectorDeObjetos = null;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream("CuentasCorrienteEmpresa.dat"));
			CuentaCorrienteEmpresa retorno = null;
			do {
				//System.out.println("Lee un objeto");
				retorno=(CuentaCorrienteEmpresa) lectorDeObjetos.readObject();
				if (retorno.getNumeroCuenta().equalsIgnoreCase(cuenta)){
					lectorDeObjetos.close();
					return retorno;
				}
			}while (retorno!=null);
			lectorDeObjetos.close();
		} catch (FileNotFoundException e) {
			//System.out.println("Todavía no hay ningún usuario");
		} catch (EOFException e) {
			try {
				lectorDeObjetos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static CuentaCorrientePersonal buscarCuentaCorrientePersonal (String cuenta) {
		ObjectInputStream lectorDeObjetos = null;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream("CuentasCorrientePersonal.dat"));
			CuentaCorrientePersonal retorno = null;
			do {
				//System.out.println("Lee un objeto");
				retorno=(CuentaCorrientePersonal) lectorDeObjetos.readObject();
				if (retorno.getNumeroCuenta().equalsIgnoreCase(cuenta)){
					lectorDeObjetos.close();
					return retorno;
				}
			}while (retorno!=null);
			lectorDeObjetos.close();
		} catch (FileNotFoundException e) {
			//System.out.println("Todavía no hay ningún usuario");
		} catch (EOFException e) {
			try {
				lectorDeObjetos.close();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean ingresarDinero(String cuenta,float cantidad) {
		
		CuentaAhorro c1=null;
		CuentaCorrienteEmpresa c2=null;
		CuentaCorrientePersonal c3 =null;
		c1=TratamientoFicheros.buscarCuentaAhorro(cuenta);
		c2=TratamientoFicheros.buscarCuentaCorrienteEmpresa(cuenta);
		c3=TratamientoFicheros.buscarCuentaCorrientePersonal(cuenta);
		ObjectOutputStream escritorObjetos=null;
		if (c1!=null) {
			File f = new File("CuentasAhorro.dat");
			Iterator<CuentaAhorro>i=this.cuentasAhorro.iterator();
			try {
				if(f.delete()) {
					while(i.hasNext()) {
						if(this.tieneRegistros("CuentasAhorro.dat")) {
							escritorObjetos = new MiObjectOutPutStream(new FileOutputStream(f,true));
						}else {
							escritorObjetos = new ObjectOutputStream(new FileOutputStream(f));
						}	
						c1=i.next();
						if(c1!=null) {
							if(c1.getNumeroCuenta().equalsIgnoreCase(cuenta)) {
								c1.ingresar(cantidad);
								escritorObjetos.writeObject(c1);
							}else {
								escritorObjetos.writeObject(c1);
							}
							escritorObjetos.close();
						}
						}
				}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return true;
		}else {
			if(c2!=null) {
				File f = new File("CuentasCorrienteEmpresa.dat");
				Iterator<CuentaCorrienteEmpresa>i=this.cuentasCorrientesEmp.iterator();
				try {
					if(f.delete()) {
						while(i.hasNext()) {
							if(this.tieneRegistros("CuentasCorrienteEmpresa.dat")) {
								escritorObjetos = new MiObjectOutPutStream(new FileOutputStream(f,true));
							}else {
								escritorObjetos = new ObjectOutputStream(new FileOutputStream(f));
							}	
							c2=i.next();
							if(c2!=null) {
								if(c2.getNumeroCuenta().equalsIgnoreCase(cuenta)) {
									c2.ingresar(cantidad);
									escritorObjetos.writeObject(c2);
								}else {
									escritorObjetos.writeObject(c2);
								}	
							}
							escritorObjetos.close();
						}
					}
						
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}else {
				if(c3!=null) {
					File f = new File("CuentasCorrientePersonal.dat");
					Iterator<CuentaCorrientePersonal>i=this.cuentasCorrientesPer.iterator();
					try {
						if(f.delete()) {
							while(i.hasNext()) {
								if(this.tieneRegistros("CuentasCorrientePersonal.dat")) {
									escritorObjetos = new MiObjectOutPutStream(new FileOutputStream(f,true));
								}else {
									escritorObjetos = new ObjectOutputStream(new FileOutputStream(f));
								}	
								c3=i.next();
								if(c3!=null) {
									if(c3.getNumeroCuenta().equalsIgnoreCase(cuenta)) {
										c3.ingresar(cantidad);
										escritorObjetos.writeObject(c3);
									}else {
										escritorObjetos.writeObject(c3);
									}	
								}
								escritorObjetos.close();
							}
						}	
					} catch (IOException e) {
						e.printStackTrace();
					}
					return true;
				}
			}
		}
		return false;
	}
	
public boolean retirarDinero(String cuenta,float cantidad) {
		
		CuentaAhorro c1=null;
		CuentaCorrienteEmpresa c2=null;
		CuentaCorrientePersonal c3 =null;
		c1=TratamientoFicheros.buscarCuentaAhorro(cuenta);
		c2=TratamientoFicheros.buscarCuentaCorrienteEmpresa(cuenta);
		c3=TratamientoFicheros.buscarCuentaCorrientePersonal(cuenta);
		ObjectOutputStream escritorObjetos =null;
		
		if (c1!=null) {
			File f = new File("CuentasAhorro.dat");
			Iterator<CuentaAhorro>i=this.cuentasAhorro.iterator();
			try {
				if(f.delete()) {
					while(i.hasNext()) {
						if(this.tieneRegistros("CuentasAhorro.dat")) {
							escritorObjetos = new MiObjectOutPutStream(new FileOutputStream(f,true));
						}else {
							escritorObjetos = new ObjectOutputStream(new FileOutputStream(f));
						}	
						c1=i.next();
						System.out.println(c1.getNumeroCuenta()+"    "+c1.getNombreTitular());
						if(c1!=null) {
							if(c1.getNumeroCuenta().equalsIgnoreCase(cuenta)) {
								System.out.println("LLega al if");
								c1.retirar(cantidad);
								escritorObjetos.writeObject(c1);
							}else {
								System.out.println("LLega al else");
								escritorObjetos.writeObject(c1);
							}
						}
						escritorObjetos.close();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			if(c2!=null) {
				File f = new File("CuentasCorrienteEmpresa.dat");
				Iterator<CuentaCorrienteEmpresa>i=this.cuentasCorrientesEmp.iterator();
				try {
					if(f.delete()) {
						while(i.hasNext()) {
							if(this.tieneRegistros("CuentasCorrienteEmpresa.dat")) {
								escritorObjetos = new MiObjectOutPutStream(new FileOutputStream(f,true));
							}else {
								escritorObjetos = new ObjectOutputStream(new FileOutputStream(f));
							}	
							c2=i.next();
							if(c2!=null) {
								if(c2.getNumeroCuenta().equalsIgnoreCase(cuenta)) {
									c2.retirar(cantidad);
									escritorObjetos.writeObject(c2);
								}else {
									escritorObjetos.writeObject(c2);
								}	
							}
							escritorObjetos.close();
						}
					}
						
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}else {
				if(c3!=null) {
					File f = new File("CuentasCorrientePersonal.dat");
					Iterator<CuentaCorrientePersonal>i=this.cuentasCorrientesPer.iterator();
					try {
						if(f.delete()) {
							while(i.hasNext()) {
								if(this.tieneRegistros("CuentasCorrientePersonal.dat")) {
									escritorObjetos = new MiObjectOutPutStream(new FileOutputStream(f,true));
								}else {
									escritorObjetos = new ObjectOutputStream(new FileOutputStream(f));
								}	
								c3=i.next();
								if(c3!=null) {
									if(c3.getNumeroCuenta().equalsIgnoreCase(cuenta)) {
										c3.retirar(cantidad);
										escritorObjetos.writeObject(c3);
									}else {
										escritorObjetos.writeObject(c3);
									}	
								}
								escritorObjetos.close();
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return true;
				}
			}
		}
		return false;
	}
}
