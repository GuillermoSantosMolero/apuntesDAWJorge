package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the TURNO database table.
 * 
 */
@Entity
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idturno;

	private String descripcion;
	

	public Turno() {
	}

	public long getIdturno() {
		return this.idturno;
	}

	public void setIdturno(long idturno) {
		this.idturno = idturno;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}