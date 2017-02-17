package br.com.fiap.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Editora;

public class TesteEditora {
	
	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager m = f.createEntityManager();
		
		Editora e = new Editora(0, "52.591.594/0001-56", "Editora FIAP", "Av. Paulista");
		
		m.persist(e);
		m.getTransaction().begin();
		m.getTransaction().commit();
		
		m.close();
		f.close();
	}

}
