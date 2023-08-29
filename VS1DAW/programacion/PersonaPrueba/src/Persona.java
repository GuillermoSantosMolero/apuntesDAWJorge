/**
 * @author Guillermo Santos Molero 
 *
 */
public class Persona {
	String nombre;
	int edad;
	float altura;
	//Constructores
	public Persona () {
		nombre = "Luis Diaz";
		edad = 37;
		altura = 1.85f;
	}
	public Persona (String nombre,int edad,float altura) {
		this.nombre=nombre;
		this.edad=edad;
		this.altura=altura;
	}
	//métodos getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
}

