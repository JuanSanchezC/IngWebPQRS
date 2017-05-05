/**
 * 
 */
package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Filial;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Defines methods to apply over Filial entity
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public interface FilialDAO {
	/**
	 * Gets a Filial object according to a code
	 * @param codigo code of the filial
	 * @return a Filial object
	 * @throws ExceptionHandler manage the error occurred consulting a filial 
	 */
	public Filial getByCodigo(String codigo) throws ExceptionHandler;

}
