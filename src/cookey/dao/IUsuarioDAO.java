package cookey.dao;

import java.util.List;

public interface IUsuarioDAO<EntidadDTO> {
	public boolean createU(EntidadDTO e);

	public boolean deleteU(Object clave, Object clave2);

	public boolean updateU(EntidadDTO e);
	
	public EntidadDTO readU(String clave, String clave1);
	
	public EntidadDTO readU(String clave);

	public List<EntidadDTO> readAllU();
}
