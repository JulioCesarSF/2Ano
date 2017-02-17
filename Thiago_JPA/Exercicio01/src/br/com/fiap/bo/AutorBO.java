package br.com.fiap.bo;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AutorDAO;
import br.com.fiap.entity.Autor;

public abstract class AutorBO {

	public static void cadastrar(Autor entity, EntityManager m){
		new AutorDAO(m).cadastrar(entity);
	}
	public static Autor buscar(int cd, EntityManager m){
		return new AutorDAO(m).buscar(cd);
	}
	
	public static void remover(int cd, EntityManager m){
		new AutorDAO(m).remover(cd);
	}
	
	public static void alterar(Autor entity, EntityManager m){
		new AutorDAO(m).alterar(entity);
	}	
}
