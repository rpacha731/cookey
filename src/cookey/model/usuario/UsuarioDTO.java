package cookey.model.usuario;

public class UsuarioDTO {
	private String NombreUsuario;
	private String Contrasena;
	private String Avatar;
	private int CantRecetas;
	private float PromCalif;

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return Contrasena;
	}

	public void setContraseña(String contraseña) {
		Contrasena = contraseña;
	}

	public String getAvatar() {
		return Avatar;
	}

	public void setAvatar(String avatar) {
		Avatar = avatar;
	}

	public int getCantRecetas() {
		return CantRecetas;
	}

	public void setCantRecetas(int cantRecetas) {
		CantRecetas = cantRecetas;
	}

	public float getPromCalif() {
		return PromCalif;
	}

	public void setPromCalif(float promCalif) {
		PromCalif = promCalif;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [NombreUsuario=" + NombreUsuario + ", Contraseña=" + Contrasena + ", Avatar=" + Avatar
				+ ", CantRecetas=" + CantRecetas + ", PromCalif=" + PromCalif + "]";
	}

}
