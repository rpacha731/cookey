package cookey.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cookey.model.receta.RecetaDTO;
import util.Conexion;

public class RecetaDAO implements IRecetaDAO<RecetaDTO> {

	public static final Conexion con = Conexion.crearConexion();
	public static final String SQL_READ_USER = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";
	public static final String SQL_INSERT_USER = "INSERT INTO usuarios (nombre_usuario, contrasena, avatar, cant_recetas, prom_calif) VALUES (?, ?, ?, ?, ?)";
	public static final String SQL_INSERT = "INSERT INTO socios (DNI, Apellido, Actividad, Dias, Costo, Total) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String SQL_DELETE = "DELETE FROM socios WHERE DNI = ? AND Actividad = ?";
	public static final String SQL_UPDATE = "UPDATE socios SET Dias = ?, Costo = ?, Total = ? WHERE DNI = ? AND Actividad = ?";
	public static final String SQL_READ = "SELECT * FROM socios WHERE DNI LIKE ? OR Apellido LIKE ?";
	public static final String SQL_READ_SEARCH = "SELECT titulo, descripcion, ingredientes, pasos, duracion, dificultad, imagen, comentarios, megustas, calificacion, fecha_publi, usuario_creador, nombre_categoria FROM receta r INNER JOIN categoria c ON r.idcategoria = c.idcategoria WHERE titulo LIKE ?";
	public static final String SQL_READALL_RECIPES = "SELECT titulo, descripcion, ingredientes, pasos, duracion, dificultad, imagen, comentarios, megustas, calificacion, fecha_publi, usuario_creador, nombre_categoria FROM receta r INNER JOIN categoria c ON r.idcategoria = c.idcategoria";
	public static final String SQL_READALL_RECIPES_USER = "SELECT titulo, descripcion, ingredientes, pasos, duracion, dificultad, imagen, comentarios, megustas, calificacion, fecha_publi, usuario_creador, nombre_categoria FROM receta r INNER JOIN categoria c ON r.idcategoria = c.idcategoria WHERE usuario_creador = ?";

	@Override
	public List<RecetaDTO> buscarR(String crite) {
		RecetaDTO receta;
		List<RecetaDTO> lista = new ArrayList<>();
		
		try {
			ResultSet rs = null;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_READ_SEARCH);
			
			ps.setString(1, "%" + crite + "%");

			rs = ps.executeQuery();
			while (rs.next()) {

				receta = new RecetaDTO();
				receta.setTitulo(rs.getString("titulo"));
				receta.setDescripcion(rs.getString("descripcion"));
				receta.setIngredientes(rs.getString("ingredientes"));
				receta.setPasos(rs.getString("pasos"));
				receta.setDuracion(rs.getTime("duracion").toString());
				receta.setDificultad(rs.getString("dificultad"));
				receta.setImagen(rs.getString("imagen"));
				
				receta.setMegustas(rs.getInt("megustas"));
				receta.setCalificacion(rs.getFloat("calificacion"));
				receta.setFechaPublicacion(rs.getDate("fecha_publi"));
				receta.setUsuarioCreador(rs.getString("usuario_creador"));
				receta.setCategoria(rs.getString("nombre_categoria"));
				
				lista.add(receta);
			}

		} catch (SQLException e1) {
			Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return lista;
	}
	
	@Override
	public List<RecetaDTO> readRecUser(String nomUsuario) {
		
		RecetaDTO receta;
		List<RecetaDTO> lista = new ArrayList<>();
		
		try {
			ResultSet rs = null;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_READALL_RECIPES_USER);
			
			ps.setString(1, nomUsuario);

			rs = ps.executeQuery();
			while (rs.next()) {

				receta = new RecetaDTO();
				receta.setTitulo(rs.getString("titulo"));
				receta.setDescripcion(rs.getString("descripcion"));
				receta.setIngredientes(rs.getString("ingredientes"));
				receta.setPasos(rs.getString("pasos"));
				receta.setDuracion(rs.getTime("duracion").toString());
				receta.setDificultad(rs.getString("dificultad"));
				receta.setImagen(rs.getString("imagen"));
				
				receta.setMegustas(rs.getInt("megustas"));
				receta.setCalificacion(rs.getFloat("calificacion"));
				receta.setFechaPublicacion(rs.getDate("fecha_publi"));
				receta.setUsuarioCreador(nomUsuario);
				receta.setCategoria(rs.getString("nombre_categoria"));
				
				lista.add(receta);
			}

		} catch (SQLException e1) {
			Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return lista;
	}

	@Override
	public List<RecetaDTO> readAllR() {

		RecetaDTO receta;
		List<RecetaDTO> lista = new ArrayList<>();

		try {
			ResultSet rs = null;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_READALL_RECIPES);

			rs = ps.executeQuery();
			while (rs.next()) {

				receta = new RecetaDTO();
				receta.setTitulo(rs.getString("titulo"));
				receta.setDescripcion(rs.getString("descripcion"));
				receta.setIngredientes(rs.getString("ingredientes"));
				receta.setPasos(rs.getString("pasos"));
				receta.setDuracion(rs.getTime("duracion").toString());
				receta.setDificultad(rs.getString("dificultad"));
				receta.setImagen(rs.getString("imagen"));
				
				receta.setMegustas(rs.getInt("megustas"));
				receta.setCalificacion(rs.getFloat("calificacion"));
				receta.setFechaPublicacion(rs.getDate("fecha_publi"));
				receta.setUsuarioCreador(rs.getString("usuario_creador"));
				receta.setCategoria(rs.getString("nombre_categoria"));

				lista.add(receta);
			}

		} catch (SQLException e1) {
			Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return lista;
	}

	@Override
	public RecetaDTO readR(String nomUser, String passw) {

		RecetaDTO user = null;

		try {

			ResultSet rs = null;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_READ_USER);

			ps.setString(1, nomUser);
			ps.setString(2, passw);

			rs = ps.executeQuery();

			while (rs.next()) {
				/*
				 * user = new UsuarioDTO();
				 * user.setNombreUsuario(rs.getString("nombre_usuario"));
				 * user.setContraseña(rs.getString("contrasena"));
				 * user.setAvatar(rs.getString("avatar"));
				 * user.setCantRecetas(rs.getInt("cant_recetas"));
				 * user.setPromCalif(rs.getFloat("prom_calif"));
				 */
			}

			return user;

		} catch (SQLException e1) {
			Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return user;
	}

	@SuppressWarnings("null")
	@Override
	public boolean createR(RecetaDTO u) {

		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_INSERT_USER);
			/*
			 * ps.setString(1, u.getNombreUsuario()); ps.setString(2, u.getContraseña());
			 */
			ps.setNull(3, 0);
			ps.setNull(4, 0);
			ps.setNull(5, 0);

			control = ps.executeUpdate();
			if (control > 0) {
				return true;
			}

		} catch (SQLException e1) {
			Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}
		return false;
	}

	// SIN IMPLEMENTAR

	@Override
	public boolean deleteR(Object DNI, Object Actividad) {

		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_DELETE);
			ps.setString(1, (String) DNI);
			ps.setString(2, (String) Actividad);

			control = ps.executeUpdate();
			if (control > 0) {
				return true;
			}

		} catch (SQLException e1) {
			Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean updateR(RecetaDTO e) {

		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_UPDATE);

			/*
			 * ps.setInt(1, e.getDias()); ps.setInt(2, e.getCosto()); ps.setInt(3,
			 * e.getTotal()); ps.setString(4, e.getDNI()); ps.setString(5,
			 * e.getActividad());
			 */

			control = ps.executeUpdate();
			if (control > 0) {
				return true;
			}

		} catch (SQLException e1) {
			Logger.getLogger(RecetaDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return false;
	}

}
