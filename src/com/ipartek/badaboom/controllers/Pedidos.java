package com.ipartek.badaboom.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.badaboom.beans.Comic;
import com.ipartek.badaboom.beans.Pedido;
import com.ipartek.badaboom.beans.User;
import com.ipartek.badaboom.dao.BdOperaciones;

/**
 * Servlet implementation class Pedidos
 */
public class Pedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pedidos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		HttpSession sesion = request.getSession();
		
		User u = (User) sesion.getAttribute("user");

		List<Pedido> pedidos = bdOperaciones.getOrders(u.getDni());
		
		Map<Comic, Integer> detalles = null;
		for(int i = 0; i<pedidos.size(); i++){
			detalles = new HashMap<Comic, Integer>();
			detalles = bdOperaciones.getDetalles(pedidos.get(i).getIdCompra());
			
			pedidos.get(i).setDetalles(detalles);
			
		}
		request.setAttribute("pedidos", pedidos);
		bdOperaciones.cerrarConexion();
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/pedidos.jsp");
		rd.forward(request, response);
	}

}
