package com.ipartek.badaboom.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Date;
import java.util.HashMap;

import com.ipartek.badaboom.beans.Categoria;
import com.ipartek.badaboom.beans.Compra;
import com.ipartek.badaboom.beans.Comic;
import com.ipartek.badaboom.beans.Comment;
import com.ipartek.badaboom.beans.Pedido;
import com.ipartek.badaboom.beans.User;

/**
 * @author Administrador
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class BdOperaciones extends BdBase {

	/**
	 * 
	 */
	public BdOperaciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean validarUsuario(String user, String password) {
		boolean correcto = true;
		try {
			String sentenciaSql = "select user,password from user where" + " user='" + user
					+ "' and password='" + password + "'";
			
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			correcto = rs.next();
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Validación de usuario no efectuada correctamente");
			correcto = false;
		}
		return correcto;
	}
	public boolean sesionIniciada(User user){
		
		boolean usuario = false;
		
		if(user !=null){
			usuario = true;
		}
		
		return usuario;
	}
	public List<Categoria> returnCat(){
		String sentenciaSql = "select cod_categoria,nom_categoria from categoria";
		List<Categoria> categorias = null;
		try{
		Statement stmt = conexion.createStatement();
		ResultSet rs = stmt.executeQuery(sentenciaSql);
		boolean hayMas = rs.next();
		Categoria categoria = null;
		categorias = new ArrayList<Categoria>();
		while (hayMas) {
			categoria = new Categoria();
			categoria.setCodigo(rs.getInt(1));
			categoria.setCategoria(rs.getString(2));
			categorias.add(categoria);
			hayMas = rs.next();
		}
		rs.close();
		stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return categorias;
	}
	public boolean insertarUsuario(User u){
		String patron = "yyyy/MM/dd";	    
	    String hoy =new SimpleDateFormat(patron).format(new Date());
		String sentenciaSql = "insert into user (dni,nombre,apellido1,apellido2, direccion, fecha_nacimiento,"
					+" email, user, password, ultima_conexion) values('"+u.getDni() + "', '" + u.getNombre() + "', '"
					+ u.getApellido1() + "', '" + u.getApellido2() + "', '" + u.getDireccion() + "', '"
					+ hoy + "', '" + u.getEmail() + "', '" + u.getUser() + "', '" + u.getPassword() + "', '" + hoy + "')";
		
		try{
			
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(sentenciaSql);
			stmt.close();
			
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public User getUser(String user, String password){
		
		User u = null;
		
		try{
			String sentenciaSql = "select dni,nombre,apellido1,apellido2, direccion, fecha_nacimiento,"
					+" email, user, password, privilegios, imagen, ultima_conexion from user where user = '" + user + "' AND password = '" + password + "'" ;
			
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean usuarioExiste = rs.next();
			if(usuarioExiste){
				u = new User();
				u.setDni(rs.getString(1));
				u.setNombre(rs.getString(2));
				u.setApellido1(rs.getString(3));
				u.setApellido2(rs.getString(4));
				u.setDireccion(rs.getString(5));
				u.setFechaNacimiento(rs.getDate(6));
				u.setEmail(rs.getString(7));
				u.setUser(rs.getString(8));
				u.setPassword(rs.getString(9));
				u.setPrivilegios(rs.getInt(10));
				u.setImagen(rs.getString(11));
				u.setUltima_conexion(rs.getDate(12));
			}
			rs.close();
			stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Consulta de clientes no efectuada correctamente");
				return u;
			}
		
			return u;
		
		
	}
public User getUser(String user){
		
		User u = null;
		
		try{
			String sentenciaSql = "select dni,nombre,apellido1,apellido2, direccion, fecha_nacimiento,"
					+ " email, user, password, privilegios, imagen, ultima_conexion from user where user = '" + user + "'" ;
			
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean usuarioExiste = rs.next();
			if(usuarioExiste){
				u = new User();
				u.setDni(rs.getString(1));
				u.setNombre(rs.getString(2));
				u.setApellido1(rs.getString(3));
				u.setApellido2(rs.getString(4));
				u.setDireccion(rs.getString(5));
				u.setFechaNacimiento(rs.getDate(6));
				u.setEmail(rs.getString(7));
				u.setUser(rs.getString(8));
				u.setPassword(rs.getString(9));
				u.setPrivilegios(rs.getInt(10));
				u.setImagen(rs.getString(11));
				u.setUltima_conexion(rs.getDate(12));
			}
			rs.close();
			stmt.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Consulta de clientes no efectuada correctamente");
				return u;
			}
		
			return u;
		
		
	}

	public List<Comic> getComics(String titulo, String andOr, String autor, int categoria, String orderBy){
		List<Comic> Comics = new ArrayList<Comic>();
		String sentenciaSql ="SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial,"
			+" l.precio, l.stock, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial, l.imagen"
			+" FROM libro l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor "
			+" join editorial e on l.cod_editorial = e.cod_editorial ";
		
		if(categoria>0){
			sentenciaSql +="where c.cod_categoria = '" + categoria + "' and (a.nom_autor like '%" + autor + "%' "+andOr+" l.titulo like '%"+titulo+"%')"; 
		}else{
			sentenciaSql +="where  (a.nom_autor like '%" + autor+ "%' "+andOr+" l.titulo like '%"+titulo+"%')";
		}
		sentenciaSql +=" order by '" + orderBy + "'";
//where c.cod_categoria = 3 and (a.nom_autor like '%poe%' or l.titulo like '%globo%') order by a.nom_autor;"
		
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();
			Comic Comic = null;
			while(hayComic){
				Comic = new Comic();
				Comic.setIsbn(rs.getString(1));
				Comic.setTitulo(rs.getString(2));
				Comic.setAutor(rs.getString(11));
				Comic.setCategoria(rs.getString(9));
				Comic.setEditorial(rs.getString(13));
				Comic.setPrecio(rs.getDouble(6));
				Comic.setStock(rs.getInt(7));
				Comic.setImagen(rs.getString(14));
				Comics.add(Comic);
				
				hayComic = rs.next();
				
			}
		}catch (Exception e) {
			
			e.printStackTrace();// TODO: handle exception
		}
		
		
		return Comics;
		
		
	}
	public int getComicsSize(){
		String sentenciaSql ="select count(*) from libro";
		int numeroComics = 0;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			 while (rs.next()) {
				 numeroComics =  rs.getInt(1);
				 }
			 rs.close();
			 stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return numeroComics;
	}
	public List<Comic> getTodosLosComics(int inicio){
		List<Comic> comics = new ArrayList<Comic>();
		Comic comic = null;
		
		String sentenciaSql ="SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial, l.descripcion, l.imagen, "
			+"l.precio, l.stock, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial"
			+" FROM Libro l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor"
			+" join editorial e on l.cod_editorial = e.cod_editorial order by l.fecha_publicacion limit " + inicio + ",12";
		
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();

			while(hayComic){
				comic = new Comic();
				comic.setIsbn(rs.getString(1));
				comic.setTitulo(rs.getString(2));
				comic.setCategoria(rs.getString(11));
				comic.setAutor(rs.getString(13));
				comic.setEditorial(rs.getString(15));
				comic.setPrecio(rs.getDouble(8));
				comic.setStock(rs.getInt(9));
				comic.setDescripcion(rs.getString(6));
				comic.setImagen(rs.getString(7));
				comic.setCodigoAutor(rs.getInt(3));
				comics.add(comic);
				hayComic = rs.next();
			}
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return comics;
	}
	public Comic getComic(String d){
		Comic Comic = null;
		
		String sentenciaSql = "SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial, "
				+"l.precio, l.stock, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial"
				+" FROM Comic l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor"
				+" join editorial e on l.cod_editorial = e.cod_editorial where l.isbn = '" + d + "'";
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();
			
			while(hayComic){
				Comic = new Comic();
				Comic.setIsbn(rs.getString(1));
				Comic.setTitulo(rs.getString(2));
				Comic.setCategoria(rs.getString(9));
				Comic.setAutor(rs.getString(11));
				Comic.setEditorial(rs.getString(13));
				Comic.setPrecio(rs.getDouble(6));
				Comic.setStock(rs.getInt(7));
				hayComic = rs.next();
				rs.close();
				stmt.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return Comic;
	}
	public int ultimaCompra(){
		
		String sentenciaLastSql = "select id_compra from compra order by id_compra desc limit 1";
		int ultimaEntrada = 1;
		try{
			Statement stmt = conexion.createStatement();		
			ResultSet rs = stmt.executeQuery(sentenciaLastSql);
			boolean lastEntry = rs.next();
			if(!lastEntry){
				return ultimaEntrada;
			}
			while(lastEntry){
				ultimaEntrada = rs.getInt(1)+1;
				lastEntry = rs.next();
			}
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		return ultimaEntrada;
	}
	public void insertarCompra(String dni, java.util.Date fecha){
		String sentenciaSql="insert into compra (dni, fecha_compra) values ('" + dni + "', " + fecha + ")";
		
		
		try{
		Statement stmt = conexion.createStatement();
		stmt.executeUpdate(sentenciaSql);
		stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public List<Comic> getCarrito(Compra compra){
		Map<String, Integer> mapComics = compra.getDetalle();
		Set<String> setIsbns = mapComics.keySet();
		List<Comic> Comics = new ArrayList<Comic>();
		Comic comic = null;
		
		
		String sentenciaSql = "SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial, "
				+"l.precio, l.stock, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial, l.imagen"
				+" FROM libro l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor"
				+" join editorial e on l.cod_editorial = e.cod_editorial where l.isbn IN ('";
		for (String isbn:setIsbns) {
			sentenciaSql += isbn + "', '";
			
		}
		sentenciaSql +="')";
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();
			
			while(hayComic){
				comic = new Comic();
				comic.setIsbn(rs.getString(1));
				comic.setTitulo(rs.getString(2));
				comic.setCategoria(rs.getString(9));
				comic.setAutor(rs.getString(11));
				comic.setEditorial(rs.getString(13));
				comic.setPrecio(rs.getDouble(6));
				comic.setStock(rs.getInt(7));
				comic.setImagen(rs.getString(14));
				Comics.add(comic);
				hayComic = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return Comics;
		
	}
	public int realizarCompra(User u, Compra compra, double precio) throws SQLException{
	    String patron = "yyyy/MM/dd";	    
	    String fechaCadena =new SimpleDateFormat(patron).format(new Date());
	   
	    
	    //Strings para actualizar el stock de todos los Comics del carrito
	    String quitaStockSql = "UPDATE libro l SET l.stock = CASE l.isbn";
	    String quitaWhenSql = " ";
	    String quitaWhereSql = "WHERE l.isbn IN("; 	   
		int counter = 0;
		Map<String, Integer> mapCompras = compra.getDetalle();
		Set<String> setCompras = mapCompras.keySet();
		for (String isbn:setCompras) {				
			quitaWhenSql += "when '" + isbn + "' then l.stock - " + mapCompras.get(isbn) + " ";
			if(counter == 0){
				quitaWhereSql += "'" + isbn + "' ";
			}else{
				quitaWhereSql += ", '" + isbn + "' ";
			}
			counter ++;
		}
		counter=0;
		quitaStockSql += quitaWhenSql + "ELSE l.stock END " + quitaWhereSql + ")";
		
		// Sentencia sql para insertar la compra
		
		String insertarCompraSql ="insert into compra (dni, fecha_compra, precio_final) values ('" + u.getDni() + "', '" + fechaCadena + "', " + precio + ")";		

		//Sentencia sql para insertar los detalles de la compra
		String detallesSql = "insert into detalles_compra (id_compra, isbn, cantidad) values ";

		Integer idInsert = null;
		
		System.out.println("detallesSql " + insertarCompraSql);
		try{
			
			conexion.setAutoCommit(false);			
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(quitaStockSql);
			stmt.executeUpdate(insertarCompraSql);
			

		    ResultSet rs = stmt.getGeneratedKeys();

		    if (rs.next()) {
		    	idInsert = rs.getInt(1);
		    } 
			
			for (String isbn:setCompras) {				
				
				if(counter == 0){
					detallesSql += "(" + idInsert + ", '" + isbn + "', " + mapCompras.get(isbn) + ")";
				}else{
					detallesSql += ", (" + idInsert + ", '" + isbn + "', " + mapCompras.get(isbn) + ")";
				}
				counter ++;
			}
			
			
			stmt.executeUpdate(detallesSql);
			stmt.close();
			
			conexion.commit();
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			conexion.setAutoCommit(true);
		}
		return idInsert;
	
	}
	public Pedido setDetalles(Pedido pedido){
		String sentenciaSql = "SELECT c.id_compra, d.id_compra, d.isbn, d.cantidad, l.titulo, l.precio, l.imagen "
				+ "FROM compra c Join detalles_compra d on c.id_compra = d.id_compra join libro l on d.isbn = l.isbn where c.id_compra = " + pedido.getIdCompra();
		Map<String, Integer> detalles = new HashMap<String, Integer>();
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayPedido = rs.next();		
			while(hayPedido){
				
				
				hayPedido = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return pedido;
	}
	public List<Pedido> getOrders(String dni){
		String sentenciaSql="select c.id_compra, c.dni, c.fecha_compra, c.precio_final from compra c where c.dni = '" + dni + "' order by c.id_compra";
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Pedido pedido = null;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayPedido = rs.next();		
			while(hayPedido){
				
				pedido = new Pedido();
				pedido.setDni(rs.getString(2));
				pedido.setFechaCompra(rs.getDate(3));
				pedido.setIdCompra(rs.getInt(1));
				pedido.setPrecioTotal(rs.getDouble(4));
				pedidos.add(pedido);
				hayPedido = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return pedidos;
	}
	public Date getOrderDate(int id){
		Date orderDate = null;
		String sentenciaSql = " select fecha_compra from compra where id_compra = " + id;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayPedido = rs.next();		
			while(hayPedido){
				orderDate = rs.getDate(1);
				
				hayPedido = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return orderDate;
	}
	public Map<Comic, Integer> getDetalles(int idPedido){
		
		Map<Comic, Integer> detalles = null;
		Comic Comic = null;
		String sentenciaSql = "select c.id_compra, c.dni, c.fecha_compra, l.cod_autor, l.titulo, "
				+ "l.precio, l.isbn, a.nom_autor, u.dni, d.id_compra, d.isbn, d.cantidad from compra c "
				+ "join detalles_compra d on c.id_compra = d.id_compra join libro l on d.isbn = l.isbn "
				+ "join autor a on l.cod_autor = a.cod_autor join user u on c.dni = u.dni "
				+ "where c.id_compra = '" + idPedido + "' order by c.id_compra";
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayDetalle = rs.next();
			detalles = new HashMap<Comic, Integer>();
			while(hayDetalle){
				System.out.println(idPedido);
				Comic = new Comic();
				Comic.setTitulo(rs.getString(5));
				Comic.setAutor(rs.getString(8));
				Comic.setIsbn(rs.getString(7));
				Comic.setPrecio(rs.getInt(6));
				detalles.put(Comic, rs.getInt(12));
				
				hayDetalle = rs.next();
				
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return detalles;
		
	}
	public List<Comic> getnovedades(){
		List<Comic> novedades=new ArrayList<Comic>();
		Comic comic = null;
		
		String sentenciaSql ="SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial, l.descripcion, l.imagen, "
			+"l.precio, l.stock, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial"
			+" FROM Libro l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor"
			+" join editorial e on l.cod_editorial = e.cod_editorial where l.oferta = 1 order by fecha_publicacion";
		
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();

			while(hayComic){
				comic = new Comic();
				comic.setIsbn(rs.getString(1));
				comic.setTitulo(rs.getString(2));
				comic.setCategoria(rs.getString(11));
				comic.setAutor(rs.getString(13));
				comic.setEditorial(rs.getString(15));
				comic.setPrecio(rs.getDouble(8));
				comic.setStock(rs.getInt(9));
				comic.setDescripcion(rs.getString(6));
				comic.setImagen(rs.getString(7));
				novedades.add(comic);
				hayComic = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return novedades;
		
	}
	
	public Comic destacado(){
		Comic c = null;
		int randomNum = ThreadLocalRandom.current().nextInt(0, getComicsSize());
		String sentenciaSql ="select imagen, titulo, descripcion, isbn from libro limit " + randomNum + ", 1";
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();

			while(hayComic){
				c = new Comic();
				c.setImagen(rs.getString(1));
				c.setTitulo(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				c.setIsbn(rs.getString(4));
				hayComic = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return c;
	}
	public Comic detalle(String isbn){
		Comic c = null;
		String sentenciaSql = "SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial, l.descripcion, l.imagen, l.precio, "
				+ "l.stock, l.oferta, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial, l.fecha_publicacion " 
				+ "FROM Libro l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor "
				+ "join editorial e on l.cod_editorial = e.cod_editorial where l.isbn = '" + isbn + "'";
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();

			while(hayComic){
				c = new Comic();
				c.setAutor(rs.getString(14));
				c.setCategoria(rs.getString(12));
				c.setDescripcion(rs.getString(6));
				c.setEditorial(rs.getString(16));
				c.setImagen(rs.getString(7));
				c.setPrecio(rs.getInt(8));
				c.setIsbn(rs.getString(1));
				c.setFecha(rs.getDate(17));
				c.setTitulo(rs.getString(2));
				c.setStock(rs.getInt(9));
				hayComic = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return c;
	}
	public List<Comment> getComments(String column, String param){
		String sentenciaSql = "select c.isbn, c.dni_user, c.comentario, c.fecha, u.dni, u.user, u.imagen, l.titulo, l.isbn from comments c "
				+ "join user u on c.dni_user = u.dni join libro l on c.isbn = l.isbn where " + column + "= '" + param + "' order by c.fecha desc";
		
		List<Comment> comments = new ArrayList<Comment>();
		Comment c = null;
		
		try{
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();
			while(hayComic){
				c = new Comment();
				c.setComment(rs.getString(3));
				c.setFecha(rs.getDate(4));
				c.setImagen(rs.getString(7));
				c.setUsuario(rs.getString(6));	
				c.setIsbn(rs.getString(1));
				c.setTitulo(rs.getString(8));
				comments.add(c);
				hayComic = rs.next();
			}
			rs.close();
			st.close();
		}catch (Exception e) {
			
			e.printStackTrace();// TODO: handle exception
		}
		return comments;
	}
	
	public void insertComment(String dni, String isbn, String comment){
		String patron = "yyyy/MM/dd hh:mm:ss";	    
	    String fechaCadena =new SimpleDateFormat(patron).format(new Date());		
		String sentenciaSql = "insert into comments (isbn, dni_user, comentario, fecha) values ('" + isbn + "', '" + dni + "', '" + comment + "', '" + fechaCadena + "')";
		try{
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(sentenciaSql);
			
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Comic> getFavorites(String dni){
		List<Comic> favorites = new ArrayList<Comic>();
		String sentenciaSql ="SELECT f.isbn, l.imagen, l.isbn, l.titulo FROM favorites f join libro l on f.isbn = l.isbn where f.dni = '" + dni + "'";
		Comic comic = null;
		
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			
			boolean hayComic = rs.next();

			while(hayComic){

				comic = new Comic();
				comic.setIsbn(rs.getString(3));
				comic.setTitulo(rs.getString(4));
				comic.setImagen(rs.getString(2));
				favorites.add(comic);
				hayComic = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return favorites;
	}
	public void updateUser(User u){
		
		String sentenciaSql = "update user set nombre = '" + u.getNombre() + "', apellido1 = '" + u.getApellido1() + "', apellido2 = '" + u.getApellido2() + "', dni='" + u.getDni()
					+ "', direccion = '" + u.getDireccion() + "', email = '" + u.getEmail() + "', password='" + u.getPassword() + "'"
					+ "where user = '" + u.getUser() + "'";
		try{
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(sentenciaSql);			
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Comic> getBusqueda(String col, int param, int inicio){
		List<Comic> categoria=new ArrayList<Comic>();
		Comic comic = null;
		
		String sentenciaSql ="SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial, l.descripcion, l.imagen, "
			+"l.precio, l.stock, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial"
			+" FROM Libro l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor"
			+" join editorial e on l.cod_editorial = e.cod_editorial where " + col + " = " + param + " order by l.fecha_publicacion limit " + inicio + ",12";
		
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();

			while(hayComic){
				comic = new Comic();
				comic.setIsbn(rs.getString(1));
				comic.setTitulo(rs.getString(2));
				comic.setCategoria(rs.getString(11));
				comic.setAutor(rs.getString(13));
				comic.setEditorial(rs.getString(15));
				comic.setPrecio(rs.getDouble(8));
				comic.setStock(rs.getInt(9));
				comic.setDescripcion(rs.getString(6));
				comic.setImagen(rs.getString(7));
				categoria.add(comic);
				hayComic = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return categoria;
	}
	public int getBusquedaSize(String col, int param){
		String sentenciaSql ="select count(*) from libro where " + col + " = '" + param +"'";
		int numeroComics = 0;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			 while (rs.next()) {
				 numeroComics =  rs.getInt(1);
				 }
			 rs.close();
			 stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return numeroComics;
	}
	public int getBusquedaSize(String titulo, String andOr, String autor, int categoria, String orderBy){
		List<Comic> Comics = new ArrayList<Comic>();
		String sentenciaSql ="SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial,"
			+" l.precio, l.stock, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial"
			+" FROM libro l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor "
			+" join editorial e on l.cod_editorial = e.cod_editorial ";
		
		if(categoria>0){
			sentenciaSql +="where c.cod_categoria = '" + categoria + "' and (a.nom_autor like '%" + autor + "%' "+andOr+" l.titulo like '%"+titulo+"%')"; 
		}else{
			sentenciaSql +="where  (a.nom_autor like '%" + autor+ "%' "+andOr+" l.titulo like '%"+titulo+"%')";
		}
		sentenciaSql +=" order by '" + orderBy + "'";
//where c.cod_categoria = 3 and (a.nom_autor like '%poe%' or l.titulo like '%globo%') order by a.nom_autor;"
		int numeroComics = 0;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			 while (rs.next()) {
				 numeroComics =  rs.getInt(1);
				 }
			 rs.close();
			 stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return numeroComics;
	}
	public int getBusquedaSize(String param){
		String sentenciaSql = "SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial, l.descripcion, l.imagen, "
				+"l.precio, l.stock, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial"
				+" FROM Libro l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor"
				+" join editorial e on l.cod_editorial = e.cod_editorial where l.titulo like '%" + param + "%' "
						+ "or a.nom_autor like '%" + param + "%' order by l.fecha_publicacion";
		int numeroComics = 0;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			 while (rs.next()) {
				 numeroComics =  rs.getInt(1);
				 }
			 rs.close();
			 stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return numeroComics;
	}
	
	public Compra getCompra(int id){
		Compra c = new Compra();
		String sentenciaSql = "select id_compra, isbn, cantidad from detalles_compra where id_compra =" +id;
		
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayCompra = rs.next();

			while(hayCompra){
				
				c.addDetalle(rs.getString(2), rs.getInt(3));
				
				hayCompra = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return c;
	}
	public List<Comic> busqueda(String param){
		String sentenciaSql = "SELECT l.isbn, l.titulo, l.cod_autor, l.cod_categoria, l.cod_editorial, l.descripcion, l.imagen, "
			+"l.precio, l.stock, c.cod_categoria, c.nom_categoria, a.cod_autor, a.nom_autor, e.cod_editorial, e.nom_editorial"
			+" FROM Libro l join categoria c on l.cod_categoria = c.cod_categoria join autor a on l.cod_autor = a.cod_autor"
			+" join editorial e on l.cod_editorial = e.cod_editorial where l.titulo like '%" + param + "%' "
					+ "or a.nom_autor like '%" + param + "%' order by l.fecha_publicacion";
		List<Comic> resultados = new ArrayList<Comic>();
		Comic comic = null;
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			boolean hayComic = rs.next();

			while(hayComic){
				comic = new Comic();
				comic.setIsbn(rs.getString(1));
				comic.setTitulo(rs.getString(2));
				comic.setCategoria(rs.getString(11));
				comic.setAutor(rs.getString(13));
				comic.setEditorial(rs.getString(15));
				comic.setPrecio(rs.getDouble(8));
				comic.setStock(rs.getInt(9));
				comic.setDescripcion(rs.getString(6));
				comic.setImagen(rs.getString(7));
				resultados.add(comic);
				hayComic = rs.next();
			}
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return resultados;
	}
	public boolean checkMail(String email){
		boolean mailExists = true;
		String sentenciaSql = "select email from user where email = '" + email + "'";
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			if (!rs.next() ) {
			    mailExists = false;
			} 

			
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
				
		return mailExists;
	}
	public boolean checkUser(String user){
		boolean userExists = true;
		String sentenciaSql = "select user from user where user = '" + user + "'";
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			if (!rs.next() ) {
			    userExists = false;
			} 

			
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
				
		return userExists;
	}
	public boolean checkDni(String dni){
		boolean dniExists = true;
		String sentenciaSql = "select dni from user where dni = '" + dni + "'";
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			if (!rs.next() ) {
			    dniExists = false;
			} 

			
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
				
		return dniExists;
	}
	public void recover(String code, String email){
		String sentenciaSql ="insert into recover (email, code) values ('" + email + "', '" + code + "')";
		try{
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(sentenciaSql);
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
			
	}
	public String getCode(String code){
		String email ="";
		String sentenciaSql = "select email, code from recover where code= '" + code + "'";
		
		try{
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sentenciaSql);
			if (!rs.next() ) {
			    email= rs.getString(1);
			    
			} 

			
			rs.close();
			stmt.close();
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return email;
		
	}
	public boolean updatePassword(String email, String password){
		boolean success = false;
		String sentenciaSql = "update user set password ='" + password +"' where email= '" + email + "'";
		try{
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(sentenciaSql);
			stmt.close();
			success = true;
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return success;
	}
}
















