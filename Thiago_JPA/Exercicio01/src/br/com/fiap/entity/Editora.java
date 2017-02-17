package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_EDITORA")
@SequenceGenerator(name="sqEditora", sequenceName="SQ_EDITORA" , allocationSize=1)
public class Editora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqEditora")
	private long id;
	
	@Column(name="cnpj", nullable=false, length=100)
	private String cnpj;
	
	@Column(name="nome", nullable=false, length=300)
	private String nome;
	
	private String endereco;
	
	public Editora(){}

	public Editora(long id, String cnpj, String nome, String endereco) {
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	@PrePersist
	public void cadastro(){
		System.out.println("->Efetuando cadastro [" + getClass().getName() + "]");
	}
	
	@PostPersist
	public void cadastroFeito(){
		System.out.println("->Cadastrado com sucesso!");
	}

	public long getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
