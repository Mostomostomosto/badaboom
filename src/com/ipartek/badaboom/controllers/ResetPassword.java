package com.ipartek.badaboom.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.badaboom.dao.BdOperaciones;

/**
 * Servlet implementation class ResetPassword
 */
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		String code = request.getParameter("code");
		String email = bdOperaciones.getCode(code);
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/resetpassword.jsp");
		if(!email.equals("")){
			request.setAttribute("email", email);
		}else{
			String mensaje = "El código introducido no es correcto";
			request.setAttribute("mensaje", mensaje);
			ct.getRequestDispatcher("/checkcode.jsp");
		}
		bdOperaciones.cerrarConexion();
		rd.forward(request, response);
	}

}
