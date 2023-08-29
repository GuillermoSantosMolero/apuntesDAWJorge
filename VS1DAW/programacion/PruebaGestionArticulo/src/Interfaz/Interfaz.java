package Interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Articulo.Articulo;

public class Interfaz implements FilenameFilter{
	private String ruta="C:\\Users\\Guillermo\\Desktop\\VS1DAW\\programacion\\GestionArticulo\\";
	private String extension=".txt";
	private String[] ficheros;
	private ArrayList<Articulo> arraylist= new ArrayList<Articulo>();
	
	public boolean accept(File dir, String nombre) {
		return nombre.endsWith(this.extension);
	}
	
	private int buscarEnArrayList(Articulo n) {
		Iterator<Articulo>i=this.arraylist.iterator();
		Articulo articulo = null;
		for (int j=0;j<this.arraylist.size();j++) {
			articulo=i.next();
			if(articulo.getCodArticulo().equalsIgnoreCase(n.getCodArticulo())){
				return j;
			}
		}
		return -1;
	}
	private void controlarArrayList(Articulo n) {
		int indice=this.buscarEnArrayList(n);
		Articulo a = null;
		if(indice!=-1) {
			a=this.arraylist.get(indice);
			a.setCantidad(a.getCantidad()+n.getCantidad());
			this.arraylist.remove(indice);
			this.arraylist.add(a);
		}else {
			this.arraylist.add(n);
		}
	}
	private void procesarLinea(String linea) {
		Pattern articulo = Pattern.compile ("^\\{(.*)\\|(.*)\\|[ ]*([0-9]*)[ ]*\\}$");
		Matcher detectaArticulo = articulo.matcher(linea);
		if(detectaArticulo.matches()) {
			Articulo n = new Articulo (detectaArticulo.group(1).trim(),detectaArticulo.group(2).trim(),Integer.parseInt(detectaArticulo.group(3).trim()));
			this.controlarArrayList(n);
		}
	}
	private void tratarFichero(String nombreFichero) {
		BufferedReader br = null;
		String linea;
		try {
			br = new BufferedReader(new FileReader(this.ruta+nombreFichero));
			linea= br.readLine();
			if(linea!=null) {
				while(linea!=null) {
					procesarLinea(linea);
					linea=br.readLine();
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void filtrarFichetos () {
		File f = new File(this.ruta);
		ficheros=f.list();
		ficheros=f.list((FilenameFilter) new Interfaz());
		int nFicheros = this.ficheros.length;
		if(nFicheros>1) {
			for(int i=0; i<this.ficheros.length;i++) {
				tratarFichero(this.ficheros[i]);
				//System.out.println(this.ficheros[i]);
			}
		}
		Collections.sort(this.arraylist);
		this.escribirEnDat();
	}
	
	private void escribirEnDat() {
		Iterator<Articulo>i = this.arraylist.iterator();
		Articulo n =null;
		ObjectOutputStream escritorObjetos = null;
		try {
			File file = new File ("Articulos.dat");
			file.delete();
			file.createNewFile();
			escritorObjetos = new ObjectOutputStream(new FileOutputStream(file));
			while(i.hasNext()) {
				//System.out.println("Llega a ecribirDat");
				n=i.next();
				escritorObjetos.writeObject(n);
			}
			escritorObjetos.close();
		} catch (FileNotFoundException e) {
			try {
				escritorObjetos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			try {
				escritorObjetos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void mostrarArticulos() {
		File file = new File ("Articulos.dat");
		ObjectInputStream lectorObjetos = null;
		Articulo art = null;
		try {
			lectorObjetos = new ObjectInputStream (new FileInputStream(file));
			art=(Articulo)lectorObjetos.readObject();
			while(art!=null) {
				System.out.println("cod: "+art.getCodArticulo()+" desc: "+art.getDescripcion()+" cantidad: "+art.getCantidad());
				art=(Articulo)lectorObjetos.readObject();
			}
			lectorObjetos.close();
		} catch (IOException e) {
			try {
				lectorObjetos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			try {
				lectorObjetos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}


}
