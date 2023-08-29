package backing;

import javax.enterprise.context.RequestScoped;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Autor;
import excepciones.TresEquisNombreException;
import servicios.ServicioAutor;


@Named
//@RequestScoped
@ViewScoped
public class BackingAltaAutor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioAutor servicioAutor;
	private Autor autor=new Autor();

	public BackingAltaAutor() {
	}
		
	public void nuevoAutor() {		
		try{
			this.servicioAutor.crearAutor(this.autor);
			
			FacesContext context=FacesContext.getCurrentInstance();		
			ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("generico.registroCreadoConExito"),archivomensajes.getString("generico.registroCreadoConExito")));		
			System.out.println("this.servicioAutor.crearAutor(this.autor) realizado");
		}catch(TresEquisNombreException tresex){
			FacesContext context=FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,tresex.getMessage(),tresex.getMessage()));	
			System.out.println(context);
		}catch(Exception x){
			System.out.println(x);
		}
		this.autor=new Autor(); // reiniciar el contenedor del nuevo autor si trabajo con SessionScoped o bien para eliminar datos del registro recien creado.
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}