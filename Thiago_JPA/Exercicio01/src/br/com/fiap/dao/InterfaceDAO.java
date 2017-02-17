package br.com.fiap.dao;

public interface InterfaceDAO<E> {
	
	void cadastrar(E entity);
	E buscar(int cd);
	void remover(int cd);
	void alterar(E entity);
	
}
