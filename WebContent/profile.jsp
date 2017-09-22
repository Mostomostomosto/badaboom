<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="com.ipartek.badaboom.beans.Comic" %>
<%@ page import="com.ipartek.badaboom.beans.Comment" %>
<%@ page import="com.ipartek.badaboom.beans.User" %>
<%@ include file="header.jsp" %>
<% 
	List<Comment> comments = (List<Comment>) request.getAttribute("comments");
	List<Comic> favorites = (List<Comic>) request.getAttribute("favorites");
	User profile = (User) request.getAttribute("profile");
	
	int hoy = (int) (new Date().getTime());
	
	int lastConnect = (int) (profile.getUltima_conexion().getTime());
	
	lastConnect -= hoy;
	lastConnect *= -0.000000011534;
%>
<div class="container12 main-content">
		<div class="column8 profile">
            <div class="profile-header">
                <img src="images/<%=profile.getImagen() %>" alt="ruth">
                <h1><%=profile.getUser() %></h1>
                <p>Registrado desde <%=profile.getFechaNacimiento() %> <span>Última conexion: hace <%=lastConnect %> días</span></p>
            </div>
            <div class="column4">
                <h2>Favoritos</h2>
                <%
	            if(favorites.size()>0){
	                for(Comic c:favorites){ %>
		                <div class="column2">
		                    <img src="images/<%=c.getImagen() %>" alt="<%=c.getTitulo()%>">
		                </div>
                <%} 
                }else{
                %>
                <p><%=profile.getUser() %> no ha marcado ningún favorito aún</p>
                <%} %>
			</div>
            <div class="column4 favorites">
                <h2>Últimos comentarios</h2>
                <%
	            if(comments.size()>0){
	                for(Comment comment:comments){ %>
                <div class="comment-profile">
                    <p><%=comment.getComment() %></p>
                   	<span class="footer-comment">El <%=comment.getFecha() %> en <a href="#"><%=comment.getTitulo() %></a></span>  
                </div>
				 <%} 
                }else{
                %>
                
                
                <%} %>
                
            </div>
        </div>
<%@ include file="menu.jsp" %>
<div class="clear"></div>
<%@ include file="footer.jsp" %>
</div>