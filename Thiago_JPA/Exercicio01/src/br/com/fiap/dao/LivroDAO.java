package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Livro;

public class LivroDAO implements InterfaceDAO<Livro> {
	
	EntityManager m = null;
	
	public LivroDAO(){}
	
	public LivroDAO(EntityManager m){
		this.m = m;
	}

	@Override
	public void cadastrar(Livro entity) {
		if(entity == null)
			return;
		m.persist(entity);
		m.getTransaction().begin();
		m.getTransaction().commit();		
	}

	@Override
	public Livro buscar(int cd) {
		return m.find(Livro.class, cd);				
	}

	@Override
	public void remover(int cd) {
		Livro entity = m.find(Livro.class, cd);
		if(entity != null){
			m.remove(entity);
			m.getTransaction().begin();
			m.getTransaction().commit();
		}	
	}

	@Override
	public void alterar(Livro entity) {
		if(entity == null)
			return;
		m.merge(entity);
		m.getTransaction().begin();
		m.getTransaction().commit();		
	}
}
