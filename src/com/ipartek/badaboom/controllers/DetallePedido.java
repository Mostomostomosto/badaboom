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


public class DetallePedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DetallePedido() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			HttpSession sesion = request.getSession();
			User u = (User) sesion.getAttribute("user");
			
			ServletContext ct = getServletContext();
			RequestDispatcher rd = ct.getRequestDispatcher("/detallePedido.jsp");
			if (u != null){
				BdOperaciones bdOperaciones = new BdOperaciones();
				bdOperaciones.abrirConexion();
				
				Compra compra = bdOperaciones.getCompra(id);
				List<Comic> carrito = bdOperaciones.getCarrito(compra);
				
				request.setAttribute("carrito", carrito);
				request.setAttribute("compra", compra);
				bdOperaciones.cerrarConexion();
			}else{
				rd = ct.getRequestDispatcher("/LogIn");
			}
			
			rd.forward(request, response);
			
	}

}
