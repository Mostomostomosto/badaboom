package com.ipartek.badaboom.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
 * Servlet implementation class Comprar
 */
public class Comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comprar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String mensaje = "Su compra se ha realizado con éxito";
		User u = (User) sesion.getAttribute("user");
		Compra c = (Compra) sesion.getAttribute("compra");
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/compra.jsp");
		Double precio = Double.valueOf(request.getParameter("precio"));
		request.setAttribute("precio", precio);
		Date fechaCompra;
		
		try {
			Integer idCompra = bdOperaciones.realizarCompra(u, c, precio);
			if(idCompra != null){
				fechaCompra = bdOperaciones.getOrderDate(idCompra);
				request.setAttribute("fecha", fechaCompra);
				request.setAttribute("compraprocesada", c);
				request.setAttribute("id", idCompra);
				request.setAttribute("precio", precio);
				List<Comic> carrito = bdOperaciones.getCarrito(c);
				request.setAttribute("carrito", carrito);
				sesion.removeAttribute("compra");
				
			}else{
				mensaje = "Ha habido un error al procesar su compra";
				rd = ct.getRequestDispatcher("/Carrito");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensaje = "Ha habido un error al procesar su compra";
			rd = ct.getRequestDispatcher("/Carrito");
		}
		bdOperaciones.cerrarConexion();
		request.setAttribute("mensaje", mensaje);
		rd.forward(request, response);
		
	}

}
