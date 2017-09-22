package com.ipartek.badaboom.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ipartek.badaboom.beans.Categoria;
import com.ipartek.badaboom.beans.Comic;
import com.ipartek.badaboom.dao.BdOperaciones;


/**
 * Servlet Filter implementation class MainFilter
 */
public class MainFilter implements Filter {

    
    public MainFilter() {
        
    }


	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		BdOperaciones bdOperaciones = new BdOperaciones();
		bdOperaciones.abrirConexion();
		List<Categoria> cat = bdOperaciones.returnCat();
		List<Comic> novedades= bdOperaciones.getnovedades();
		Comic destacado = bdOperaciones.destacado();		
		HttpServletRequest req = (HttpServletRequest) request;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession sesion = req.getSession(true);
		sesion.setAttribute("categorias", cat);
		req.setAttribute("novedades", novedades);
		req.setAttribute("destacado", destacado);
		bdOperaciones.cerrarConexion();
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
