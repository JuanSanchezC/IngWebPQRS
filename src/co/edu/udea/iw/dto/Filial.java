package co.edu.udea.iw.dto;


/**
 * POJO that represent a Filial entity for the table filial
 * @author juan.sanchezc@udea.edu.co
 */
public class Filial {
	private int id;
	private String nombre;
	private String codigo;	
	
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
