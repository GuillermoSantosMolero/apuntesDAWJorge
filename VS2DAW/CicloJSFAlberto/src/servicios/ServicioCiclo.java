package servicios;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import java.util.List;

import entidades.Ofertaeducativa;
import entidades.OfertaeducativaPK;
import entidades.Ies;

@Stateless
public class ServicioCiclo {
	
	@PersistenceContext(unitName="CicloJSF")
	private EntityManager em;
    	
	
    public ServicioCiclo() {
    
    }
    
    @SuppressWarnings("unchecked")
	public List<Ies> buscarIES(){		
		Query consulta = this.em.createQuery("select i from Ies i");
		List<Ies>listaIES= (List<Ies>) consulta.getResultList();
		return listaIES;  	
    }
	
	@SuppressWarnings("unchecked")
	public List<Ofertaeducativa> buscarofertaseducativas(long eleccionies)throws RollbackException{		
		Query consulta = this.em.createQuery("select o from Ofertaeducativa o where o.ies.idies=:eleccionies");
		consulta.setParameter("eleccionies", eleccionies);		
		List<Ofertaeducativa>listaofertaeducativa=consulta.getResultList();
		return listaofertaeducativa;  	
    }	
	public void modificaroferta(Ofertaeducativa ofertaeducativaAeditar) throws RollbackException{
		try {
			this.em.merge(ofertaeducativaAeditar);
    	}catch(EJBException e) {
    		throw e;
    	}
		
	/*	try {
			Ofertaeducativa oferta=this.em.find(Ofertaeducativa.class, ofertaeducativaAeditar.getId());
			oferta.setPlazas(plazasnuevas);
    	}catch(EJBException e) {
    		throw e;
    	}
    */
	}
	public void eliminaroferta(OfertaeducativaPK ofertapk) throws RollbackException{
/*		
		try {
			Query consulta = this.em.createQuery("delete from Ofertaeducativa o where "
					+ "o.y.idies=:idies "
					+ "and o.ciclo.idciclo=:idciclo "
					+ "and o.turno.idturno=:idturno "
					+ "and o.plazas=:plazas");
			consulta.setParameter("idies", oferta.getY().getIdies());
			consulta.setParameter("idciclo", oferta.getCiclo().getIdciclo());
			consulta.setParameter("idturno", oferta.getTurno().getIdturno());
			consulta.setParameter("plazas", oferta.getPlazas());
			consulta.executeUpdate();
    	}catch(EJBException e) {
    		throw e;
    	}
*/
		try {
			this.em.remove(this.em.find(Ofertaeducativa.class, ofertapk));
    	}catch(EJBException e) {
    		throw e;
    	}	
	}
}