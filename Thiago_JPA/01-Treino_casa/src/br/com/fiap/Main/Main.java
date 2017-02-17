package br.com.fiap.Main;

import br.com.fiap.annotations.Table;
import br.com.fiap.beans.Pessoa;

public class Main {
	
	public static void main(String[] args) {	
		
		Table mensagem = Pessoa.class.getAnnotation(Table.class);
		System.out.println(mensagem.nome());
	}

}
