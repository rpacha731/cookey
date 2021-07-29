package cookey.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import cookey.model.usuario.UsuarioDTO;
import util.Conexion;

public class UsuarioDAO implements IUsuarioDAO<UsuarioDTO> {

	public static final Conexion con = Conexion.crearConexion();
	public static final String SQL_READ_USER = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?";
	public static final String SQL_INSERT_USER = "INSERT INTO usuarios (nombre_usuario, contrasena, avatar, cant_recetas, prom_calif) VALUES (?, ?, ?, ?, ?)";

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
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}

		return user;
	}

	@Override
	public boolean createU(UsuarioDTO u) {

		try {
			int control = 0;
			PreparedStatement ps = con.getCnn().prepareCall(SQL_INSERT_USER);
			ps.setString(1, u.getNombreUsuario());
			ps.setString(2, u.getContraseña());
			ps.setString(3, u.getAvatar());
			ps.setNull(4, 0);
			ps.setNull(5, 0);

			control = ps.executeUpdate();
			if (control > 0) {
				return true;
			}

		} catch (SQLException e1) {
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			con.cerrarConexion();
		}
		return false;
	}

}
