package com.ipartek.badaboom.controllers;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.badaboom.beans.User;
import com.ipartek.badaboom.dao.BdOperaciones;


/**
 * Servlet implementation class InsertUser
 */
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		Boolean insert = false;
		ServletContext ct = getServletContext();
		RequestDispatcher rd;
		String mensaje = "Se ha producido un error, el usuario no se ha registrado correctamente.";
		u.setNombre(request.getParameter("nombre"));
		u.setApellido1(request.getParameter("apellido1"));
		u.setApellido2(request.getParameter("apellido2"));
		u.setDni(request.getParameter("dni"));
		u.setDireccion(request.getParameter("direccion"));
		u.setEmail(request.getParameter("email"));
		u.setUser(request.getParameter("user"));
		u.setPassword(request.getParameter("password"));
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		rd = ct.getRequestDispatcher("/Profile?user=" + u.getUser());
		if(!bdOperaciones.checkDni(request.getParameter("dni")) 
				&& !bdOperaciones.checkUser(request.getParameter("user")) 
				&& !bdOperaciones.checkMail(request.getParameter("email"))){
				if(bdOperaciones.insertarUsuario(u)){
					HttpSession sesion = request.getSession();
					sesion.setAttribute("user", u);
					
				}else{
					request.setAttribute("mensaje", mensaje);
					rd = ct.getRequestDispatcher("/NewAccount");
				}
		
		}
		rd.forward(request,response);
		bdOperaciones.cerrarConexion();
				
	}

}
