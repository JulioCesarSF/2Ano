package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Livro;

public class TesteLivro {
	
	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager m = f.createEntityManager();
		
		Livro l = new Livro(0, "Livro Teste", 99.99, new GregorianCalendar(2016, Calendar.FEBRUARY, 17), new byte[1]);
		
		m.persist(l);
		m.getTransaction().begin();
		m.getTransaction().commit();
		
		m.close();
		f.close();
	}

}
