package backing;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entidades.Prestamo;
import entidades.Socio;
//import servicios.ServicioNuevoPrestamo;



@Named
@SessionScoped
public class BackingNuevoPrestamo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
//	private ServicioNuevoPrestamo servicioNuevoPrestamo;
	private Prestamo prestamo;
	private String url;
	
	public BackingNuevoPrestamo() {
	}
	
	@PostConstruct
	public void ini() throws EJBException {
		Socio socio=new Socio();
		this.prestamo.setSocio(socio);
	}
/*	
	public void actualizarSocioSeleccionado() {
		try{		
			this.servicioSocio.actualizarSocio(socioseleccionado);
			FacesContext context=FacesContext.getCurrentInstance();			
			ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("generico.registroActualizado"),archivomensajes.getString("generico.registroActualizado")));		
			System.out.println("this.servicioSocio.actualizarSocio(socioseleccionado) realizado");
		}catch(Exception x){
			System.out.println(x);
		}
	}
*/	
	
	public void nuevoPrestamo() {
		try{		
//			this.servicioSocio.actualizarSocio(socioseleccionado);
			FacesContext context=FacesContext.getCurrentInstance();			
			ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("pagina.nuevoprestamo.prestamorealizado"),archivomensajes.getString("pagina.nuevoprestamo.prestamorealizado")));		
			System.out.println("***************\nnuevoPrestamo realizado \n***************");
		}catch(Exception x){
			System.out.println(x);
		}
	}
	
	public String cancelar() {
		return this.url;
	}
	public Prestamo getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
}