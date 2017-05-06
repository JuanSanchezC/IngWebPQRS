package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.EmpleadoDAO;
import co.edu.udea.iw.dao.FacturaDAO;
import co.edu.udea.iw.dao.FilialDAO;
import co.edu.udea.iw.dao.MotivoDAO;
import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dao.TipoSolicitudDAO;
import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.dto.Factura;
import co.edu.udea.iw.dto.Filial;
import co.edu.udea.iw.dto.Motivo;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.dto.TipoSolicitud;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Implements Bussiness Logic over all entity solicitud methods 
 * @author juan.sanchezc@udea.edu.co
 */
@Transactional
public class SolicitudBL {
	private SolicitudDAO solicitudDAO;
	private MotivoDAO motivoDAO;
	private FilialDAO filialDAO;
	private TipoSolicitudDAO tipoSolicitudDAO;
	private FacturaDAO facturaDAO;
	private EmpleadoDAO empleadoDAO;

	/**
	 * @return the motivoDAO
	 */
	public MotivoDAO getMotivoDAO() {
		return motivoDAO;
	}
	/**
	 * @param motivoDAO the motivoDAO to set
	 */
	public void setMotivoDAO(MotivoDAO motivoDAO) {
		this.motivoDAO = motivoDAO;
	}
	/**
	 * @return the filialDAO
	 */
	public FilialDAO getFilialDAO() {
		return filialDAO;
	}
	/**
	 * @param filialDAO the filialDAO to set
	 */
	public void setFilialDAO(FilialDAO filialDAO) {
		this.filialDAO = filialDAO;
	}
	/**
	 * @return the tipoSolicitudDAO
	 */
	public TipoSolicitudDAO getTipoSolicitudDAO() {
		return tipoSolicitudDAO;
	}
	/**
	 * @param tipoSolicitudDAO the tipoSolicitudDAO to set
	 */
	public void setTipoSolicitudDAO(TipoSolicitudDAO tipoSolicitudDAO) {
		this.tipoSolicitudDAO = tipoSolicitudDAO;
	}
	/**
	 * @return the facturaDAO
	 */
	public FacturaDAO getFacturaDAO() {
		return facturaDAO;
	}
	/**
	 * @param facturaDAO the facturaDAO to set
	 */
	public void setFacturaDAO(FacturaDAO facturaDAO) {
		this.facturaDAO = facturaDAO;
	}
	/**
	 * @return the solicitudDAO
	 */
	public SolicitudDAO getSolicitudDAO() {
		return solicitudDAO;
	}
	/**
	 * @param solicitudDAO the solicitudDAO to set
	 */
	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}	
	/**
	 * @return the empleadoDAO
	 */
	public EmpleadoDAO getEmpleadoDAO() {
		return empleadoDAO;
	}
	/**
	 * @param empleadoDAO the empleadoDAO to set
	 */
	public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}
	
	/**
	 * Creates a new solicitud in the system
	 * @param nameTipoSolicitud
	 * @param fechaSuceso
	 * @param codigoFilial
	 * @param descripcion
	 * @param correo
	 * @param codigoMotivo
	 * @param numfactura
	 * @throws ExceptionHandler manage the error in validations params
	 */
	public void createSolicitud(String nameTipoSolicitud, Date fechaSuceso, 
			String codigoFilial, String descripcion, String correo, 
			String codigoMotivo, String numfactura) throws ExceptionHandler{
		Motivo motivo;
		Factura factura;
		Filial filial;
		TipoSolicitud tipoSolicitud;
		Empleado empleadoAsignado;
		Solicitud solicitud;
		
		if(nameTipoSolicitud.equals(null) && nameTipoSolicitud.isEmpty()){
			throw new ExceptionHandler("Los campos marcados con asterisco no pueden estar vacios");
		}
		if(fechaSuceso.equals(null)){
			throw new ExceptionHandler("Los campos marcados con asterisco no pueden estar vacios");
		}
		if(codigoFilial.equals(null) || codigoFilial.isEmpty()){
			throw new ExceptionHandler("Los campos marcados con asterisco no pueden estar vacios");
		}
		if(descripcion.equals(null) || descripcion.isEmpty()){
			throw new ExceptionHandler("Los campos marcados con asterisco no pueden estar vacios");
		}
		if(correo.equals(null) || correo.isEmpty()){
			throw new ExceptionHandler("Los campos marcados con asterisco no pueden estar vacios");
		}
		if(codigoMotivo.equals(null) || codigoMotivo.isEmpty()){
			throw new ExceptionHandler("Los campos marcados con asterisco no pueden estar vacios");
		}	
		if(validateEmail(correo)){
			throw new ExceptionHandler("Correo no valido");
		}
		
		motivo = motivoDAO.getByCodigo(codigoMotivo);
		if(motivo.getTipoMotivo().getId() == 2){
			if(numfactura.equals(null) || numfactura.isEmpty()){
				throw new ExceptionHandler("Debe proporcionar el número de factura");
			}
			else if(isInteger(numfactura)){
				factura = facturaDAO.getById(Integer.parseInt(numfactura));
				if(factura.equals(null)){
					throw new ExceptionHandler("Factura proporcionada no valida");
				}
			}
			else{
				throw new ExceptionHandler("Factura proporcionada no valida");
			}			
		}
		else{
			factura = null;
		}
		
		filial = filialDAO.getByCodigo(codigoFilial);
		tipoSolicitud = tipoSolicitudDAO.getByName(nameTipoSolicitud);
		empleadoAsignado = new Empleado();
		empleadoAsignado.setId(1);
		
		solicitud = new Solicitud();
		solicitud.setFechaCreacion(new Date());
		solicitud.setFechaSuceso(fechaSuceso);
		solicitud.setDescripcion(descripcion);
		solicitud.setCorreo(correo);
		solicitud.setMotivo(motivo);
		solicitud.setFactura(factura);
		solicitud.setFilial(filial);
		solicitud.setTipoSolicitud(tipoSolicitud);
		solicitud.setEmpleadoAsignado(empleadoAsignado);
		solicitud.setFechaAsignacion(new Date());
		solicitudDAO.createSolicitud(solicitud);
	}
	
	/**
	 * Gets a Solicitud object given an id
	 * @param id
	 * @return a Solcitud object
	 * @throws ExceptionHandler manage error occurred consulting solicitud
	 */
	public Solicitud getById(int id) throws ExceptionHandler{
		return solicitudDAO.getById(id);
	}
	
	/**
	 * Gets a list of solicitud given an empleado id
	 * @param idEmpleado identification of an empleado
	 * @return list of solicitudes
	 * @throws ExceptionHandler manage the error occurred consulting solicitud
	 */
	public List<Solicitud> getByEmpleado(int idEmpleado) throws ExceptionHandler{
		return solicitudDAO.getByEmpleado(idEmpleado);
	}
	
	/**
	 * Makes a response for a solicitud
	 * @param id identification of a solicitud
	 * @param respuesta response to make
	 * @throws ExceptionHandler manage the error occurred updating a solicitud
	 */
	public void makeRespuesta(int id, String respuesta) throws ExceptionHandler{
		Solicitud solicitud = solicitudDAO.getById(id);
		solicitud.setRespuesta(respuesta);
		solicitudDAO.updateSolicitud(solicitud);
		sendEmail(id);
	}
	
	/**
	 * Asigns a Solicitud to an Empleado
	 * @param id identification of Solicitud
	 * @param idEmpleado identification of Empleado
	 * @throws ExceptionHandler manage the error occurred updating the Solicitud
	 */
	public void asignSolicitud(int id, int idEmpleado) throws ExceptionHandler{
		Solicitud solicitud = solicitudDAO.getById(id);
		Empleado empleadoAsignado = empleadoDAO.getById(idEmpleado);
		solicitud.setEmpleadoAsignado(empleadoAsignado);
		solicitudDAO.updateSolicitud(solicitud);		
	}
	
	/**
	 * Send a message to email associated to a solicitud 
	 * @param id identification of a solicitud
	 * @throws ExceptionHandler manage the error occurred sending an email
	 */
	public void sendEmail(int id) throws ExceptionHandler{
		Solicitud solicitud = solicitudDAO.getById(id);
		//String correo = solicitud.getCorreo();
		String correo = "estudianteingwebudea@gmail.com";
		String respuesta = solicitud.getRespuesta();
		String content = construcRespuesta(id, respuesta);
		SendMailTLS sender = new SendMailTLS();
		sender.sendEmail(correo, content);
	}
	
	/**
	 * Sets the satisfaccion of a solicitud
	 * @param id identificacion of a solicitud
	 * @param satisfaccion satisfaccion qualification to set
	 * @throws ExceptionHandler manage the error occurred updating the solicitud
	 */
	public void setSatisfaccion(int id, int satisfaccion) throws ExceptionHandler{
		Solicitud solicitud = solicitudDAO.getById(id);
		solicitud.setSatisfaccion(satisfaccion);
		solicitudDAO.updateSolicitud(solicitud);
	}
	
	/**
	 * Gets the solicitud list unanswered 
	 * @return a solicitud list
	 * @throws ExceptionHandler manage the error occurred consulting the list
	 */
	public List<Solicitud> getByNoAnswered() throws ExceptionHandler{
		return solicitudDAO.getByNoAnswered();
	}
	
	/**
	 * Gets the solicitud list answered 
	 * @return a solicitud list
	 * @throws ExceptionHandler manage the error occurred consulting the list
	 */
	public List<Solicitud> getByAnswered() throws ExceptionHandler{
		return solicitudDAO.getByAnswered();
	}
	
	/**
	 * Validate that a string have a correo syntax
	 * @param email string to validate
	 * @return true if email have a correct syntax or false
	 * in other case 
	 */
	private boolean validateEmail(String email){
		String expression = "[A-Za-z]+@+[A-Za-z]+\\.+[A-Za-z]{2,4}+$";
		Pattern p = Pattern.compile(expression);
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	/**
	 * Validate that a string can be convert to a int
	 * @param s string to validate
	 * @return true or false
	 */
	private boolean isInteger(String s){
		try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Constructs a response of a solicitud to send via email
	 * given an identification a response 
	 * @param id identification of a solicitud
	 * @param respuesta response of a solicitud
	 * @return html message to send via email
	 */
	private String construcRespuesta(int id, String respuesta){
		String content = "<p><strong>Hola</strong></p>"+
				"<p>"+respuesta+"</p>"+
				"<p><a href=\"http://localhost:8080/pqrs/servlets/calificacion/?id="+id+"\""+
				" target=\"_blank\">Encuesta de Satisfacci&oacute;n</a></p>";
		return content;
	}
}
