package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_AUTOR")
@SequenceGenerator(name="sqAutor", sequenceName="SQ_AUTOR", allocationSize=1)
public class Autor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="sqAutor", strategy=GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="nome", nullable=false, length=300)
	private String nome;
	
	@Column(name="sexo", nullable=false)
	private Sexo sexo;
	
	@Column(name="sobrenome", nullable=false, length=300)
	private String sobrenome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	public Autor() {
	}

	public Autor(long id, String nome, Sexo sexo, String sobrenome, Calendar dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
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

	public String getNome() {
		return nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
}
