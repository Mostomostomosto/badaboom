package com.ipartek.badaboom.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.badaboom.dao.BdOperaciones;
import com.ipartek.badaboom.beans.Comic;
import com.ipartek.badaboom.beans.User;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		ArrayList<Comic> comics =  (ArrayList<Comic>) bdOperaciones.getTodosLosComics(0);
		request.setAttribute("todosLosComics", comics);
		if(bdOperaciones.validarUsuario(user, password)){
			
			HttpSession sesion = request.getSession();
			User usuario = bdOperaciones.getUser(user, password);
			sesion.setAttribute("user", usuario);
			if(usuario.getPrivilegios()==1){
				sesion.setAttribute("admin", "1");
			}else{
				sesion.setAttribute("admin", "0");
			}			
			
		}
		bdOperaciones.cerrarConexion();
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/");

		rd.forward(request, response);
		
	}

}
