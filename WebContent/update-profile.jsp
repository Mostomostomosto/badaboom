<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%
	User profile = (User) request.getAttribute("profile");
%>
 <div class="container12 main-content">
         <div class="column8 profile-form">
        	<h2>Nuevo usuario</h2>
            <form action="ProfileUpdated" method="post" id="update-form">
            	
            	<div class="row">
            		<div class="column4">
            			<label for="nombre">Nombre:</label>
            			<input type="text" name="nombre" value="<%=profile.getNombre()%>" id="nombre">
            		</div>
            		<div class="column4">
            			<label for="apellido1">Primer apellido:</label>
            			<input type="text" name="apellido1" value="<%=profile.getApellido1()%>" id="apellido1">
            		</div>
            		<div class="column4">
            			<label for="apellido2">Segundo apellido:</label>
            			<input type="text" name="apellido2" value="<%=profile.getApellido2()%>" id="apellido2">
            		</div>
            	</div>
            	
            	<div class="row">
            		<div class="column7">
            			<label for="dni">DNI:</label>
            			<input type="text" name="dni" value="<%=profile.getDni()%>" id="dni">
            		</div>
            	</div>
            	<div class="row">
            		<div class="column7">
            			<label for="direccion">Dirección:</label>
            			<textarea name="direccion" id="direccion" cols="30" rows="3" id="direccion"> <%=profile.getDireccion()%></textarea>
            		</div>
            	</div>
            	<div class="row">
            		<div class="column7">
            			<label for="email">Email:</label>
            			<input type="text" name="email" id="email" value="<%=profile.getEmail()%>" id="email">
            		</div>
            	</div>
            	<div class="row">
            		<div class="column7">
            			<label for="user">Nombre de usuario:</label>
            			<input type="text" name="user" value="<%=profile.getUser()%>" id="user">
            		</div>
            	</div>
            	<div class="row">
            		<div class="column7">
            			<label for="password">Contraseña:</label>
            			<input type="password" name="password" value="<%=profile.getPassword()%>" id="pwd">
            		</div>
            	</div>
            	<input type="submit" value="enviar">
            </form>
        </div>


<%@ include file="menu.jsp" %>
<div class="clear"></div>
<%@ include file="footer.jsp" %>
    