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
import com.ipartek.badaboom.beans.User;
import com.ipartek.badaboom.dao.BdOperaciones;

/**
 * Servlet implementation class Profile
 */
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BdOperaciones bdOperaciones = new BdOperaciones();
		String user = request.getParameter("user");
		bdOperaciones.abrirConexion();
		User profile = bdOperaciones.getUser(user);
		String dni = profile.getDni();
		List<Comic> favorites = bdOperaciones.getFavorites(dni);
		List<Comment> comments = bdOperaciones.getComments("c.dni_user", dni);
		
		request.setAttribute("profile", profile);
		request.setAttribute("favorites", favorites);
		request.setAttribute("comments", comments);
		bdOperaciones.cerrarConexion();
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/profile.jsp");
		rd.forward(request,response);
	}

}
