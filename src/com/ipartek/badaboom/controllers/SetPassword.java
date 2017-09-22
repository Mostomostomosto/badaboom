package com.ipartek.badaboom.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.badaboom.dao.BdOperaciones;

/**
 * Servlet implementation class SetPassword
 */
public class SetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BdOperaciones bdOperaciones = new BdOperaciones();
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mensaje = "La contraseña se ha actualizad con éxito!";
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/login.jsp");
		bdOperaciones.abrirConexion();
		if(!bdOperaciones.updatePassword(email, password)){
			mensaje="No se ha podido actualizar la contraseña";
			rd = ct.getRequestDispatcher("/resetpassword.jsp");
		}
		bdOperaciones.cerrarConexion();
	}

}
