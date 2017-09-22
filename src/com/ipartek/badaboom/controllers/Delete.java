package com.ipartek.badaboom.controllers;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.badaboom.beans.Compra;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comicIsbn = request.getParameter("isbn");
		HttpSession sesion = request.getSession();
		Compra compra = (Compra) sesion.getAttribute("compra");
		Map<String, Integer> mapCompra = compra.getDetalle();
		Set<String> setIsbns = mapCompra.keySet();
		for (String isbn:setIsbns){
			if(isbn.equals(comicIsbn)){
				mapCompra.remove(isbn);
			}
		}
		sesion.setAttribute("compra", compra);
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/Carrito");
		rd.forward(request, response);
	}

}
