<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="java.util.*"%>
<%@ page import="com.ipartek.badaboom.beans.*" %>
<%@ include file="header.jsp" %>
<%List<Categoria> categorias = (List<Categoria>) request.getSession().getAttribute("categorias"); %>
<div class="container12 main-content">
        <div class="column8">
	<h2>Búsqueda avanzada</h2>
	<form action="Busqueda" class="profile-form">
		<label for="titulo">Título</label>
		<input type = "hidden" name="avanzada" value="1">
		<input type="text" id="titulo" name="titulo">
		<input type="radio" name="andOr" value="and" checked="checked"> AND
  		<input type="radio" name="andOr" value="or"> OR<br>
  		<label for="autor">Autor:</label>
  		<input type="text" id="autor" name="autor">
  		<label for="categoria">Categoria</label>
  		<select name="categoria" id="categoria">
  			<option value="0">todas</option>
  			<%
  				for(int i = 0; i <categorias.size();i++){
  				String codigo = Integer.toString(categorias.get(i).getCodigo());
  				String nombre = categorias.get(i).getCategoria();	
  			%>
  			
  			
  			<option value="<%=codigo %>"><%=nombre %></option>
  			<%} %>
  		</select>
		<p>Ordenado por:</p>
		<input type="radio" name="orderBy" value="l.titulo" checked="checked"> Título
  		<input type="radio" name="orderBy" value="a.nom_autor"> Autor<br>
  		<input type="submit" value="buscar">
		</form>
	</div>
 	<%@ include file="menu.jsp" %>
	<div class="clear"></div>
	<%@ include file="footer.jsp" %>




