<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ipartek.badaboom.beans.*" %>

<%@ page import="java.text.DecimalFormat"%>
<%	
	List<Comic> cart = (List<Comic>) request.getAttribute("carrito");
	Compra compraDetalles = (Compra) session.getAttribute("compra");
	Map<String, Integer> mapComics = compraDetalles.getDetalle();
	Set<String> setIsbns = mapComics.keySet();
	double precioTotal = 0;
	DecimalFormat df2 = new DecimalFormat(".##");
%>
<%@ include file="header.jsp" %>
<div class="container12 main-content">
    <div class="column8">     
	<%
		for (String isbn:setIsbns){
			for(Comic comic:cart){
				if(isbn.equals(comic.getIsbn())){
					precioTotal += comic.getPrecio() * mapComics.get(isbn);
					%>
					<div class="row carrito">
	                    <div class="delete">
	                       <a href="Delete?isbn=<%=isbn%>"><img src="images/delete.png" alt="delete item"></a>
	                    </div>
	                    <div class="column1">
	                        <img src="images/<%=comic.getImagen() %>" alt="<%=comic.getTitulo()%>">
	                    </div>
	                    <div class="column6">
	                        <h2><%=comic.getTitulo() %></h2>
	                        <p><strong>Autor: </strong><%=comic.getAutor() %></p>
	                        <p><strong>Precio: </strong><%=df2.format(comic.getPrecio()) %>€</p>
	                        <p class="cantidad">
	                        	<strong>Cantidad: </strong> <%=mapComics.get(isbn) %> unidad<%if(mapComics.get(isbn)>1){ %>es<%} %>
	                        	<span class="right"><strong>Total: </strong><%=df2.format(comic.getPrecio() * mapComics.get(isbn)) %> €</span>
	                        </p>
	                    </div>
                	</div>
					
					<%
				}
			}
		}

	         
	%>
	<div class="row">
		<div class="column6 prefix1">
			<p class="right"><strong>Precio total: </strong><%=df2.format(precioTotal) %> € </p>
		</div>
	</div>
	
				<div class="centrar">
                        <div class="row buttons-containner">
                            <div class="compra-boton" id="compra-boton">
                                <p class="button"><a href="#compra-form">procesar la compra</a></p>
                            </div>
                            <div class="compra-boton">
                                <p class="button"><a href="Catalogo">Volver  la tienda</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="centrar">
                        <form action="Comprar" id="compra-form">
                            <h2>Introduzca los datos del comprador</h2>
                            <input type="hidden" name = "precio" value="<%=precioTotal %>">
                            <label for="nombre">Nombre</label>
                            <input type="text" name="nombre">
                            <label for="apellido1">Primer apellido</label>
                            <input type="text" name="apellido1">
                            <label for="apellido2">Segundo apellido</label>
                            <input type="text" name="apellido2">
                            <label for="dni">Dni</label>
                            <input type="text" name="dni">
                            <label for="tarjeta">Tarjeta de crédito</label>
                            <input type="text" name="tarjeta">
                            <div class="submit-container">
                                <input type="submit" class="submit-button" value="procesar compra">
                            </div>
                        </form>
                    </div>
</div>

<%@ include file="menu.jsp" %>
<div class="clear"></div>
<%@ include file="footer.jsp" %>