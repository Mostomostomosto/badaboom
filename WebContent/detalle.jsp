
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="header.jsp" %>
<%@ page import="java.util.*"%>
<%@ page import="com.ipartek.badaboom.beans.Comic" %>
<%@ page import="com.ipartek.badaboom.beans.Comment" %>
<%@ page import="com.ipartek.badaboom.beans.User" %>
<% 	Comic detalle = (Comic) request.getAttribute("detalle"); 
	List<Comment> comments = (List<Comment>) request.getAttribute("comments");
	
%>

<div class="container12 main-content">
        <div class="column8">
            <div class="row detalle">
                <div class="column3">
                    <img src="images/<%=detalle.getImagen() %>" alt="rural">
                </div>
                <div class="column4">
                    <h1><%=detalle.getTitulo() %></h1>
                    <p><strong>Autor:</strong><%=detalle.getAutor() %></p>
                    <p><%=detalle.getDescripcion() %></p>
                    <p><strong>Categoría: </strong><%=detalle.getCategoria() %></p>
                    <p><strong>Editorial: </strong><%=detalle.getEditorial()%></p>
                    <p><strong>Stock: </strong><%=detalle.getStock() %> unidades</p>
                    <p><strong>ISBN: </strong><%=detalle.getIsbn() %></p>
                    
                    <div class="detalle-carrito">
                        <p><strong>Precio: </strong>25 €</p>
                        
                    <form id="add-to-cart" action="AddToCart" method="post">
                        <input type="hidden" value="<%=detalle.getStock() %>" name="stock" id="stock">
                        <label for="cantidad">Cantidad:</label>
                        <input type="number" name="cantidad" id="cantidad" value 1 required><br> 
                        <input type="hidden" value="<%=detalle.getIsbn() %>" name="isbn" id="isbn">
                        <input type="submit" value="añadir al carrito">
                
                    </form>
                    
                  
                   
                    </div>
                </div>
            </div>
            <h2 class="hdos">Comentarios</h2>
            <%if(comments.size()>0){ 
            	for (Comment c:comments){ %>
            
            <div class="comment row">
            	
                <div class="column1">
                    <img src="images/<%=c.getImagen() %>" alt="<%= c.getUsuario()%>">
                </div>
                <div class="column7">
                    <%=c.getComment() %>
                </div>
                <span>Por <a href="Profile?user=<%= c.getUsuario()%>"><%= c.getUsuario()%></a> el <%=c.getFecha() %></span>
            </div>
            <%} 
            
            }else{
            	%>
            	<p class="no-comment"><%=detalle.getTitulo() %> aún no tiene opiniones, sé el primero en comentar</p>
            	<%
            }
            
            %>
          	<h2 class="hdos">Envía un comentario:</h2>
        	<div class="row">
        	
            	<form action="InsertComment" method="post" class="comment-form">
            		<textarea name="comment" id="commentform" cols="30" rows="10" 
            		<%
            		if(user == null){
            		
            		%>
            		disabled
            		<%} %>
            		></textarea>
            		<input type="hidden" name="isbn" value="<%= detalle.getIsbn()%>">
            		<%
            		if(user != null){
            		%>
            		<input type="hidden" name = "dni" value ="<%= user.getDni()%>">
            		<%} %>
            		<input type="submit" value="
					<%
            		if(user == null){
            		
            		%>Debes iniciar sesión para comentar
            		
            		<%}else{
            			%>
            			enviar
            		<%}%>
					">
            	</form>
            </div>
	        
		
        </div>
        <%@ include file="menu.jsp" %>
        <div class="clear"></div>
        <%@ include file="footer.jsp" %>
   
