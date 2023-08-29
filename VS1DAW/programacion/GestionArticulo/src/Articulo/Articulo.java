
package Articulo;
import java.io.Serializable;
import java.lang.Comparable;
public class Articulo implements Serializable,Comparable<Articulo> {
	private String codArticulo, descripcion;
	private int cantidad;
	public Articulo(String codArticulo,String descripcion,int cantidad) {
		this.codArticulo=codArticulo;
		this.descripcion=descripcion;
		this.cantidad=cantidad;
	}
	public String getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(String codArticulo) {
		this.codArticulo = codArticulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int compareTo(Articulo o) {
		int comparacion=300;
		if(this.cantidad==o.cantidad) {
			comparacion=0;
		}else {
			comparacion=this.cantidad<o.cantidad?7:-7;
		}
		return comparacion;
	}
	
}