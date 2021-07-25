package cookey.model.usuario;

public class UsuarioDTO {
	private String nombreUsuario;
	private String contrasena;
	private String avatar;
	private int cantRecetas;
	private float promCalif;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contrasena;
	}

	public void setContraseña(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getCantRecetas() {
		return cantRecetas;
	}

	public void setCantRecetas(int cantRecetas) {
		this.cantRecetas = cantRecetas;
	}

	public float getPromCalif() {
		return promCalif;
	}

	public void setPromCalif(float promCalif) {
		this.promCalif = promCalif;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [NombreUsuario=" + nombreUsuario + ", Contraseña=" + contrasena + ", Avatar=" + avatar
				+ ", CantRecetas=" + cantRecetas + ", PromCalif=" + promCalif + "]";
	}

}
