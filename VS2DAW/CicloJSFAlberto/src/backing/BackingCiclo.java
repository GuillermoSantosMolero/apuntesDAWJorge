package backing;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entidades.Ciclo;
import entidades.Ofertaeducativa;
import entidades.OfertaeducativaPK;
import entidades.Turno;
import entidades.Ies;
import servicios.ServicioCiclo;

@Named
@SessionScoped
public class BackingCiclo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioCiclo servicioCiclo;
	private long eleccion;
	private List<Ies> listaIES;
	private List<Ofertaeducativa> listaOfertaEducativa;
	private Ofertaeducativa ofertaeducativaAeditar,ofertaeducativaAeditar2;
	private String url;
	private long idies,idciclo,idturno;
	private String ciclonombre,nombreies,grado;
	private String turnodescripcion;
	private long plazas;	

	public BackingCiclo() {
		
	}
	
	@PostConstruct
	public void ini() throws EJBException {	
		if(this.listaIES==null)	
			this.listaIES=this.servicioCiclo.buscarIES();
		if(this.ofertaeducativaAeditar==null)
			this.ofertaeducativaAeditar=new Ofertaeducativa();
	}
	
	public void buscarofertaseducativas() {	
		if(this.eleccion>0)
			this.listaOfertaEducativa=this.servicioCiclo.buscarofertaseducativas(eleccion);
		else{
			FacesContext context=FacesContext.getCurrentInstance();				
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Selecciona un IES por favor","Selecciona un IES por favor"));										
		}	
	}	
	
	public void eliminarOferta(OfertaeducativaPK ofertapk) {
		System.out.println("**************************");
		System.out.println("eliminarOferta de una oferta agregada");
		System.out.println(ofertapk.getIdciclo()+" "+ofertapk.getIdies()+" "+ofertapk.getTurno());
//		System.out.println(oferta.getIes().getIdies());
		System.out.println("**************************");
		this.servicioCiclo.eliminaroferta(ofertapk);
		this.buscarofertaseducativas();
		FacesContext context=FacesContext.getCurrentInstance();			
		ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("eliminarofertadone"),archivomensajes.getString("eliminarofertadone")));								
	}
	
	public String modificaroferta() {
		System.out.println(this.ofertaeducativaAeditar);
		this.servicioCiclo.modificaroferta(this.ofertaeducativaAeditar);
		this.buscarofertaseducativas();
		FacesContext context=FacesContext.getCurrentInstance();			
		ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("modificarofertadone"),archivomensajes.getString("modificarofertadone")));				
		String urldestino=this.url+"?faces-redirect=true";
		return urldestino;
	}
	
	public String volver() {
		String urldestino=this.url+"?faces-redirect=true";
		return urldestino;
	}
	public String cancelar() {
		String urldestino=this.url+"?faces-redirect=true";
		return urldestino;
	}
	
	public void init() {		
		Ies ies=new Ies();
		Ciclo ciclo=new Ciclo();
		Turno turno = new Turno();
		ies.setIdies(this.idies);
		ies.setNombre(this.nombreies);
		ciclo.setNombre(this.ciclonombre);
		ciclo.setIdciclo(this.idciclo);
		ciclo.setGrado(this.grado);
		turno.setDescripcion(this.turnodescripcion);
		turno.setIdturno(this.idturno);	
		this.ofertaeducativaAeditar.setIes(ies);
		this.ofertaeducativaAeditar.setCiclo(ciclo);
		this.ofertaeducativaAeditar.setTurno(turno);
		this.ofertaeducativaAeditar.setPlazas(this.plazas);			
	}
	
	public String editaroferta2(Ofertaeducativa oferta, String url) {
		this.ofertaeducativaAeditar=oferta;
		this.url=url;
		return "/editaroferta2.xhtml?pagina=/index.xhtml&faces-redirect=true";
	}
	
	/******************************************************************************************************************************/
	/***************************************************GETTERS Y SETTERS**********************************************************/
	/******************************************************************************************************************************/
	


	public ServicioCiclo getServicioIES() {
		return servicioCiclo;
	}

	public long getEleccion() {
		return eleccion;
	}

	public void setEleccion(long eleccion) {
		this.eleccion = eleccion;
	}

	public void setServicioIES(ServicioCiclo servicioIES) {
		this.servicioCiclo = servicioIES;
	}

	

	public List<Ies> getListaIES() {
		return listaIES;
	}

	public void setListaIES(List<Ies> listaIES) {
		this.listaIES = listaIES;
	}

	public List<Ofertaeducativa> getListaOfertaEducativa() {
		return listaOfertaEducativa;
	}

	public void setListaOfertaEducativa(List<Ofertaeducativa> listaOfertaEducativa) {
		this.listaOfertaEducativa = listaOfertaEducativa;
	}

	public Ofertaeducativa getOfertaeducativaAeditar() {
		return ofertaeducativaAeditar;
	}

	public void setOfertaeducativaAeditar(Ofertaeducativa ofertaeducativaAeditar) {
		this.ofertaeducativaAeditar = ofertaeducativaAeditar;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getIdies() {
		return idies;
	}

	public void setIdies(long idies) {
		this.idies = idies;
	}

	public String getCiclonombre() {
		return ciclonombre;
	}

	public void setCiclonombre(String ciclonombre) {
		this.ciclonombre = ciclonombre;
	}

	public String getTurnodescripcion() {
		return turnodescripcion;
	}

	public void setTurnodescripcion(String turnodescripcion) {
		this.turnodescripcion = turnodescripcion;
	}

	public long getPlazas() {
		return plazas;
	}

	public void setPlazas(long plazas) {
		this.plazas = plazas;
	}

	public long getIdciclo() {
		return idciclo;
	}

	public void setIdciclo(long idciclo) {
		this.idciclo = idciclo;
	}

	public long getIdturno() {
		return idturno;
	}

	public void setIdturno(long idturno) {
		this.idturno = idturno;
	}

	public String getNombreies() {
		return nombreies;
	}

	public void setNombreies(String nombreies) {
		this.nombreies = nombreies;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public Ofertaeducativa getOfertaeducativaAeditar2() {
		return ofertaeducativaAeditar2;
	}

	public void setOfertaeducativaAeditar2(Ofertaeducativa ofertaeducativaAeditar2) {
		this.ofertaeducativaAeditar2 = ofertaeducativaAeditar2;
	}	
}