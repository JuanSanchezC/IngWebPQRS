/**
 * 
 */
package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.TipoSolicitud;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Defines methods to apply over TipoSolicitud entity
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public interface TipoSolicitudDAO {
	/**
	 * Gets a TipoSolicitud object according to a name
	 * @param name a name for the tipoSolicitud
	 * @return a TipoSolicitud object
	 * @throws ExceptionHandler manage the error occurred consulting a TipoSolicitud
	 */
	public TipoSolicitud getByName(String name) throws ExceptionHandler;

}
