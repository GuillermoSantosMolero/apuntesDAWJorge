
public class Articulo {
	String nombre,descripcion;
	float precio,descuento;
	//Definimos constructores
	public Articulo(String nombre) {
		this.nombre=nombre;
	}
	public Articulo (String nombre,String descripcion) {
		this.nombre=nombre;
		this.descripcion=descripcion;
	}
	public Articulo(String nombre,String descripcion,float precio) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.precio=precio;
	}
	public Articulo() {
		
	}
	//Fin de constructores
	//Inicio de metodos get y set
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	//Fin de metodos get y set
	//Método para aplicar el descuento
	public float getPrecioConDescuento() {
		float precioFinal = (precio*(100-descuento))/100;
		return precioFinal;
	}
	
}
