package com.ipartek.badaboom.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ipartek.badaboom.beans.Comic;

public class Pedido {
	Map<Comic, Integer> detalles;
	private Date fechaCompra;
	private int idCompra;
	private String dni;
	private double precioTotal;

	public Pedido() {
		super();
		this.detalles = new HashMap<Comic, Integer>();

	}

	

	public Map<Comic, Integer> getDetalles() {
		return detalles;
	}



	public void setDetalles(Map<Comic, Integer> detalles) {
		this.detalles = detalles;
	}

	

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}



	public double getPrecioTotal() {
		return precioTotal;
	}



	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
}
