package cookey.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import cookey.model.usuario.UsuarioDTO;
import util.Conexion;

public class SocioDAO implements intCRUD<UsuarioDTO> {

	public static final Conexion con = Conexion.crearConexion();
	public static final String SQL_READ_USER = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";
	public static final String SQL_INSERT_USER = "INSERT INTO usuarios (nombre_usuario, contrasena, avatar, cant_recetas, prom_calif) VALUES (?, ?, ?, ?, ?)";
	public static final String SQL_INSERT = "INSERT INTO socios (DNI, Apellido, Actividad, Dias, Costo, Total) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String SQL_DELETE = "DELETE FROM socios WHERE DNI = ? AND Actividad = ?";
	public static final String SQL_UPDATE = "UPDATE socios SET Dias = ?, Costo = ?, Total = ? WHERE DNI = ? AND Actividad = ?";
	public static final String SQL_READ = "SELECT * FROM socios WHERE DNI LIKE ? OR Apellido LIKE ?";
	public static final String SQL_READALL = "SELECT * FROM socios";

	@Override
	public UsuarioDTO readU(String nomUser, String passw) {
		
		UsuarioDTO user = null;

		try {
			
			ResultSet rs = null;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_READ_USER);

			ps.setString(1, nomUser);
			ps.setString(2, passw);

			rs = ps.executeQuery();

			while (rs.next()) {
				user = new UsuarioDTO();
				user.setNombreUsuario(rs.getString("nombre_usuario"));
				user.setContraseña(rs.getString("contrasena"));
				user.setAvatar(rs.getString("avatar"));
				user.setCantRecetas(rs.getInt("cant_recetas"));
				user.setPromCalif(rs.getFloat("prom_calif"));
			}

			return user;

		} catch (SQLException e1) {
			Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return user;
	}
	
	@SuppressWarnings("null")
	@Override
	public boolean createU(UsuarioDTO u) {
		
		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_INSERT_USER);
			ps.setString(1, u.getNombreUsuario());
			ps.setString(2, u.getContraseña());
			ps.setNull(3, 0);
			ps.setNull(4, 0);
			ps.setNull(5, 0);

			control = ps.executeUpdate();
			if (control > 0) {
				return true;
			}

		} catch (SQLException e1) {
			Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean create(UsuarioDTO e) {

		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_INSERT);
			ps.setString(1, e.getDNI());
			ps.setString(2, e.getApellido());
			ps.setString(3, e.getActividad());
			ps.setInt(4, e.getDias());
			ps.setInt(5, e.getCosto());
			ps.setInt(6, e.getTotal());

			control = ps.executeUpdate();
			if (control > 0) {
				return true;
			}

		} catch (SQLException e1) {
			Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean delete(Object DNI, Object Actividad) {

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
			Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean update(UsuarioDTO e) {

		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_UPDATE);

			ps.setInt(1, e.getDias());
			ps.setInt(2, e.getCosto());
			ps.setInt(3, e.getTotal());
			ps.setString(4, e.getDNI());
			ps.setString(5, e.getActividad());

			control = ps.executeUpdate();
			if (control > 0) {
				return true;
			}

		} catch (SQLException e1) {
			Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return false;
	}

	@Override
	public List<UsuarioDTO> read(String DNI, String Apellido) {

		UsuarioDTO socio;
		List<UsuarioDTO> lista = new ArrayList<>();

		try {
			ResultSet rs = null;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_READ);

			ps.setString(1, "%" + DNI + "%");
			ps.setString(2, "%" + Apellido + "%");

			System.out.println("%" + DNI + "%");

			rs = ps.executeQuery();

			while (rs.next()) {
				socio = new UsuarioDTO();
				socio.setDNI(rs.getString("DNI"));
				socio.setApellido(rs.getString("Apellido"));
				socio.setActividad(rs.getString("Actividad"));
				socio.setDias(rs.getInt("Dias"));
				socio.setCosto(rs.getInt("Costo"));
				socio.setTotal(rs.getInt("Total"));
				socio.toString();
				lista.add(socio);
			}

			return lista;

		} catch (SQLException e1) {
			Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return lista;
	}

	@Override
	public List<UsuarioDTO> readAll() {

		UsuarioDTO socio;
		List<UsuarioDTO> lista = new ArrayList<>();

		try {
			ResultSet rs = null;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_READALL);

			rs = ps.executeQuery();
			while (rs.next()) {
				socio = new UsuarioDTO();
				socio.setDNI(rs.getString("DNI"));
				socio.setApellido(rs.getString("Apellido"));
				socio.setActividad(rs.getString("Actividad"));
				socio.setDias(rs.getInt("Dias"));
				socio.setCosto(rs.getInt("Costo"));
				socio.setTotal(rs.getInt("Total"));
				lista.add(socio);
			}

		} catch (SQLException e1) {
			Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return lista;
	}

}
