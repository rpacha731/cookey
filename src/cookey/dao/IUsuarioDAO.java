package cookey.dao;

public interface IUsuarioDAO<EntidadDTO> {
	public boolean createU(EntidadDTO e);

	public EntidadDTO readU(String clave, String clave1);
}
