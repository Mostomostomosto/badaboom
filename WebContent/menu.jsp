<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
<%@ page import="com.ipartek.badaboom.beans.Comic" %>
<% 	
	List<Comic> novedades = (List<Comic>) request.getAttribute("novedades");
	Comic destacado = (Comic) request.getAttribute("destacado");

%>
		<div class="column4" id="menu">
            <section id="busqueda-menu">
                <form action="Busqueda">
                    <input type="text" name="busqueda">
                </form>
            </section>
         	<section>
                <h2>Novedad destacada</h2>
                <img src="images/<%=destacado.getImagen()%>" alt="<%=destacado.getTitulo() %>" class="menu-img">
                <h3><%=destacado.getTitulo()%></h3>
                <p><%=destacado.getDescripcion()%></p>
            </section>
            <section>
                <h2>Iniciar sesión</h2>
                <form action="LogIn" method="post" id="login-form">
                    <input type="text" name="user" id="name">
                    <input type="password" name="password" id="password">
                    <input type="submit" value="login" id="login-submit">
                </form>
                <a href="NewAccount"><small>No tienes cuenta aún?</small></a>
            </section>
            <section>
                <h2>Ofertas de la semana</h2>
                <% for(Comic novedad:novedades){ %>
                <div class="column1">
                    <img src="images/<%=novedad.getImagen() %>" alt="<%=novedad.getTitulo() %>">
                </div>
                <%} %>
            </section>
        </div>
	</div>
        