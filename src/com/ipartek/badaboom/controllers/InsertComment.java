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
 * Servlet implementation class InsertComment
 */
public class InsertComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BdOperaciones bdOperaciones = new BdOperaciones();
		String isbn = request.getParameter("isbn");
		String comment = request.getParameter("comment");
		String dni = request.getParameter("dni");
		response.setCharacterEncoding("UTF-8");
		bdOperaciones.abrirConexion();
		bdOperaciones.insertComment(dni, isbn, comment);
		bdOperaciones.cerrarConexion();
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/Detalle?isbn=" + isbn);
		rd.forward(request,response);
		
	}

}
