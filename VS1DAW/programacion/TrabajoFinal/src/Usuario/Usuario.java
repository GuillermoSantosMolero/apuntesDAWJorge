/**
 * 
 */
package Usuario;
//Guillermo Santos Molero
public class Usuario {  //Inicio clase usuario
	//Atributos de la clase:
	private boolean error;
	private String nombre;
	private String contrase�a;
	//M�todo constructor
	public Usuario (String nombre,String contrase�a) {
		this.nombre=nombre;
		this.contrase�a=contrase�a;
		comprobarUsuario();
	}
	//M�todo que verifica el nombre y la contrase�a
	private void comprobarUsuario() {
		if (this.nombre.equals("Admin")) {
			if(this.contrase�a.equals("1234")) {
				this.error=true;
			}else {
				this.error=false;
			}
		}else {
			this.error=false;
		}
	}
	//M�todo que devuelve el valor de error
	public boolean isError() {
		return this.error;
	}
	//M�todo que devuelve el error correspondiente
	public String getError() {
		if (this.error=false) {
			return ("El usuario o contrase�a son incorrectos.");
		}else
			return ("Todo ha funcionado correctamente");
	}
}
