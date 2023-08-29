package backing;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Socio;
import servicios.ServicioSocio;

@Named
@ViewScoped
public class BackingEditarSocio2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioSocio servicioSocio;
	private Socio socioseleccionado;
	private String url;
	private long idsocio;
	
	public BackingEditarSocio2() {
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
	
	public void init() {		
		this.socioseleccionado=this.servicioSocio.buscarSocioPorID(idsocio);
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

	public long getIdsocio() {
		return idsocio;
	}

	public void setIdsocio(long idsocio) {
		this.idsocio = idsocio;
	}
}