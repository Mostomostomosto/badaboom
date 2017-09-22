package com.ipartek.badaboom.controllers;
import java.io.IOException;
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
 * Servlet implementation class Carrito
 */
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		User u = (User) sesion.getAttribute("user");
		Compra compra = (Compra) sesion.getAttribute("compra");
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		List<Comic> carrito = bdOperaciones.getCarrito(compra);
		request.setAttribute("carrito", carrito);
		bdOperaciones.cerrarConexion();
		
		ServletContext ct = getServletContext();
		RequestDispatcher rd;
		
		if(u==null){
			rd = ct.getRequestDispatcher("/LogIn");
		}else{
			rd = ct.getRequestDispatcher("/carrito.jsp");
		}
		
		rd.forward(request,response);
	}

}
