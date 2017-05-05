package co.edu.udea.iw.dto;

/**
 * POJO that represents a Empleado entity for the table empleado
 * @author juan.sanchezc@udea.edu.co
 */
public class Empleado {
	private int id;
	private String nombres;
	private String apellidos;
	private String correo;
	private TipoEmpleado tipoEmpleado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}
	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}	
}
