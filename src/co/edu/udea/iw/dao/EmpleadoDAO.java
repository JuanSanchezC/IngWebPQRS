package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Defines methods to apply over Empleado entities
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public interface EmpleadoDAO {
	/**
	 * Gets a Empleado objecto given an id
	 * @param id identification of an empleado
	 * @return a Empleado object
	 * @throws ExceptionHandler manage the error occurred consulting the
	 * data base for the empleado
	 */
	public Empleado getById(int id) throws ExceptionHandler;

}
