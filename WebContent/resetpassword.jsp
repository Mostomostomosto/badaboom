<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%String email = (String) request.getAttribute("email"); %>
<div class="container12 main-content">
	<div class="column8 profile-form">
		<h2>Recuperar contraseña</h2>
        <form action="SetPassword" method="post">
        <input type="hidden" name="email" value="<%=email%>">
        	<label for="pass">Introduzca la nueva contraseña</label>
        	<input type="text" name="pass" id="pass">
        	<label for="check">Repita la contraseña</label>
        	<input type="text" name="check" id="check">
        	<input type="submit" valuo="enviar">
        </form>
	</div>


<%@ include file="menu.jsp" %>
<div class="clear"></div>
<%@ include file="footer.jsp" %>