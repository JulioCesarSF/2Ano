package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_LIVRO")
public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long isbn;

	@Column(name = "titulo", nullable = false, length = 200)
	private String titulo;

	private double preco;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_lancamento", updatable = false)
	private Calendar dataLancamento;

	@Lob
	private byte[] capa;

	public Livro() {
	}

	public Livro(long isbn, String titulo, double preco, Calendar dataLancamento, byte[] capa) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.capa = capa;
	}

	@PrePersist
	public void cadastro() {
		System.out.println("->Efetuando cadastro [" + getClass().getName() + "]");
	}

	@PostPersist
	public void cadastroFeito() {
		System.out.println("->Cadastrado com sucesso!");
	}

	@Override
	public String toString() {
		return new StringJoiner("\n").add("ISBN: " + String.valueOf(this.isbn)).add("Título: " + this.titulo)
				.add("Preço: " + String.valueOf(this.preco))
				.add("Data Lançamento: " + this.dataLancamento.getTime().toString()).toString();
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getPreco() {
		return preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}

}
