package com.ipartek.badaboom.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.badaboom.config.Configuracion;
import com.ipartek.badaboom.config.GestorConfiguracion;
import com.ipartek.badaboom.dao.BdBase;
import com.ipartek.badaboom.dao.BdOperaciones;

/**
 * Servlet implementation class SrvValidarEntrada
 */
public class SrvValidarEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// String FICHERO_CONFIGURACION = "C:\\Tomcat
		// 5.5\\webapps\\ArtupaWeb\\WEB-INF\\artupa.properties";
		String FICHERO_CONFIGURACION = getServletConfig().getInitParameter(
				"fichero_propiedades");
		boolean cargaCorrecta = GestorConfiguracion
				.cargarConfiguracion(FICHERO_CONFIGURACION);
		if (!cargaCorrecta) {
			System.out
					.println("Fichero de configuración no cargado correctamente");
		} else {
			BdBase.inicializarParametrosConexion(Configuracion.getInstancia());
		}
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		boolean correcto = bdOperaciones.validarUsuario(user, password);
		bdOperaciones.cerrarConexion();
		if (correcto) {
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("user", user);
			ServletContext ct = getServletContext();
			RequestDispatcher rd = ct.getRequestDispatcher("/menu.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}
	}


}
