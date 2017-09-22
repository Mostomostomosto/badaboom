<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
<%@ page import="com.ipartek.badaboom.beans.*" %>
    <%
    	List<Categoria> cat = (List<Categoria>) request.getSession().getAttribute("categorias");
    	User user = (User) request.getSession().getAttribute("user");
    	Compra compra = (Compra) request.getSession().getAttribute("compra");
    	Map<String, Integer> carrito = null;
    	if(compra != null){
    		carrito = compra.getDetalle();
    	}
    	int items = 0;
    	if(carrito != null){
    		items = carrito.size();
    		
    	}
    %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Badaboom</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
    <link rel="stylesheet" href="css/1140.css">
    <link rel="stylesheet" href="css/style.css?v=40">
    <link rel="icon" href="images/favicon.png" sizes="16x16 32x32" type="image/png">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/script.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
</head>

<body>
    <div class="container12">
        <header>
            <div class="row">
                <div class="column6">
                    <nav id="upper-menu">
                        <ul id="menu-top">
                            <li class="menu-li"><a href="Catalogo">Inicío</a></li>
                            <li class="menu-li"><a href="busquedaAvanzada.jsp">Busqueda</a></li>
                            <li id="submenu" class="menu-li">
                                <a href="#" class="submenu-link">Categorías</a>
                                <ul id="children">
                                	<%
                                		for(Categoria c:cat){
                                	%>
                                		<li><a href="Categoria?categoria=<%=c.getCodigo() %>"><%=c.getCategoria() %></a></li>
                                	
                                	<%
                                		}
                                	%>
                                    
                                </ul>
                            </li>
                            <% if (user !=null){%>
                            <li class="menu-li"><a href="Profile?user=<%= user.getUser()%>">Mi perfil</a></li>
                            <%} %>
                        </ul>
                    </nav>
                </div>
                <%if(user == null){ %>
                <div class="column6 usuario">
                    Bienvenido, anónimo
                    <div class="cart">
                        <span class="cart-content"><a href="#"><%=items %></a></span>
                    </div>
                    | <a href="LoginForm">Login</a>
                </div>
                <%}else{ %>
                <div class="column6 usuario">
                    Bienvenido, <a href="UpdateProfile"><%=user.getUser() %></a> 
                    <div class="cart">
                        <span class="cart-content"><a href="Carrito"><%=items %></a></span>
                    </div>
                    | <a href="LogOut">Logout</a>
                </div>
                <%} %>
            </div>
            <h1><img src="images/logo.png" alt=""></h1>
           
        </header>
    </div>
    <nav>
        <ul id="index-menu">
            <%
            	for(Categoria c:cat){
           	%>
            	<li><a href="Categorias?c=<%=c.getCodigo() %>"><%=c.getCategoria() %></a></li>
		    <%
            	}
            %>
        </ul>
    </nav>