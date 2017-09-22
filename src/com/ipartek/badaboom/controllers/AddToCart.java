package com.ipartek.badaboom.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.badaboom.beans.Comic;
import com.ipartek.badaboom.beans.Compra;
import com.ipartek.badaboom.beans.User;
import com.ipartek.badaboom.dao.BdOperaciones;



/**
 * Servlet implementation class AddToCart
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		String c = request.getParameter("cantidad");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int cantidad = Integer.parseInt(c);

		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		User user = (User) request.getSession().getAttribute("user");
		boolean sesionIniciada = bdOperaciones.sesionIniciada(user);
		Compra compra = (Compra) request.getSession().getAttribute("compra");
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/Catalogo");
		// Comprobamos si hay una sesion con un usuario registrado
		if (!sesionIniciada) {
			rd = ct.getRequestDispatcher("/Catalogo");
		} else {
			if (stock > cantidad) {
				if (compra == null) {
					compra = new Compra();
				}
				compra.addDetalle(isbn, cantidad);
				
				HttpSession sesion = request.getSession();
				sesion.setAttribute("compra", compra);
				rd = ct.getRequestDispatcher("/Carrito");
			} else {
				Comic comic = bdOperaciones.getComic(isbn);
				request.setAttribute("comic", comic);
				
				rd = ct.getRequestDispatcher("/Detalle?isbn=" + comic.getIsbn());
				
			}
			
		}

		bdOperaciones.cerrarConexion();
		rd.forward(request, response);
	}
}


