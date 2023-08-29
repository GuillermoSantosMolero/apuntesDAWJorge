package GestionArticulo;
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
import java.io.BufferedReader;
import java.io.EOFException;


public class GestionArticulo implements FilenameFilter {
		String extension;
		String ruta="C:\\Users\\Vespertino\\Desktop\\programaci�n\\GestionArticulo\\.";
		String[] listadeArchivos = null;
		ArrayList<Articulo> Articulos=new ArrayList<Articulo>();
	public GestionArticulo(String extension){
	       this.extension=extension;
	}
	
	//M�todo que filtra los archivos seg�n su ectensi�n para sacar solo los txt
	public boolean accept(File dir, String name){
	       return name.endsWith(extension);
	   }
	
	/*M�todo que devolver� -1 si el art�culo no est� a�n en el ArrayList, si no devuelve un -1 
	devuelve la posici�n que ocupa un �rticulo en el ArrayList*/
	public int buscarArticulo(Articulo entra) {
		//System.out.println("Llega a buscarArticulo");
		Iterator<Articulo>i=Articulos.iterator();
		Articulo compara=null;
		//System.out.println(this.Articulos.size());
		for (int j=0;j<this.Articulos.size();j++) {
			if(i.hasNext()) {
				//System.out.println("Entra al bucle de buscarArticulo");
				compara=i.next();
				if(compara.getCodArticulo().equals(entra.getCodArticulo())) {
					//System.out.println("encuentra el articulo en el indice "+j);
					return j;
				}
			}
		}
		return -1;
	}
	
	/*M�todo que a�ade el art�culo al ArrayList o modifica su cantidad si el �rticulo ya est� en el ArrayList*/
	public boolean controlarArticulos(Articulo n) {
		int indice=this.buscarArticulo(n);
		Articulo anterior=null;
		//System.out.println("Llega a controlarArticulos");
		if(indice!=-1) {
			//System.out.println(indice);
			anterior=this.Articulos.get(indice);
			n.setCantidad(n.getCantidad()+anterior.getCantidad());
			//System.out.println("antes de borrar articulo");
			this.Articulos.remove(indice);
			//System.out.println("borra articulo");
			this.Articulos.add(n);
			//System.out.println("modifica articulo");
		}else {
			this.Articulos.add(n);
			//System.out.println("A�ade articulo");
		}
		return false;
	}
	
	/*M�todo que procesa la l�nea para saber si una l�nea se trata de un art�culo u otra cosa*/
	public boolean procesarLinea(String linea){
		/* Definimos las expresiones regulares que usaremos una y otra vez para
	    cada l�nea del pedido. La expresi�nn regular "seccion" permite detectar
	    si hay un comienzo o fin de pedido, y la expresi�n articulo, permite detectar
	    si hay un articulo. */
		Pattern seccion = Pattern.compile("^##[ ]*(FIN)?[ ]*(PEDIDO|ARTICULOS)[ ]*##$");
		Pattern articulo = Pattern.compile ("^\\{(.*)\\|(.*)\\|[ ]*([0-9]*)[ ]*\\}$");
		Matcher deteccionSeccion = seccion.matcher(linea);
        Matcher deteccionArticulo= articulo.matcher(linea); 
        /* Si el patr�n coincide con el de un indicador de comienzo del pedido
         * o de la secci�n con el listado de art�culos, se ejecutar� este trozo
         * de c�digo, pues habr� encontrado el patr�n. No hace nada,
         * simplemente lo detecta para as� no informar de algo raro.
         */
        if (deteccionSeccion.matches()) {
            return true;
        }
        /* Si el patr�n coincide con el de un art�culo, entonces 
           guardar� los datos del pedido en una clase articulo y lo meter�
                 en la lista de art�culos.*/
        else if (deteccionArticulo.matches())
        {
            Articulo n=new Articulo(deteccionArticulo.group(1).trim(),deteccionArticulo.group(2).trim(),Integer.parseInt(deteccionArticulo.group(3)));
            controlarArticulos(n);
            return true;
        }
        //else { System.out.println("ATENCI�N: L�nea no procesable: "+linea); return false; }
        else { return false; }
    }
	
	/*M�todo que tratar� un documento en espec�fico*/
	public void tratarArray(String documento) {
		BufferedReader lector=null;
		try {
			 lector=new BufferedReader(new FileReader("C:\\Users\\Vespertino\\Desktop\\programaci�n\\GestionArticulo\\"+documento));
			// System.out.println("LLega a hacer buffer");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        if (lector == null) {
            /* Si no se ha podido cargar el archivo, no contin�a con el 
             * procesado, simplemente termina la ejecuci�n. */
            System.out.println("No se ha podido cargar el archivo.");
        } else {
            /* Si ha podido cargar el archivo, contin�a el procesado de l�nea a l�nea. */
            String linea;
            try {
            	linea=lector.readLine();
            	while (linea!=null) {
            		//System.out.println("lee l�nea");
            			procesarLinea(linea);
            		linea = lector.readLine();
            	}
            }catch (IOException ex) {
                System.out.println("Error de entrada y salida.");
            }
            
        }
    }
	
	//Este m�todo a�ade al array de listaDeArchivos los distintos documentos que existen.
	public void filtrarFicheros (){
		try {
            File fichero=new File(ruta);
            listadeArchivos = fichero.list();
            listadeArchivos = fichero.list(new GestionArticulo(this.extension));
            int numarchivos = listadeArchivos.length ;
            if (numarchivos < 1)
                System.out.println("No hay archivos que listar");
            else
            {
                for(int conta = 0; conta < listadeArchivos.length; conta++) {
                  	//System.out.println(listadeArchivos[conta]);
                	tratarArray(listadeArchivos[conta]);
                }
            }
            Collections.sort(Articulos);
            guardarObjetosEnFichero();
        }
        catch (Exception ex) {
            System.out.println("Error al buscar en la ruta indicada");
        }
    }
	
	//M�todo que guardar� todos los �rticulos con extensi�n .dat
	public void guardarObjetosEnFichero() throws IOException {
		Articulo art =null;
		File pedidos = new File ("Pedidos.dat");
		pedidos.delete();
		ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream(pedidos));	
		Iterator<Articulo>i=Articulos.iterator();
		while(i.hasNext()) {	
			art=i.next();
			escritorObjetos.writeObject(art);
		}
		escritorObjetos.close();
	}
	
	//M�todo que mostrar� los art�culos guardados en el .dat
	public void mostrarArticulos() {
		// Mostramos los datos de los articulos para ver si son correctos.
        ObjectInputStream lectorDeObjetos = null;
        File pedidos = new File ("Pedidos.dat");
		try {
			lectorDeObjetos = new ObjectInputStream(new FileInputStream(pedidos));
			Articulo retorno = null;
			do {
				retorno=(Articulo) lectorDeObjetos.readObject();
					 System.out.print("articulo codigo='"+retorno.getCodArticulo()+"' ");
			         System.out.print("descripcion='"+retorno.getDescripcion()+"' ");
			         System.out.println("cantidad='"+retorno.getCantidad()+"'");
			
			}while (retorno!=null);
			lectorDeObjetos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Todav�a no hay ning�n art�culo pedido");
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
	}
	


}
