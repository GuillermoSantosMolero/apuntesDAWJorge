package backing;

import java.io.Serializable;
import java.util.List;
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
public class BackingSocios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioSocio servicioSocio;
	private String cadenanombresocio;
	private List<Socio> listSocios;

	public BackingSocios() {
	}
	
	public void sociosporcadena() {
		try{		
			this.listSocios=this.servicioSocio.buscarSociosPorCadena(this.cadenanombresocio);
			FacesContext context=FacesContext.getCurrentInstance();			
			ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("pagina.listasocios.recogida"),archivomensajes.getString("pagina.listasocios.recogida")));		
			System.out.println("this.servicioSocio.buscarSociosPorCadena(this.cadenanombresocio) realizado");
		}catch(Exception x){
			System.out.println(x);
		}
	}
	
	public String editarSocio(){
		return"/admin/editarsocio.xhtml?pagina=/admin/modificarsocio.xhtml&faces-redirect=true";
	}
	
	public int getTotalSociosCandidatos() {
		return(this.listSocios!= null) ? this.listSocios.size() : 0;
	}

	public String getCadenanombresocio() {
		return cadenanombresocio;
	}

	public void setCadenanombresocio(String cadenanombresocio) {
		this.cadenanombresocio = cadenanombresocio;
	}

	public List<Socio> getListSocios() {
		return listSocios;
	}

	public void setListSocios(List<Socio> listSocios) {
		this.listSocios = listSocios;
	}
}