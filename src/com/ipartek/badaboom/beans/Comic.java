package com.ipartek.badaboom.beans;

import java.io.Serializable;
import java.util.Date;

public class Comic implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String titulo;
	private String autor;
	private String categoria;
	private String editorial;
	private double precio;
	private int stock;
	private String descripcion;
	private String imagen;
	private Date fecha;
	private int codigoAutor;

	public Comic(String isbn, String titulo, String autor, String categoria, String editorial, double precio,
			int stock) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.editorial = editorial;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Comic() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCodigoAutor() {
		return codigoAutor;
	}

	public void setCodigoAutor(int codigoAutor) {
		this.codigoAutor = codigoAutor;
	}
	
}
