package co.edu.udea.iw.dto;

/**
 * POJO that represents a Empleado entity for the table empleado
 * @author juan.sanchezc@udea.edu.co
 */
public class Empleado {
	private int id;
	private String nombre;
	private TipoEmpleado tipoEmpleado;
	
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
	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}
	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
}
