package cookey.dao;

import java.util.List;

public interface IRecetaDAO<EntidadDTO> {
	public boolean createR(EntidadDTO e);

	public boolean deleteR(Object clave, Object clave2);

	public boolean updateR(EntidadDTO e);
	
	public EntidadDTO readR(String clave, String clave1);

	public List<EntidadDTO> readAllR();
}