package co.edu.udea.iw.dao;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Defines all the methods allowed over entity solicitud
 * @author juan.sanchezc@udea.edu.co
 */
public interface SolicitudDAO {
	/**
	 * Creates a new entry for the table solicitud
	 * @param solicitud Object type Solicitud
	 * @throws ExceptionHandler manage the error occurred when it insert a
	 * new entry for the table solicitud
	 */
	public void createSolicitud(Solicitud solicitud) throws ExceptionHandler;
	
	/**
	 * Gets a Solicitud object according to an id
	 * @param id solicitud identification 
	 * @return Solicitud object 
	 * @throws ExceptionHandler manage the error occurred when it consult the solicitud 
	 */
	public Solicitud getById(int id) throws ExceptionHandler;
	
	/**
	 * gets an object list of type solicitud according to the id of an empleado
	 * @param id identification of an empleado
	 * @return an object list of type solicitud
	 * @throws ExceptionHandler manage the error occurred when it consult the list
	 */
	public List<Solicitud> getByEmpleado(int id) throws ExceptionHandler;
	
	/**
	 * Gets an object list of type solicitud of all the entries from the table solicitud
	 * @return an object list of type solicitud
	 * @throws ExceptionHandler manage the error occurred when it consult the list
	 */
	public List<Solicitud> getALL() throws ExceptionHandler;
	
	/**
	 * Gets the list of solicitud that has not been answered 
	 * @return list of solicitud 
	 * @throws ExceptionHandler manage the error occurred consulting the list
	 */
	public List<Solicitud> getByNoAnswered() throws ExceptionHandler;
	
	/**
	 * Gets the list of solicitud that has been answered 
	 * @return list of solicitud 
	 * @throws ExceptionHandler manage the error occurred consulting the list
	 */
	public List<Solicitud> getByAnswered() throws ExceptionHandler;
	
	/**
	 * Gets a list of solicitud given a date range and name of variable date
	 * @param initDate initial date
	 * @param finDate final date
	 * @param nameDate name of variable date
	 * @return a list of solicitud
	 * @throws ExceptionHandler manage the error occurred consulting the list
	 */
	public List<Solicitud> getByDateRange(Date initDate, Date finDate, String nameDate) throws ExceptionHandler;
	
	/**
	 * Gets a list of solicitud answered given a date range
	 * @param initDate initial date
	 * @param finDate final date
	 * @return a list of solicitud
	 * @throws ExceptionHandler manage the error occurred consulting the list
	 */
	public List<Solicitud> getByDateRangeAnswered(Date initDate, Date finDate) throws ExceptionHandler;
	
	/**
	 * Updates a entry in the table solicitud according to the solicitud object
	 * @param solicitud Object type Solicitud
	 * @throws ExceptionHandler manage the error occurred when it updates an
	 * entry in table solicitud
	 */
	public void updateSolicitud(Solicitud solicitud) throws ExceptionHandler;
}
