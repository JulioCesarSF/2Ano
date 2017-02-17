package br.com.fiap.bo;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EditoraDAO;
import br.com.fiap.entity.Editora;

public class EditoraBO {

	public static void cadastrar(Editora entity, EntityManager m){
		new EditoraDAO(m).cadastrar(entity);
	}
	public static Editora buscar(int cd, EntityManager m){
		return new EditoraDAO(m).buscar(cd);
	}
	
	public static void remover(int cd, EntityManager m){
		new EditoraDAO(m).remover(cd);
	}
	
	public static void alterar(Editora entity, EntityManager m){
		new EditoraDAO(m).alterar(entity);
	}
}
