package servicios;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import java.util.List;

import entidades.Prestamo;
import entidades.Socio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressWarnings("unused")
@Stateless
public class ServicioNuevoPrestamo {
	
	@PersistenceContext(unitName="BibliotecaJSF")
	private EntityManager em;
	
	private List<Socio> listSocios;

    public ServicioNuevoPrestamo() {
    }
    
    @SuppressWarnings("unchecked")
    public List<Socio> buscarSociosPorCadena(String cadenanombresocio)throws Exception{	
		String textoConsulta = "select s from Socio s where upper (s.nombre) like upper (:cadenanombresocio) order by s.idsocio";		
		Query consulta = this.em.createQuery(textoConsulta);
		consulta.setParameter("cadenanombresocio", "%"+cadenanombresocio+"%");
		this.listSocios= (List<Socio>) consulta.getResultList();
		for(Socio s:this.listSocios){
			em.refresh(s);
		}
		return this.listSocios;
	}
    
    @SuppressWarnings("unchecked")
    public List<Socio>sociosEnRango(int primerResultado,int maxResultados){
    	Query consulta=em.createQuery("select s from Socio s");
    	consulta.setFirstResult(primerResultado);
    	consulta.setMaxResults(maxResultados);
    	List<Socio>listaSocios= consulta.getResultList();
    	return listaSocios;
    }
    
    public long getTotal(){
    	Query consulta=em.createQuery("select count(s) from Socio s");
    	return(Long)consulta.getSingleResult();
    }
    
    public long getTotalMorosos(){
    	Query consulta=em.createQuery("select distinct count(p) from Prestamo p where p.fechalimitedevolucion < CURRENT_DATE");   	
//   	Query consulta=em.createQuery("select distinct count(p) from Prestamo p where p.fechalimitedevolucion <:hoy");
//    	Calendar fecha= new GregorianCalendar();
//		Date hoy = fecha.getTime();
//		fecha.setTime(hoy);
//		consulta.setParameter("hoy", hoy);
    	return(Long)consulta.getSingleResult();
    }
    
    public void actualizarSocio(Socio socio) throws RollbackException{
    	
    	try {
    		this.em.merge(socio);
    	}catch(EJBException e) {
    		throw e;
    	}
    }
    
    @SuppressWarnings("unchecked")
    public List<Prestamo> buscarSociosMorosos(int primerResultado,int maxResultados){	
    	Query consulta=em.createQuery("select p from Prestamo p where p.fechalimitedevolucion < CURRENT_DATE");  	
// 		Query consulta=em.createQuery("select p from Prestamo p where p.fechalimitedevolucion<:hoy");
//   	Calendar fecha= new GregorianCalendar();
//		Date hoy = fecha.getTime();
//		fecha.setTime(hoy);
//		consulta.setParameter("hoy", hoy);
    	consulta.setFirstResult(primerResultado);
    	consulta.setMaxResults(maxResultados);
		List<Prestamo>listaSocios= consulta.getResultList();
    	return listaSocios;
	}
    
    @SuppressWarnings("unchecked")
	public List<Prestamo> buscarLibrosdelMoroso(long idsocio) throws Exception{  	
		Query consulta = em.createQuery("select p from Prestamo p where p.socio.idsocio=:idsocio");
		consulta.setParameter("idsocio", idsocio);
		List<Prestamo>listaSocios= consulta.getResultList();
    	return listaSocios;
    }
    
    public Socio buscarSocioPorID(long idsocio) {
    	return this.em.find(Socio.class, idsocio);
    }
    
    public Socio crearSocio(Socio socio){
    	this.em.persist(socio);
    	return socio;
    }
    
	public List<Socio> getListSocios() {
		return listSocios;
	}

	public void setListSocios(List<Socio> listSocios) {
		this.listSocios = listSocios;
	} 
}