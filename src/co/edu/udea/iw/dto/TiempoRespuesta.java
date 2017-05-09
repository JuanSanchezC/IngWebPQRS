package co.edu.udea.iw.dto;

/**
 * Constructs objects with the information necessary about 
 * the solicitud unanswered 
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public class TiempoRespuesta {
	private int id;
	private String tipoSolicitud;
	private int tiempoRespuesta;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the tipoSolicitud
	 */
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}
	/**
	 * @param tipoSolicitud the tipoSolicitud to set
	 */
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	/**
	 * @return the tiempoRespuesta
	 */
	public int getTiempoRespuesta() {
		return tiempoRespuesta;
	}
	/**
	 * @param tiempoRespuesta the tiempoRespuesta to set
	 */
	public void setTiempoRespuesta(int tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}
}
