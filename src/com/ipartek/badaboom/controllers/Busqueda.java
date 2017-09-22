package com.ipartek.badaboom.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.badaboom.beans.Comic;
import com.ipartek.badaboom.dao.BdOperaciones;

/**
 * Servlet implementation class Busqueda
 */
public class Busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Busqueda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String avanzada = request.getParameter("avanzada");
		String param = request.getParameter("busqueda");
		BdOperaciones bdOperaciones = new BdOperaciones();
		List<Comic> resultados = new ArrayList<Comic>();
		bdOperaciones.abrirConexion();
		int numeroComics = 0;
		if(avanzada == null){
		numeroComics = (bdOperaciones.getBusquedaSize(param)/12)+1;
		resultados = bdOperaciones.busqueda(param);
		}else{
			String titulo = request.getParameter("titulo");
			String andOr = request.getParameter("andOr");
			String autor = request.getParameter("autor");
			int categoria = Integer.parseInt(request.getParameter("categoria"));
			String orderBy = request.getParameter("orderBy");
			numeroComics = (bdOperaciones.getBusquedaSize(titulo, andOr, autor, categoria, orderBy)/12)+1;
			resultados = bdOperaciones.getComics(titulo, andOr, autor, categoria, orderBy);
		}
		String nC = request.getParameter("inicio");
		int inicio;
		if(nC != null){
		inicio = Integer.parseInt(nC);
		}else{
			inicio = 0;
		}

	
		request.setAttribute("TodosLosComics", resultados);
		request.setAttribute("numeroComics", numeroComics);
		bdOperaciones.cerrarConexion();
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/index.jsp");
		rd.forward(request,response);
	}

}
