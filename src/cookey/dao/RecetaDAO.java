package cookey.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import cookey.model.receta.RecetaDTO;
import util.Conexion;

public class RecetaDAO implements IRecetaDAO<RecetaDTO> {

	public static final Conexion con = Conexion.crearConexion();
	public static final String SQL_INSERT_RECIPE = "INSERT INTO receta (titulo, descripcion, ingredientes, pasos, duracion, dificultad, imagen, fecha_publi, categoria, usuario_creador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_DELETE_RECIPE = "DELETE FROM receta WHERE titulo = ? AND usuario_creador = ?";
	public static final String SQL_UPDATE_RECIPE = "UPDATE receta SET titulo = ?, descripcion = ?, ingredientes = ?, pasos = ?, duracion = ?, dificultad = ?, imagen = ?, fecha_publi = ?, categoria = ? WHERE titulo = ? AND usuario_creador = ?";
	public static final String SQL_READ_SEARCH = "SELECT * FROM receta WHERE titulo LIKE ?";
	public static final String SQL_READALL_RECIPES = "SELECT * FROM receta";
	public static final String SQL_READALL_RECIPES_USER = "SELECT * FROM receta WHERE usuario_creador = ?";

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
				receta.setCategoria(rs.getString("categoria"));
				
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
				receta.setCategoria(rs.getString("categoria"));
				
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
				receta.setCategoria(rs.getString("categoria"));

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
	public boolean createR(RecetaDTO rece) {

		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_INSERT_RECIPE);

			ps.setString(1, rece.getTitulo());
			ps.setString(2, rece.getDescripcion());
			ps.setString(3, rece.getIngredientes());
			ps.setString(4, rece.getPasos());
			ps.setString(5, rece.getDuracion());
			ps.setString(6, rece.getDificultad());
			ps.setString(7, rece.getImagen());
			ps.setDate(8, rece.getFechaPublicacion());
			ps.setString(9, rece.getCategoria());
			ps.setString(10, rece.getUsuarioCreador());


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
	public boolean deleteR(String tit, String userCrea) {

		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_DELETE_RECIPE);
			ps.setString(1, tit);
			ps.setString(2, userCrea);

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
	public boolean updateR(RecetaDTO rece, String tituloAnt) {

		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_UPDATE_RECIPE);
			
			ps.setString(1, rece.getTitulo());
			ps.setString(2, rece.getDescripcion());
			ps.setString(3, rece.getIngredientes());
			ps.setString(4, rece.getPasos());
			ps.setString(5, rece.getDuracion());
			ps.setString(6, rece.getDificultad());
			ps.setString(7, rece.getImagen());
			ps.setDate(8, rece.getFechaPublicacion());
			ps.setString(9, rece.getCategoria());
			ps.setString(10, tituloAnt);
			ps.setString(11, rece.getUsuarioCreador());

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
