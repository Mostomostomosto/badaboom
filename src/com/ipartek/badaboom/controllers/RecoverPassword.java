package com.ipartek.badaboom.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.badaboom.beans.Mailer;
import com.ipartek.badaboom.dao.BdOperaciones;

/**
 * Servlet implementation class RecoverPassword
 */
public class RecoverPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";  
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
		}
    public RecoverPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = randomAlphaNumeric(50);
		String email = request.getParameter("email");
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		ServletContext ct = getServletContext();
		RequestDispatcher rs = ct.getRequestDispatcher("/checkcode.jsp");
		String mensaje ="Hemos enviado un correo con el código";
		Mailer mailer = new Mailer();
		if(bdOperaciones.checkMail(email)){
			bdOperaciones.recover(code, email);
			mailer.sender(email, code);
		}else{
			mensaje ="La direccion de correo introducida no aparece en nuestra base de datos";			
			rs = ct.getRequestDispatcher("/reset.jsp");
		}
		request.setAttribute("mensaje", mensaje);
		bdOperaciones.cerrarConexion();
		rs.forward(request, response);
	}

}
