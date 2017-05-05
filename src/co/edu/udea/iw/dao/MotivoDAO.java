package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Motivo;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Define all method allowed over entity movito
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public interface MotivoDAO {
	/**
	 * Gets a Motivo objecto according to a codigo
	 * @param codigo code of the motivo
	 * @return Motivo object
	 * @throws ExceptionHandler manage the error when a motivo is consulted
	 */
	public Motivo getByCodigo(String codigo) throws ExceptionHandler;

}
