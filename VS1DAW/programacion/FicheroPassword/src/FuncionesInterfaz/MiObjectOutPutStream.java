package FuncionesInterfaz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import Usuario.Usuario;

public class MiObjectOutPutStream extends ObjectOutputStream {

	//Constructor que recibe OutputStream
	public MiObjectOutPutStream(OutputStream out) throws IOException, SecurityException {
		super(out);
	}
	
	//Constructor sin par�metros
	protected MiObjectOutPutStream() throws IOException,SecurityException{
		super();
	}
	
	//Redefinici�n del m�todo de escribir la cabecera para que no haga nada
	protected void writeStreamHeader() throws IOException{
		
	}
}
