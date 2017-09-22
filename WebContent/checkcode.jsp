<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<div class="container12 main-content">
	<div class="column8 profile-form">
		<h2>Recuperar contraseña</h2>
        <form action="ResetPassword" method="post">
        	<label for="pass">Introduzca la nueva contraseña</label>
        	<input type="text" name="pass" id="pass">

        </form>
	</div>


<%@ include file="menu.jsp" %>
<div class="clear"></div>
<%@ include file="footer.jsp" %>