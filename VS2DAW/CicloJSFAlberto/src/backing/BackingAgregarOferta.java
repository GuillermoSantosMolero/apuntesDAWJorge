package backing;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entidades.Ciclo;
import entidades.Ofertaeducativa;
import entidades.Turno;
import entidades.Ies;
import servicios.ServicioAgregarOferta;

@Named
@SessionScoped
public class BackingAgregarOferta implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioAgregarOferta servicioAgregarOferta;
	private long idies;
	private String url;
	private List<Ciclo> listaCiclos;
	private Ies ies=new Ies();
	private Ciclo cicloseleccionado=new Ciclo();
	private List<Turno> listaTurnos;//=new ArrayList<Turno>();
	private Turno turnoseleccionado=new Turno();
	private long plazas=0;
	private long idcicloseleccionado,idturnoseleccionado;
	private Ofertaeducativa ofertanueva=new Ofertaeducativa();

	public BackingAgregarOferta() {
		
	}

	public void init() {	
		this.ies=this.servicioAgregarOferta.buscaries(this.idies);
		this.listaCiclos=this.servicioAgregarOferta.buscarciclos(this.ies);	
//		this.ofertanueva=new Ofertaeducativa();
//		this.plazas=0;
	}
	
	public void buscarturnos() {		
		this.cicloseleccionado=this.servicioAgregarOferta.buscarciclo(this.idcicloseleccionado);
		this.listaTurnos=this.servicioAgregarOferta.buscarturnos(this.ies, this.cicloseleccionado);
		System.out.println("******************\nbuscar turnos done\n**************\n"+this.listaTurnos+"\n**************");
	}
	
	public String agregaroferta() {
		this.turnoseleccionado=this.servicioAgregarOferta.buscarturno(this.idturnoseleccionado);
		System.out.println("******************\n"+this.ies+"\n**************\n"+this.cicloseleccionado+"\n**************\n"+this.turnoseleccionado+"\n**************\n"+this.plazas+"\n**************");
		this.ofertanueva.setIes(this.ies);		
		this.ofertanueva.setCiclo(this.cicloseleccionado);
		this.ofertanueva.setTurno(this.turnoseleccionado);
		this.ofertanueva.setPlazas(this.plazas);	
		System.out.println("******************\n"+this.ofertanueva+"\n******************");
		this.servicioAgregarOferta.agregaroferta(this.ofertanueva);
		System.out.println("******************\n"+"oferta agregada!"+"\n******************");
		this.ofertanueva=new Ofertaeducativa();
		this.ies=new Ies();
		this.cicloseleccionado=new Ciclo();
		this.turnoseleccionado=new Turno();
		FacesContext context=FacesContext.getCurrentInstance();					
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"oferta agregada!","oferta agregada!"));		
		String urldestino=this.url+"?faces-redirect=true";
		return urldestino;
	}
	
	public String cancelar() {
		String urldestino=this.url+"?faces-redirect=true";
		return urldestino;
	}
	
	
	/******************************************************************************************************************************/
	/***************************************************GETTERS Y SETTERS**********************************************************/
	/******************************************************************************************************************************/
	
	public long getIdies() {
		return idies;
	}

	public void setIdies(long idies) {
		this.idies = idies;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Ciclo> getListaCiclos() {
		return listaCiclos;
	}

	public void setListaCiclos(List<Ciclo> listaCiclos) {
		this.listaCiclos = listaCiclos;
	}

	public Ies getIes() {
		return ies;
	}

	public void setIes(Ies ies) {
		this.ies = ies;
	}

	public Ciclo getCicloseleccionado() {
		return cicloseleccionado;
	}

	public void setCicloseleccionado(Ciclo cicloseleccionado) {		
		this.cicloseleccionado = cicloseleccionado;
	}

	public List<Turno> getListaTurnos() {
		return listaTurnos;
	}

	public void setListaTurnos(List<Turno> listaTurnos) {
		this.listaTurnos = listaTurnos;
	}

	public Turno getTurnoseleccionado() {
		return turnoseleccionado;
	}

	public void setTurnoseleccionado(Turno turnoseleccionado) {
		this.turnoseleccionado = turnoseleccionado;
	}

	public long getPlazas() {
		return plazas;
	}

	public void setPlazas(long plazas) {
		this.plazas = plazas;
	}

	public long getIdcicloseleccionado() {
		return idcicloseleccionado;
	}

	public void setIdcicloseleccionado(long idcicloseleccionado) {
		this.idcicloseleccionado = idcicloseleccionado;
		System.out.println("******************\nsetIdcicloseleccionado\n**************\n"+this.idcicloseleccionado+"\n**************");
	}

	public long getIdturnoseleccionado() {
		return idturnoseleccionado;
	}

	public void setIdturnoseleccionado(long idturnoseleccionado) {
		this.idturnoseleccionado = idturnoseleccionado;
		System.out.println("******************\nsetidturnoseleccionado\n**************\n"+this.idturnoseleccionado+"\n**************");
	}

	public Ofertaeducativa getOfertanueva() {
		return ofertanueva;
	}

	public void setOfertanueva(Ofertaeducativa ofertanueva) {
		this.ofertanueva = ofertanueva;
	}
}