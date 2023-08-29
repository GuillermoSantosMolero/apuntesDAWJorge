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

import entidades.Socio;
import servicios.ServicioSocio;
import util.PaginacionHelper;

@Named
@ViewScoped
public class BackingSocio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private ServicioSocio servicioSocio;
	private List<Socio> listSocios;
	private int slctnrpag= 5;
	private boolean edit;	
	private PaginacionHelper paginacion;
	
	@PostConstruct
	public void ini() throws EJBException {
		if(this.paginacion== null) {
			try {
				this.paginacion= new PaginacionHelper(5, 0) {
					// sobreescritura del metodo abastracto getItemsCount
					// para poder utilizarlo desde distintos ejb
					@Override
					public long getItemsCount() {
						return servicioSocio.getTotal();
					}
				};
			}catch(EJBException e) {
				System.out.println("***********************************************************\n"+e+"\n**************************************************");
			}		
		}
		int primerResultado=this.paginacion.getPagina() * this.paginacion.getNrpag();
		int maxResultados=this.paginacion.getNrpag();
		this.listSocios= this.servicioSocio.sociosEnRango(primerResultado,maxResultados);
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
		this.listSocios= this.servicioSocio.sociosEnRango(primerResultado,maxResultados);
	}
	
	/*************************************************************************/
	
	public int getTotalSociosCandidatos() {
		return(listSocios!= null) ? listSocios.size() : 0;
	}
	
	/***************************************************************************/
	
	public long getTotalSocios() {
		return servicioSocio.getTotal();
	}
	/********************************************************************/
	
	public void paginaAnterior() {
		paginacion.getPaginaAnterior();
		int primerResultado=this.paginacion.getPagina() * this.paginacion.getNrpag();
		int maxResultados=this.paginacion.getNrpag();
		this.listSocios= this.servicioSocio.sociosEnRango(primerResultado,maxResultados);
	}
	
	/*********************************************************************/
	
	public void paginaSiguiente() {
		paginacion.getPaginaSiguiente();
		int primerResultado=this.paginacion.getPagina() * this.paginacion.getNrpag();
		int maxResultados=this.paginacion.getNrpag();
		this.listSocios= this.servicioSocio.sociosEnRango(primerResultado,maxResultados);
	}

	public String editarSocio(){
		return"/admin/editarsocio.xhtml?pagina=/admin/modificarsocio.xhtml&faces-redirect=true";
	}


	public int getSlctnrpag() {
		return slctnrpag;
	}


	public void setSlctnrpag(int slctnrpag) {
		this.slctnrpag = slctnrpag;
	}


	public PaginacionHelper getPaginacion() {
		return paginacion;
	}


	public void setPaginacion(PaginacionHelper paginacion) {
		this.paginacion = paginacion;
	}


	public List<Socio> getListSocios() {
		return listSocios;
	}


	public void setListSocios(List<Socio> listSocios) {
		this.listSocios = listSocios;
	}	
	
	
}