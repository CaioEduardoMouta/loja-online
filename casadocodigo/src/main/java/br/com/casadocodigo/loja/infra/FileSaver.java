package br.com.casadocodigo.loja.infra;

import java.io.IOException;

import javax.servlet.http.Part;

public class FileSaver {
	
	public static final String SERVER_PATH = "/casadocodigo";

	public String write(Part arquivo, String path) throws IOException {
		String relativePath = path + "/" + arquivo.getSubmittedFileName();
		
		try {
			arquivo.write(SERVER_PATH + "/" +relativePath);
			return relativePath;
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	
}
