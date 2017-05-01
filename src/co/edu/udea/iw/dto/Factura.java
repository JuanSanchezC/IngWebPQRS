package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * POJO that represents a Factura entity for the table factura
 * @author juan.sanchezc@udea.edu.co
 */
public class Factura {
	private int id;
	private Date fechaVenta;
	private Filial filial;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Filial getFilial() {
		return filial;
	}
	public void setFilial(Filial filial) {
		this.filial = filial;
	}
}
