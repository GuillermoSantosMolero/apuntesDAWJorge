package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the OFERTAEDUCATIVA database table.
 * 
 */
@Entity
@NamedQuery(name="Ofertaeducativa.findAll", query="SELECT o FROM Ofertaeducativa o")
public class Ofertaeducativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OfertaeducativaPK id;

	private long plazas;

	//uni-directional many-to-one association to Ies
//	@ManyToOne(cascade={CascadeType.ALL})
	@ManyToOne
	@JoinColumn(name="IDIES")
	private Ies ies;
	
	//uni-directional many-to-one association to Ciclo
	@ManyToOne
	@JoinColumn(name="IDCICLO")
	private Ciclo ciclo;
	
	//uni-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="TURNO")
	private Turno turno;

	public Ofertaeducativa() {
	}

	public OfertaeducativaPK getId() {
		return this.id;
	}

	public void setId(OfertaeducativaPK id) {
		this.id = id;
	}

	public long getPlazas() {
		return plazas;
	}

	public void setPlazas(long plazas) {
		this.plazas = plazas;
	}

	public Ies getIes() {
		return ies;
	}

	public void setIes(Ies ies) {
		this.ies = ies;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
}