package Articulo;

import java.io.Serializable;

public class Articulo implements Serializable,Comparable<Articulo>{
	
	private String codArticulo;
	private String descripcion;
	private int cantidad;
	
	public Articulo (String codArticulo,String descripcion,int cantidad) {
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

	public int compareTo(Articulo a) {
		int n = 0;
		if(cantidad==a.getCantidad()) {
			return 0;
		}else {
			if(cantidad>a.cantidad) {
				return -1;
			}else {
				return 1;
			}
		}
	}
	
}
