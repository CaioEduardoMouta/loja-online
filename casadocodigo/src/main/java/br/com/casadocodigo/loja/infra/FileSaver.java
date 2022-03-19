package br.com.casadocodigo.loja.infra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Part;
import javax.validation.Path;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Paths;

public class FileSaver {
	
	public static final String SERVER_PATH = "/casadocodigo";

	public String write(Part arquivo, String path) throws IOException {
		String relativePath = path + "/" + arquivo.getSubmittedFileName();
		String fullPath = SERVER_PATH + "/" +relativePath;

		try {
			arquivo.write(fullPath);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return relativePath;
	}
	
	public static void transfer(Path source, ServletOutputStream outputStream) {
		try {
			  FileInputStream input = new FileInputStream(source.toFile());
		try(ReadableByteChannel inputChannel = Channels.newChannel(input);
				WritableByteChannel outputChannel = Channels.newChannel(outputStream)){
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 10);
			
			while(inputChannel.read(buffer) != - 1) {
				outputChannel.write(buffer);
				buffer.clear();
			}
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}catch (FileNotFoundException e) {
		throw new RuntimeException(e);
	}
	}
	
}
