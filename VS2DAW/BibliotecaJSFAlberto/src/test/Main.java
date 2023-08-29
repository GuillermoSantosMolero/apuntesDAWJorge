package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entidades.Prestamo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaJSF");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		
		Prestamo prestamo=new Prestamo();
		prestamo=em.find(Prestamo.class, 7L);
		System.out.println(prestamo.getEjemplar());


	}

}
