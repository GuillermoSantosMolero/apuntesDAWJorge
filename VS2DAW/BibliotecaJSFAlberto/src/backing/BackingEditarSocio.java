package backing;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entidades.Socio;
import servicios.ServicioSocio;

@Named
@SessionScoped
public class BackingEditarSocio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioSocio servicioSocio;
	private Socio socioseleccionado;
	private String url;
	
	public BackingEditarSocio() {
	}
	
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
	
	public String cancelar() {
		return this.url;
	}

	public Socio getSocioseleccionado() {
		return socioseleccionado;
	}

	public void setSocioseleccionado(Socio socioseleccionado) {
		this.socioseleccionado = socioseleccionado;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}