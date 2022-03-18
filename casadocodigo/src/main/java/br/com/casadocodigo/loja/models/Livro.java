package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
public class Livro {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String titulo;
	@Lob
	@Length
	private String descricao;
	
	@DecimalMin("20")
	private BigDecimal preco;
	
	@Min(50)
	private Integer numerosDePaginas;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataPublicacao;
	
	private String capaPath;
	
	@ManyToMany
	@Size(min=1)
	@NotNull
	private List<Autor> autores = new ArrayList<>();
	
	
	
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
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", preco=" + preco
				+ ", numerosDePaginas=" + numerosDePaginas + ", autores=" + autores + "]";
	}
	public String getCapaPath() {
		return capaPath;
	}
	public void setCapaPath(String capaPath) {
		this.capaPath = capaPath;
	}
	
	
	
}
