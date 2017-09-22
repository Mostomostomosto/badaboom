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

import com.ipartek.badaboom.beans.Categoria;
import com.ipartek.badaboom.beans.Comic;

import com.ipartek.badaboom.beans.Mailer;
import com.ipartek.badaboom.dao.BdOperaciones;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Servlet implementation class Catalogo
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
			
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		int numeroComics = (bdOperaciones.getComicsSize()/12)+1;
		String nC = request.getParameter("inicio");
		int inicio;
		if(nC != null){
			inicio = Integer.parseInt(nC);
		}else{
			inicio = 0;
		}
		
		List<Comic> comics = bdOperaciones.getTodosLosComics(inicio);
		request.setAttribute("TodosLosComics", comics);
		request.setAttribute("numeroComics", numeroComics);
		List<Categoria> cat = bdOperaciones.returnCat();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("categorias", cat);
		bdOperaciones.cerrarConexion();
		ServletContext ct = getServletContext();
		RequestDispatcher rd = ct.getRequestDispatcher("/index.jsp");
		rd.forward(request,response);
	}

}
