package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Factura;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Defines methods to apply over Factura entity
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public interface FacturaDAO {
	/**
	 * Gets a Factura object according to a id
	 * @param id identification of the factura object
	 * @return a factura object
	 * @throws ExceptionHandler manage the error occurred consulting the factura
	 */
	public Factura getById(int id) throws ExceptionHandler;

}
