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

import entidades.Prestamo;
import entidades.Socio;
import servicios.ServicioSocio;
import util.PaginacionHelper;

@SuppressWarnings("unused")
@Named
@ViewScoped
public class BackingSociosMorosos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioSocio servicioSocio;
	private List<Prestamo> listSociosMorosos;
	private List<Prestamo> listLibrosdelMoroso;
	private long idsocio;
	private PaginacionHelper paginacion;
	private int slctnrpag= 1;
	private String socioseleccionado;
	
	public BackingSociosMorosos() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void ini() {
		if(this.paginacion== null) {
			try {
				this.paginacion= new PaginacionHelper(1, 0) {
					// sobreescritura del metodo abstracto getItemsCount
					// para poder utilizarlo desde distintos servicios
					@Override
					public long getItemsCount() {
						return servicioSocio.getTotalMorosos();
					}
				};
			}catch(EJBException e) {
				System.out.println(e);
			}		
		}
		try{
			int primerResultado=this.paginacion.getPagina() * this.paginacion.getNrpag();
			int maxResultados=this.paginacion.getNrpag();
			this.listSociosMorosos=this.servicioSocio.buscarSociosMorosos(primerResultado,maxResultados);
//			FacesContext context=FacesContext.getCurrentInstance();			
//			ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
//			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("pagina.listamorosos.recogida"),archivomensajes.getString("pagina.listamorosos.recogida")));		
			System.out.println("this.servicioSocio.buscarSociosMorosos() realizado");
		}catch(Exception x){
			System.out.println(x);
		}
	}
	
	public void librosdelmoroso(Prestamo prestamo) {
		try{		
			this.socioseleccionado=prestamo.getSocio().getNombre();
			this.listLibrosdelMoroso=this.servicioSocio.buscarLibrosdelMoroso(prestamo.getSocio().getIdsocio());
//			FacesContext context=FacesContext.getCurrentInstance();			
//			ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());		
//			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,archivomensajes.getString("pagina.listalibrosdelmoroso.recogida"),archivomensajes.getString("pagina.listalibrosdelmoroso.recogida")));		
			System.out.println("this.servicioSocio.librosdelmoroso(long idsocio) realizado"+listLibrosdelMoroso);
		}catch(Exception x){
			System.out.println(x);
		}
	}
	
	public void resetPaginacion() {
		/*
		 * Procedimiento que recalcula el número de página en función de como se
		 * sube y baja el numero de registros por página. A este procedimiento
		 * se le llama mediante peticion ajax asociada al cuadro combinado que
		 * permite seleccionar los registros por pagina. EL valor seleccionado
		 * esta asociado a la propiedad slctnrpag de nuestro backing bean.
		 */
		int nuevapagina= (this.paginacion.getPrimerElementoPagina() / this.slctnrpag);
		this.paginacion.setNrpag(this.slctnrpag);
		this.paginacion.setPagina(nuevapagina);
		int primerResultado=this.paginacion.getPagina() * this.paginacion.getNrpag();
		int maxResultados=this.paginacion.getNrpag();
		this.listSociosMorosos= this.servicioSocio.buscarSociosMorosos(primerResultado,maxResultados);
	}
	
	public void paginaAnterior() {
		this.paginacion.getPaginaAnterior();
		int primerResultado=this.paginacion.getPagina() * this.paginacion.getNrpag();
		int maxResultados=this.paginacion.getNrpag();
		this.listSociosMorosos= this.servicioSocio.buscarSociosMorosos(primerResultado,maxResultados);
	}
	
	public void paginaSiguiente() {
		this.paginacion.getPaginaSiguiente();
		int primerResultado=this.paginacion.getPagina() * this.paginacion.getNrpag();
		int maxResultados=this.paginacion.getNrpag();
		this.listSociosMorosos= this.servicioSocio.buscarSociosMorosos(primerResultado,maxResultados);
	}
	
	/********************GETTERS Y SETTERS NORMALES*********************************/

	public List<Prestamo> getListSociosMorosos() {
		return listSociosMorosos;
	}

	public void setListSociosMorosos(List<Prestamo> listSociosMorosos) {
		this.listSociosMorosos = listSociosMorosos;
	}

	public List<Prestamo> getListLibrosdelMoroso() {
		return listLibrosdelMoroso;
	}

	public void setListLibrosdelMoroso(List<Prestamo> listLibrosdelMoroso) {
		this.listLibrosdelMoroso = listLibrosdelMoroso;
	}

	public long getIdsocio() {
		return idsocio;
	}

	public void setIdsocio(long idsocio) {
		this.idsocio = idsocio;
	}

	public PaginacionHelper getPaginacion() {
		return paginacion;
	}

	public void setPaginacion(PaginacionHelper paginacion) {
		this.paginacion = paginacion;
	}

	public int getSlctnrpag() {
		return slctnrpag;
	}

	public void setSlctnrpag(int slctnrpag) {
		this.slctnrpag = slctnrpag;
	}

	public String getSocioseleccionado() {
		return socioseleccionado;
	}

	public void setSocioseleccionado(String socioseleccionado) {
		this.socioseleccionado = socioseleccionado;
	}	
}