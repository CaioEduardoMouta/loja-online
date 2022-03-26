package br.com.casadocodigo.loja.beans;

import java.io.IOException;



import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao dao;
	
	@Inject
	private AutorDao autorDao;
	
	private Autor autor = new Autor();
	
	@Inject
	private FacesContext context;
	
	
	
	private Part capaLivro;
	
	public AdminLivrosBean() {
		context = FacesContext.getCurrentInstance();
	}

	@Transactional
	public String salvar() throws IOException {

		dao.salvar(livro);
		FileSaver fileSaver = new FileSaver();
		livro.setCapaPath(fileSaver.write(capaLivro,"livros"));
		
		String relativePath = write();
		livro.setCapaPath(relativePath);
		
		context.getExternalContext()
		.getFlash().setKeepMessages(true);
		
		context
		.addMessage(null, new FacesMessage("Livro cadastrado com sucesso"));
		
		return "/livros/lista?faces-redirect=true";
	}

	private String write() throws IOException {
		String ServerPath = "/casadocodigo";
		String relativePath = "/livros/" + capaLivro.getSubmittedFileName();
		capaLivro.write(ServerPath + relativePath);
		return relativePath;
	}
	
public AutorDao getAutorDao() {
	return autorDao;
}
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Part getCapaLivro() {
		return capaLivro;
	}
	
	public void setCapaLivro(Part capaLivro) {
		this.capaLivro = capaLivro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}


}
