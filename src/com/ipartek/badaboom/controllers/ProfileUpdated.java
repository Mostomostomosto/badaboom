package com.ipartek.badaboom.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.badaboom.beans.User;
import com.ipartek.badaboom.dao.BdOperaciones;

/**
 * Servlet implementation class ProfileUpdated
 */
public class ProfileUpdated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileUpdated() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		User u = new User();
		u.setNombre(request.getParameter("nombre"));
		u.setApellido1(request.getParameter("apellido1"));
		u.setApellido2(request.getParameter("apellido2"));
		u.setDni(request.getParameter("dni"));
		u.setDireccion(request.getParameter("direccion"));
		u.setEmail(request.getParameter("email"));
		u.setUser(request.getParameter("user"));
		u.setPassword(request.getParameter("password"));	
		bdOperaciones.updateUser(u);
		bdOperaciones.cerrarConexion();
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/Profile?user=" + u.getUser());
		rd.forward(request,response);
		
	}

}
