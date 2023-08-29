package backing;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import entidades.Ejemplar;
import servicios.ServicioConsultaEliminarEjemplares;
import javax.faces.event.AjaxBehaviorEvent;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class BackingConsultaEliminarEjemplares implements Serializable {
	
	@EJB
	private ServicioConsultaEliminarEjemplares servicioEjemplar;
	private String cadenaconsulta;
	private String eleccion;
	private List<Object[]> listaConsultarLibros;
	private List<Ejemplar> listaEjemplares;
	private  long[] ejemplaresAborrar;
	private String isbn;

	public BackingConsultaEliminarEjemplares() {
	}
	
	@PostConstruct
	public void ini() throws EJBException {
		if(eleccion== null)
			eleccion="autor";
		System.out.println(eleccion);
//		if(cadenaconsulta== null)
//			cadenaconsulta="";			
	}
	
	public void consultarlibrosporcadena() {
		try{
//			System.out.println(this.eleccion);
			this.listaConsultarLibros=this.servicioEjemplar.consultarLibrosPorCadena(cadenaconsulta, eleccion);
//			FacesContext context=FacesContext.getCurrentInstance();			
//			ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
//			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("pagina.listasocios.recogida"),archivomensajes.getString("pagina.listasocios.recogida")));		
			System.out.println("consultar libros realizado");
		}catch(Exception x){
			System.out.println(x);
		}
	}
	
	public void buscarEjemplares(String isbn) throws Exception{	
		System.out.println(isbn);
		this.isbn=isbn;
		try {
			this.listaEjemplares=(List<Ejemplar>)this.servicioEjemplar.buscarEjemplares(isbn);
			System.out.println(listaEjemplares);
		}catch(Exception x){
			System.out.println(x);
		}			
	}
	
	public void eliminarrejemplares() {
		try {
			this.servicioEjemplar.eliminarejemplares(this.ejemplaresAborrar);
			FacesContext context=FacesContext.getCurrentInstance();			
			ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("generico.registroEliminado"),archivomensajes.getString("generico.registroEliminado")));
			this.consultarlibrosporcadena();
			this.buscarEjemplares(isbn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void subjectSelectionChanged(final AjaxBehaviorEvent event)  {
		System.out.println(event.toString());
		System.out.println(eleccion);
	}
/*	
	public void onItemSelectedListener(SelectEvent event){
	    MyItem selectedItem = (MyItem) event.getObject();
	    //do something with selected value
	}
*/	
	public void prepararEleccion(String eleccion) {
		this.eleccion = eleccion;
		System.out.println(this.eleccion);		
	}
	
	public int getTotalLibrosEncontrados() {
		return(this.listaConsultarLibros!= null)?this.listaConsultarLibros.size():0;
	}
	
	public String getCadenaconsulta() {
		return cadenaconsulta;
	}

	public void setCadenaconsulta(String cadenaconsulta) {
		this.cadenaconsulta = cadenaconsulta;
	}

	public List<Object[]> getListaConsultarLibros() {
		return listaConsultarLibros;
	}

	public void setListaConsultarLibros(List<Object[]> listaConsultarLibros) {
		this.listaConsultarLibros = listaConsultarLibros;
	}

	public String getEleccion() {
		return eleccion;
	}

	public void setEleccion(String eleccion) {
		this.eleccion = eleccion;
	}
	public List<Ejemplar> getListaEjemplares() {
		return listaEjemplares;
	}
	public void setListaEjemplares(List<Ejemplar> listaEjemplares) {
		this.listaEjemplares = listaEjemplares;
	}
	public long[] getEjemplaresAborrar() {
		return ejemplaresAborrar;
	}
	public void setEjemplaresAborrar(long[] ejemplaresAborrar) {
		this.ejemplaresAborrar = ejemplaresAborrar;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}