<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<div class="container12 main-content">
         <div class="column8 profile-form">
        	<h2>Iniciar sesión</h2>
            <form action="LogIn" method="post" id="login-form">
            	<div class="row">
            		<div class="column7">
            			<label for="user">Nombre de usuario:</label>
            			<input type="text" name="user" id="user">
            		</div>
            	</div>
            	<div class="row">
            		<div class="column7">
            			<label for="password">Contraseña:</label>
            			<input type="password" name="password" id="pwd">
            		</div>
            	</div>
            	<input type="submit" value="enviar">
            </form>
            <p><a href="Reset">Ha olvidado su contraseña?</a></p>
            <p><a href="">Crear nueva cuenta</a></p>
        </div>


<%@ include file="menu.jsp" %>
<div class="clear"></div>
<%@ include file="footer.jsp" %>
    
    
