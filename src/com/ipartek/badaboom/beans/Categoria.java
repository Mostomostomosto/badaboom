package com.ipartek.badaboom.beans;

import java.io.Serializable;

public class Categoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String categoria;
	
	public Categoria(int codigo, String categoria) {
		super();
		this.codigo = codigo;
		this.categoria = categoria;
	}
	

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
