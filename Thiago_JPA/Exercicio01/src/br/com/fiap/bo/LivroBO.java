package br.com.fiap.bo;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.entity.Livro;

public class LivroBO {
	
	public static void cadastrar(Livro entity, EntityManager m){
		new LivroDAO(m).cadastrar(entity);
	}
	public static Livro buscar(int cd, EntityManager m){
		return new LivroDAO(m).buscar(cd);
	}
	
	public static void remover(int cd, EntityManager m){
		new LivroDAO(m).remover(cd);
	}
	
	public static void alterar(Livro entity, EntityManager m){
		new LivroDAO(m).alterar(entity);
	}

}
