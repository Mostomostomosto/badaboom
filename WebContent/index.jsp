
<%@ page import="java.util.*"%>
<%@ page import="com.ipartek.badaboom.beans.Comic" %>
<% 	
	List<Comic> comics = (List<Comic>) request.getAttribute("TodosLosComics");
	int rowCounter = 0;
	int moreThanOne = 0;
	int numeroComics = (int) request.getAttribute("numeroComics");
	String msg = (String) request.getAttribute("mensaje");

%>
<%@ include file="header.jsp" %>


<div class="container12 main-content">
        <div class="column8">
	        <%if(msg != null){ %>
	        <%=msg %>
	        <%} %>
	        <% for(Comic comic:comics){ 
	        	rowCounter ++;
	        	
	        	if(rowCounter==1){
	        		moreThanOne ++;
	        %>
	        <div class="row">
	        
	        <%} %>
	            <div class="column2">
	                <a href="Detalle?isbn=<%=comic.getIsbn()%>"><img src="images/<%=comic.getImagen() %>" alt="<%= comic.getTitulo()%>"></a>
	                <footer>
	                    <p><a href="Detalle?isbn=<%=comic.getIsbn()%>"><%=comic.getTitulo() %></a></p>
	                    <p>Autor: <a href="Autor?autor=<%=comic.getCodigoAutor()%>"><%=comic.getAutor() %></a></p>
	                </footer>
	            </div>
	            <%
	        	if(rowCounter == 4){
	        		
	        	%>
	        	</div>
	        	<%
	        		
	        		rowCounter = 0;
	        	}
	        } 
	        
	        %>

	        <%if(rowCounter < 4 && moreThanOne == 1){ 
	        System.out.println(moreThanOne + ";" + rowCounter);
	        %>
	        </div>
	        <%} %>
            <%if (numeroComics >1){ %>
            <div class="row">
	            <nav>
	                <ul id="pagination">
	                <%
	                int inicio = 0;
	                %>
	                    <li><a href="Catalogo?inicio=0"><<</a></li>
	                    <%for(int i = 0;i<numeroComics;i++){ %>
	                    <li><a href="Catalogo?inicio=<%=i*12%>"><%=i+1 %></a></li>
	                    <%} %>
	                    <li><a href="Catalogo?inicio=<%=(numeroComics-1)*12 %>">>></a></li>
	                </ul>
	            </nav>
            </div>
             <%} %>
        </div>
       
        <%@ include file="menu.jsp" %>
        <div class="clear"></div>
        <%@ include file="footer.jsp" %>
    </div>
    