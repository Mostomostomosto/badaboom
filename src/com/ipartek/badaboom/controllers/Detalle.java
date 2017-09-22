package com.ipartek.badaboom.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.badaboom.beans.Comic;
import com.ipartek.badaboom.beans.Comment;
import com.ipartek.badaboom.dao.BdOperaciones;

/**
 * Servlet implementation class Detalle
 */
public class Detalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BdOperaciones bdOperaciones = new BdOperaciones();
		String isbn = request.getParameter("isbn");
		String column = "c.isbn";
		bdOperaciones.abrirConexion();
		Comic comic = bdOperaciones.detalle(isbn);
		List<Comment> comments = bdOperaciones.getComments(column, isbn);
		request.setAttribute("detalle", comic);
		request.setAttribute("comments", comments);
		bdOperaciones.cerrarConexion();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/detalle.jsp");
		rd.forward(request,response);
	}

}
