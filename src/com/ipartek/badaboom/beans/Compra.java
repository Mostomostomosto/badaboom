package com.ipartek.badaboom.beans;

import java.util.HashMap;
import java.util.Map;

public class Compra {
	private Map<String, Integer> detalle;

	public Compra() {
		super();
		this.detalle = new HashMap<String, Integer>();
	}

	public Map<String, Integer> getDetalle() {
		return detalle;
	}
	
	public void addDetalle(String isbn, int cantidad){
		if(detalle.containsKey(isbn)){
			detalle.put(isbn, detalle.get(isbn)+cantidad);
		}else{
			detalle.put(isbn, cantidad);
		}
	}

	public void setDetalle(Map<String, Integer> detalle) {
		this.detalle = detalle;
	}
	
}
