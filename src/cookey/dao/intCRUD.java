
package cookey.dao;

import java.util.List;

public interface intCRUD<EntidadDTO> {
	public boolean create(EntidadDTO e);

	public boolean delete(Object clave, Object clave2);

	public boolean update(EntidadDTO e);
	
	public EntidadDTO readU(String clave, String clave1);
	
	public boolean createU(EntidadDTO e);

	public List<EntidadDTO> read(String clave, String clave2);

	public List<EntidadDTO> readAll();

}
