package servicios;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import java.util.List;

import entidades.Ciclo;
import entidades.Ofertaeducativa;
import entidades.Turno;
import entidades.Ies;

@SuppressWarnings("unused")
@Stateless
public class ServicioAgregarOferta {
	
	@PersistenceContext(unitName="CicloJSF")
	private EntityManager em;
    	
	
    public ServicioAgregarOferta() {
    
    }
    
    public Ies buscaries(long idies) {   	
    	Ies ies=this.em.find(Ies.class, idies);  
    	if(ies!=null)
    		em.refresh(ies);
		return ies;  	
    }
    
   @SuppressWarnings("unchecked")
   public List<Ciclo> buscarciclos(Ies ies) {
	   Query consulta = this.em.createQuery(
			   "select c from Ciclo c "
			  +"where c.idciclo not in "
			  +"(select o.ciclo.idciclo from Ofertaeducativa o "
			  +"where o.id.idies=:idies "
			  +"group by o.ciclo.idciclo "
			  +"having count (o.ciclo.idciclo)>1)"); 
	   consulta.setParameter("idies", ies.getIdies());
	   return (List<Ciclo>)consulta.getResultList();   
   }
   
   @SuppressWarnings("unchecked")
   public List<Turno> buscarturnos(Ies ies, Ciclo ciclo) {
	   Query consulta = this.em.createQuery(
			   "select t from Turno t "
			  +"where t.idturno not in "
			  +"(select o.turno.idturno from Ofertaeducativa o "
			  +"where o.id.idies=:idies "
			  +"and o.id.idciclo=:idciclo)");
	   consulta.setParameter("idies", ies.getIdies());
	   consulta.setParameter("idciclo", ciclo.getIdciclo());
	   return (List<Turno>)consulta.getResultList();
   }
   
   public Ciclo buscarciclo(long idciclo) {
	   return em.find(Ciclo.class, idciclo);
   }
   
   public Turno buscarturno(long idturno) {
	   return em.find(Turno.class, idturno);
   }
   
   public void agregaroferta(Ofertaeducativa ofertanueva) {
//	   ofertanueva.setIes(em.find(Ies.class,));
	   this.em.persist(ofertanueva);
//	   this.em.merge(ofertanueva);
   }
}


/*

select c from Ciclo c
where c.idciclo not in
(select o.ciclo.idciclo from Ofertaeducativa o
where o.id.idies=1
group by o.ciclo.idciclo
having count (o.ciclo.idciclo)>1)

select t.descripcion from Turno t
where t.idturno not in
(select o.turno.idturno from Ofertaeducativa o
where o.id.idies=1
and o.id.idciclo=2)



*/
