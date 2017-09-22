<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat"%>
<%	
	List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
	Map<Comic, Integer> mapComics = new HashMap<Comic, Integer>();
	Set<Comic> setComics;
	double precioTotal = 0;
	DecimalFormat df2 = new DecimalFormat(".##");
%>
<%@ include file="header.jsp" %>
<div class="container12 main-content">
    <div class="column8"> 
    	<%for (Pedido p:pedidos){ 
    		mapComics = p.getDetalles();
    		setComics = mapComics.keySet();
    		precioTotal = 0;
    	%>
    		
    		 <div class="pedido_detalles">
             	<header class="header">
             		<div class="column2">
                    	<p>FECHA</p>
                    	<p><%=p.getFechaCompra() %></p>
                    </div>
                    <div class="column2">
                    	<p>IMPORTE</p>
                    	<p><%=p.getPrecioTotal() %> €</p>
          			</div>
                    <div class="column3">
                    	<p>PEDIDO NÚMERO:</p>
                    	<p><%=p.getIdCompra() %></p>
                 	</div>

              		<div class="clear"></div>
         		</header>
      			<%for (Comic comic:setComics){ 
      				precioTotal += comic.getPrecio()*mapComics.get(comic);
      			%>
      				
      				<div class="items-pedido">
                        <div class="row carrito">
                            <div class="delete">
                                <a href="Delete"><img src="images/delete.png" alt="delete item"></a>
                            </div>
                            <div class="column1">
                                <img src="images/titanes2.png" alt="chew">
                            </div>
                            <div class="column6">
                                <h2><%=comic.getTitulo() %></h2>
                                <p><strong>Autor: </strong><%=comic.getAutor() %></p>
                                <p><strong>Precio: </strong><%=comic.getPrecio() %>€</p>
                                <p class="cantidad"><strong>Cantidad: </strong> <%=mapComics.get(comic) %> unidades <span class="right"><strong>Total: </strong><%=comic.getPrecio()*mapComics.get(comic) %> €</span></p>
                            </div>
                        </div>
              		</div>
      			<%} %>
    		</div>
    	<%} %>
    </div>

<%@ include file="menu.jsp" %>
<div class="clear"></div>
<%@ include file="footer.jsp" %>