package FuncionesInterfaz;

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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Usuario.Usuario;
public class FuncionesInterfaz {
	private String nombredat="usuarios.dat";
	private Scanner teclado = new Scanner(System.in);
	
	private static boolean tieneRegistros(String direccion) {
		boolean tiene = false;
		FileInputStream fiPassLec;
		ObjectInputStream flujoEntrada;
		Usuario u = null;
		
		try {
			fiPassLec = new FileInputStream(direccion);
			flujoEntrada = new ObjectInputStream(fiPassLec);
			
			//Leer el objeto del fichero
			u=(Usuario) flujoEntrada.readObject();
			if(u !=null) {
				tiene=true;
			}
			fiPassLec.close();
			flujoEntrada.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: "+e.getMessage());
		} catch (Exception ex) {
			System.out.println("Capturada excepción en tieneRegistros() ");
		}
		return (tiene);
	}
	public void crearUsuario() throws IOException {
		ObjectOutputStream escritorObjetos;
		String mail,contra;
		boolean seguir=false;
		do {
			System.out.println("Escribe el correo");
	                mail=teclado.nextLine();
	                Pattern p=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);
	                Matcher m=p.matcher(mail);
	                if(m.matches()) {
						if(this.tieneRegistros(nombredat)) {
							escritorObjetos = new MiObjectOutPutStream(new FileOutputStream(nombredat,true));
						}else {
							escritorObjetos = new ObjectOutputStream(new FileOutputStream(nombredat));
						}	
						if(this.comprobarMail(mail)){
							seguir=true;
							System.out.println("El mail introducido ya existe");
						}else {
							System.out.println("Introduzca la password: ");
							contra=teclado.nextLine();
							Usuario us1= new Usuario(mail,contra);																			
							escritorObjetos.writeObject(us1);
							escritorObjetos.close();
							seguir=false;
						}
	                }
		}while(seguir==true);
	}
	
	public void listarUsuarios() throws IOException {
		ObjectInputStream lectorDeObjetos = null;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream(this.nombredat));
			Usuario retorno = null;
			do {
				retorno=(Usuario) lectorDeObjetos.readObject();
				if(retorno.isActivo()==true) {
					System.out.println("El mail es: "+retorno.getMail());
					System.out.println("La contraseña es: "+retorno.getContra());
					System.out.println(retorno.isActivo());
				}
			}while (retorno!=null);
			lectorDeObjetos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Todavía no hay ningún usuario");
		} catch (EOFException e) {
			lectorDeObjetos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public boolean comprobarMail(String mail) throws IOException {
		boolean encontrado =false;
		ObjectInputStream lectorDeObjetos = null;
		Usuario retorno = null;
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream(nombredat));
			do {
				retorno=(Usuario) lectorDeObjetos.readObject();
				if(retorno.isActivo()==true && retorno.getMail().equals(mail)) {
					encontrado=true;
				}
			}while (retorno!=null);
			lectorDeObjetos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Todavía no hay ningún usuario");
		} catch (EOFException e) {
			lectorDeObjetos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encontrado;
	}
	public void borrarUsuario(String mail) throws  IOException {
		ObjectOutputStream escritorObjetos = null;
		ObjectInputStream lectorDeObjetos = null;
		ArrayList<Usuario>lista=new ArrayList<Usuario>();	
		Usuario retorno = null;	
		try {	
			lectorDeObjetos=new ObjectInputStream(new FileInputStream(nombredat));
			File f = new File(this.nombredat);
			//File aux = new File("auxiliar.dat");
			//File aux = File.createTempFile("auxiliar", ".dat");
			File aux = File.createTempFile("auxiliar", ".tmp");
			escritorObjetos = new ObjectOutputStream(new FileOutputStream(aux,true));
			//aux.createNewFile();
				if(comprobarMail(mail)) {
				/*	if(this.tieneRegistros("auxiliar.dat")) {
						escritorObjetos = new MiObjectOutPutStream(new FileOutputStream("auxiliar.dat",true));
					}else {
						escritorObjetos = new ObjectOutputStream(new FileOutputStream("auxiliar.dat",true));
					}*/
					try {
						do {
							retorno=(Usuario) lectorDeObjetos.readObject();
							//System.out.println(retorno.getMail()+"leido en "+ f.getName());
							if(retorno.isActivo()==true && retorno.getMail().equals(mail)) {
								retorno.setActivo(false);
								//System.out.println(retorno.getMail()+"borrado");
							}	
							lista.add(retorno);
						}while (retorno!=null);
					} catch (EOFException e) {
						Iterator<Usuario>i=lista.iterator();	
						//System.out.println("Fin de fichero");
						while(i.hasNext()) {
							//System.out.println("Hay más");
							retorno=i.next();
							if(retorno!=null) {
								escritorObjetos.writeObject(retorno);
						}
						}
						//System.out.println("No hay más");
						lectorDeObjetos.close();
						escritorObjetos.close();
						boolean borrar=f.delete();
						if(borrar) {
							//System.out.println("El fichero "+f.getName()+" esta borrado");
						aux.renameTo(f);
							//System.out.println("El fichero "+aux.getName()+" esta renombrado");	
						}else {
							System.out.println("No se ha podido borrar fichero" +borrar);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else {
					System.out.println("No existe el mail introducido");
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (lectorDeObjetos!=null) {
					lectorDeObjetos.close();
				}
				if (escritorObjetos!=null) {
					escritorObjetos.close();
				}
			}catch(IOException e) {
			}
		}
	}
	public void borrarFicheroEntero() {
		File f = new File(this.nombredat);
		if(f.delete()) {
			System.out.println("Fichero borrado correctamente. ");
		}else {
			System.out.println("Fichero no borrado. ");
		}
	}

}
