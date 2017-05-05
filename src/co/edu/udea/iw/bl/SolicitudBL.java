package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.transaction.annotation.Transactional;

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
}
