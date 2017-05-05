package co.edu.udea.iw.dto;

/**
 * POJO that representa a TipoModito entity for the table tipoMotivo
 * @author juan.sanchezc@udea.edu.co
 */
public class TipoMotivo {
	private int id;
	private String nombre;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
