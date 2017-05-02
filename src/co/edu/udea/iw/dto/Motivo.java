package co.edu.udea.iw.dto;

/**
 * POJO that represents a Motivo entity for the table motivo
 * @author juan.sanchezc@udea.edu.co
 */
public class Motivo {
	private int id;
	private String codigo;
	private String nombre;
	private TipoMotivo tipoMotivo;
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	/**
	 * @return the tipoMotivo
	 */
	public TipoMotivo getTipoMotivo() {
		return tipoMotivo;
	}
	/**
	 * @param tipoMotivo the tipoMotivo to set
	 */
	public void setTipoMotivo(TipoMotivo tipoMotivo) {
		this.tipoMotivo = tipoMotivo;
	}
}
