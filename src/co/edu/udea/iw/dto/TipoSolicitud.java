package co.edu.udea.iw.dto;

/**
 * POJO that represents a TipoSolicitud entity for the table tipoSolicitud
 * @author juan.sanchezc@udea.edu.co
 */
public class TipoSolicitud {
	private int id;
	private String nombre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
