package servicios;

import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Autor;
import excepciones.TresEquisNombreException;

@Stateless
public class ServicioAutor {
	
	private List<Autor> listaAutores;
	
	@PersistenceContext(unitName="BibliotecaJSF")
	private EntityManager em;

    public ServicioAutor() {
    }
    
    public Autor crearAutor(Autor a) throws TresEquisNombreException{	
    	this.em.persist(a);
    	if(a.getNombre().contains("XXX")) {
    		FacesContext context=FacesContext.getCurrentInstance();			
			ResourceBundle archivomensajes=ResourceBundle.getBundle("resources.application",context.getViewRoot().getLocale());
			String mensaje =archivomensajes.getString("excepciontresequis");
			TresEquisNombreException tresex=new TresEquisNombreException(mensaje);
			throw tresex;
    	}
    	return a;
    }
    
    @SuppressWarnings("unchecked")
    public List<Autor> buscarAutoresPorCadena(String cadenanombreautor)throws Exception{	
		String textoConsulta = "select a from Autor a where upper (a.nombre) like upper (:cadenanombreautor) order by a.idautor";		
		Query consulta = this.em.createQuery(textoConsulta);
		consulta.setParameter("cadenanombreautor", "%"+cadenanombreautor+"%");
		this.listaAutores= (List<Autor>) consulta.getResultList();
		for(Autor a:this.listaAutores){
			em.refresh(a);
		}
		return this.listaAutores;
	}
    
    public void borrarAutor(long autoraborrar) {
    	
    	em.remove(em.find(Autor.class, autoraborrar));
    }
}