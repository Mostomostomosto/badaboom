package com.ipartek.badaboom.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private String user;
	private String password;
	private String email;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private String direccion;
	private Date fechaNacimiento;
	private int privilegios;
	private String imagen;
	private Date ultima_conexion;
	public User(String user, String password, String email, String nombre, String apellido1, String apellido2,
			String dni, String direccion, Date fechaNacimiento, int privilegios) {
		super();
		this.user = user;
		this.password = password;
		this.email = email;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.privilegios = privilegios;
	}
	public User(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		String cadena = nombre + ' '+ apellido1 + ' ' + apellido2;
		return cadena;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getPrivilegios() {
		return privilegios;
	}
	public void setPrivilegios(int privilegios) {
		this.privilegios = privilegios;
	}
	public String dameFecha(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
		Date fecha = getFechaNacimiento();        
		String fecha_nac = df.format(fecha);
		return fecha_nac;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getUltima_conexion() {
		return ultima_conexion;
	}
	public void setUltima_conexion(Date ultima_conexion) {
		this.ultima_conexion = ultima_conexion;
	}
	
	
	
}
