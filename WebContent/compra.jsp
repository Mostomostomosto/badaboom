<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ipartek.badaboom.beans.*" %>
<%@ page import="java.text.DecimalFormat"%>
<%
	String mensaje = (String) request.getAttribute("mensaje");
	Double precioTotal = (Double) request.getAttribute("precio");
	Integer id = (Integer) request.getAttribute("id");
	List<Comic> cart = (List<Comic>) request.getAttribute("carrito");
	Compra compraDetalles = (Compra) request.getAttribute("compraprocesada");
	Map<String, Integer> mapComics = compraDetalles.getDetalle();
	Set<String> setIsbns = mapComics.keySet();
	DecimalFormat df2 = new DecimalFormat(".##");
	Date fecha = (Date) request.getAttribute("fecha");
%>
<%@ include file="header.jsp" %>
<div class="container12 main-content">
    <div class="column8">  
		<h2><%=mensaje %></h2>
			<%if(id !=null){ %>
			<div class="pedido">
				<header>
					<div class="column2">
						<p>FECHA</p>
						<p><%=fecha %></p>
					</div>
                    <div class="column2">
                    	<p>IMPORTE</p>
                    	<p><%=precioTotal %> €</p>
					</div>
                    <div class="column3 last">
                    	<p>PEDIDO NÚMERO:</p>
                        <p><%=id %></p>
					</div>
                    <div class="clear"></div>
 				</header>
                <%
					for (String isbn:setIsbns){
						for(Comic comic:cart){
							if(isbn.equals(comic.getIsbn())){
								precioTotal += comic.getPrecio() * mapComics.get(isbn);
								%>
								<div class="row">
			                            <div class="column1"><img src="images/dungeons.png" alt=""></div>
			                            <div class="column5">
			                            <p><%=comic.getTitulo() %></p>
			                            <p><%=mapComics.get(isbn) %> Unidad<%if(mapComics.get(isbn)>1){ %>es<%} %> - <%=comic.getPrecio() %>€</p></div>
			                            <div class="column2 last">
			                                
			                                <p>TOTAL: <%=comic.getPrecio() + mapComics.get(isbn) %> €</p>
			                            </div>
			                        </div>
								
								<%
							}
						}
					}
				request.setAttribute("precio", precioTotal);
			}        
				%>
			</div>
			<p class="comment"><span><a href="Pedidos">Ver todos mis pedidos</a></span></p>
		</div>
<%@ include file="menu.jsp" %>
<div class="clear"></div>
<%@ include file="footer.jsp" %>    