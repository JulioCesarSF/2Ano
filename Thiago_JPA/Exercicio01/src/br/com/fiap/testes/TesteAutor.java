package br.com.fiap.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Sexo;

public class TesteAutor {
	
	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager m = f.createEntityManager();
		
		Autor a = new Autor(0, "Júlio", Sexo.MASCULINO, "César", new GregorianCalendar(2017, Calendar.FEBRUARY, 17));
		
		m.persist(a);
		m.getTransaction().begin();
		m.getTransaction().commit();
		
		m.clear();
		f.close();
	}

}
