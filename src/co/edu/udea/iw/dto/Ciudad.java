/*
*	@author = "Carlos Jiménez"
*/

package co.edu.udea.iw.dto;

//* POJO that represents the ciudad entity in data base.
public class Ciudad {
	private	Long	codigo;
	private	String nombre;
	private	String codigoArea;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
}
