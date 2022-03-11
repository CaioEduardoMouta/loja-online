package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

public class Livro {

	private String titulo;
	private String descricao;
	private BigDecimal preco;
	private Integer numerosDePaginas;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Integer getNumerosDePaginas() {
		return numerosDePaginas;
	}
	public void setNumerosDePaginas(Integer numerosDePaginas) {
		this.numerosDePaginas = numerosDePaginas;
	}
	
	
	
}
