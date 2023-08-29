package servicios;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import java.util.List;

import entidades.Ejemplar;
import entidades.Prestamo;
import entidades.Socio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SuppressWarnings("unused")
@Stateless
public class ServicioConsultaEliminarEjemplares {
	
	@PersistenceContext(unitName="BibliotecaJSF")
	private EntityManager em;
	
	private String autor,libro,isbn;

    public ServicioConsultaEliminarEjemplares() {
    }
    
    @SuppressWarnings("unchecked")
	public List<Object[]> consultarLibrosPorCadena(String consultacadena, String eleccion) throws Exception{		
		this.prepararconsulta(consultacadena, eleccion);					
		Query consulta=em.createNativeQuery("SELECT T.ISBN,TITULO,AUTOR.NOMBRE AUTOR, EJEMPLARESTOTALES, EJEMPLARESENPRESTAMO,(EJEMPLARESTOTALES-EJEMPLARESENPRESTAMO)EJEMPLARESDISPONIBLES"+
                " FROM LIBRO T,AUTOR,"+
                "("+
                " SELECT A.ISBN,EJEMPLARES EJEMPLARESTOTALES,NVL(EJEMPLARESPRESTADOS,0)EJEMPLARESENPRESTAMO"+
                " FROM"+
                 "(SELECT L.ISBN,COUNT(*)EJEMPLARES"+
                 " FROM LIBRO L,EJEMPLAR E"+
                 " WHERE L.ISBN=E.ISBN AND E.BAJA='N'"+
                 " GROUP BY L.ISBN)A,"+
                 " (SELECT ISBN,COUNT(*) EJEMPLARESPRESTADOS"+
                 " FROM PRESTAMO P,EJEMPLAR E"+
                 " WHERE P.IDEJEMPLAR=E.IDEJEMPLAR"+
                 " GROUP BY ISBN)B"+
                 " WHERE A.ISBN=B.ISBN(+))A"+
                 " WHERE T.ISBN=A.ISBN"+
                 " AND T.IDAUTOR=AUTOR.IDAUTOR"+
                 " AND TRANSLATE(UPPER(AUTOR.NOMBRE),'Á,É,Í,Ó,Ú','A,E,I,O,U') LIKE TRANSLATE(UPPER(?),'Á,É,Í,Ó,Ú','A,E,I,O,U')"+
                 " AND TRANSLATE(UPPER(T.TITULO),'Á,É,Í,Ó,Ú','A,E,I,O,U') LIKE  TRANSLATE(UPPER(?),'Á,É,Í,Ó,Ú','A,E,I,O,U')"+
                 " AND T.ISBN LIKE ?"+
                 " ORDER BY ISBN,TITULO,AUTOR");
		consulta.setParameter(1, this.autor);
		consulta.setParameter(2, this.libro);
		consulta.setParameter(3, this.isbn);	
		return consulta.getResultList();
	}
	
	public void prepararconsulta(String consultacadena, String eleccion) {			
		switch(eleccion) {	
		case "autor":
			this.autor=("%"+consultacadena+"%");
			this.libro=("%");
			this.isbn=("%");		
		break;
		case "libro":
			this.autor=("%");
			this.libro=("%"+consultacadena+"%");
			this.isbn=("%");
		break;
		case "isbn":
			this.autor=("%");
			this.libro=("%");
			this.isbn=("%"+consultacadena+"%");
		break;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Ejemplar> buscarEjemplares(String isbn) throws Exception{
		Query consulta = em.createQuery("select e from Ejemplar e where e.libro.isbn=:isbn and e.baja='N' and e not in (select p.ejemplar from Prestamo p)");
		consulta.setParameter("isbn",isbn);
		return consulta.getResultList();		
	}
	
	public void eliminarejemplares( long[] ejemplaresAborrar) throws Exception {
		try {
			for(long idejemplar:ejemplaresAborrar ) {
				Ejemplar ejemplar=em.find(Ejemplar.class, idejemplar);
				ejemplar.setBaja("S");
			}		
		}catch(Exception ex) {
			
		}		
	}
}