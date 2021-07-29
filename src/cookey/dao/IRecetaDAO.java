package cookey.dao;

import java.util.List;

public interface IRecetaDAO<EntidadDTO> {
	public boolean createR(EntidadDTO e);

	public boolean deleteR(String clave, String clave2);

	public boolean updateR(EntidadDTO e);
	
	public List<EntidadDTO> readRecUser(String clave);
	
	public List<EntidadDTO> buscarR(String clave);

	public List<EntidadDTO> readAllR();
}