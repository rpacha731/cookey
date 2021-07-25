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

	public String getContrase�a() {
		return Contrasena;
	}

	public void setContrase�a(String contrase�a) {
		Contrasena = contrase�a;
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
		return "UsuarioDTO [NombreUsuario=" + NombreUsuario + ", Contrase�a=" + Contrasena + ", Avatar=" + Avatar
				+ ", CantRecetas=" + CantRecetas + ", PromCalif=" + PromCalif + "]";
	}

}
