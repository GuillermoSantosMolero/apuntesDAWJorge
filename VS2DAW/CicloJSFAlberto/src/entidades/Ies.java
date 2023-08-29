package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the IES database table.
 * 
 */
@Cacheable(false)
@Entity
@NamedQuery(name="Ies.findAll", query="SELECT i FROM Ies i")
public class Ies implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idies;

	private String nombre;

	public Ies() {
	}

	public long getIdies() {
		return this.idies;
	}

	public void setIdies(long idies) {
		this.idies = idies;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}