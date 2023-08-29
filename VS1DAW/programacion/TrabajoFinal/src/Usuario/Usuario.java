/**
 * 
 */
package Usuario;
//Guillermo Santos Molero
public class Usuario {  //Inicio clase usuario
	//Atributos de la clase:
	private boolean error;
	private String nombre;
	private String contraseña;
	//Método constructor
	public Usuario (String nombre,String contraseña) {
		this.nombre=nombre;
		this.contraseña=contraseña;
		comprobarUsuario();
	}
	//Método que verifica el nombre y la contraseña
	private void comprobarUsuario() {
		if (this.nombre.equals("Admin")) {
			if(this.contraseña.equals("1234")) {
				this.error=true;
			}else {
				this.error=false;
			}
		}else {
			this.error=false;
		}
	}
	//Método que devuelve el valor de error
	public boolean isError() {
		return this.error;
	}
	//Método que devuelve el error correspondiente
	public String getError() {
		if (this.error=false) {
			return ("El usuario o contraseña son incorrectos.");
		}else
			return ("Todo ha funcionado correctamente");
	}
}
