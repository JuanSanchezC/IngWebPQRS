package co.edu.udea.iw.dto;

import java.io.Serializable;

public class DireccionId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private Cliente cliente;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
