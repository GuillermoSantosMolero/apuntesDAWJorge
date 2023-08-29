package excepciones;

import javax.ejb.ApplicationException;

@SuppressWarnings("serial")
@ApplicationException(rollback=true)
public class TresEquisNombreException extends Exception{	

	public TresEquisNombreException() {
		
	}
	public TresEquisNombreException(String mensaje) {
		super(mensaje);
	}
}