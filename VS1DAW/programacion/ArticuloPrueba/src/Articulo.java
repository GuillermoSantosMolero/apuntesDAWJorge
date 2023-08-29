
public class Articulo {
	String nombre,descripcion;
	float precio;
	int descuento;
	public Articulo (String nombre,String descripcion,float precio) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.precio=precio;
	}
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
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public float precioConDescuento (int descuento) {
		float preciocondescuento=(precio*(100-this.descuento))/100;
		return preciocondescuento;
	}
}
