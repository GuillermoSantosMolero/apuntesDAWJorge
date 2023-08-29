package backing;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Autor;
import servicios.ServicioAutor;

@Named
@ViewScoped
public class BackingAutor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioAutor servicioAutor;
	private List<Autor> listaAutores;
	private String cadenanombreautor;
	private long autoraborrar;
	UIOutput testBinding;
	
	public void buscarAutoresPorCadena() {
		try {
			this.listaAutores=this.servicioAutor.buscarAutoresPorCadena(this.cadenanombreautor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void borrarAutor() {
		this.servicioAutor.borrarAutor(autoraborrar);
		FacesContext context=FacesContext.getCurrentInstance();			
		ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("pagina.borrarautor.autoreliminado"),archivomensajes.getString("pagina.borrarautor.autoreliminado")));
		System.out.println("borar autor hecho");
		this.buscarAutoresPorCadena();
	}
	
	
	public void hideMessageBinding() {
		this.testBinding.setRendered(false);
	}
	
	public void showMessageBinding() {
		this.testBinding.setValue((String)"Hola Mundo");
		this.testBinding.setRendered(true);
	}
	
	public UIOutput getTestBinding() {
		return testBinding;
	}

	public void setTestBinding(UIOutput testBinding) {
		this.testBinding = testBinding;
	}

	public int getTotalAutoresEncontrados() {
		return(this.listaAutores!= null)?this.listaAutores.size():0;
	}
	
	public List<Autor> getListaAutores() {
		return listaAutores;
	}

	public void setListaAutores(List<Autor> listaAutores) {
		this.listaAutores = listaAutores;
	}

	public String getCadenanombreautor() {
		return cadenanombreautor;
	}

	public void setCadenanombreautor(String cadenanombreautor) {
		this.cadenanombreautor = cadenanombreautor;
	}

	public long getAutoraborrar() {
		return autoraborrar;
	}

	public void setAutoraborrar(long autoraborrar) {
		this.autoraborrar = autoraborrar;
	}


}