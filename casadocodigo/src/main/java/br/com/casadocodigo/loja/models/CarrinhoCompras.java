package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;

import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CarrinhoCompras implements Serializable{


		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Set<CarrinhoItem> itens =
		new HashSet<>();
		
		public void add(CarrinhoItem item) {
			itens.add(item);
		}

		public List<CarrinhoItem> getItens() {
			// TODO Auto-generated method stub
			return new ArrayList<CarrinhoItem>(itens); 
		}
		
}

