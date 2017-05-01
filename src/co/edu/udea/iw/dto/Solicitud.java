package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * POJO that represents a Solicitud entity for the table solicitud
 * @author juan.sanchezc@udea.edu.co
 */
public class Solicitud {
	private int id;
	private TipoSolicitud tipoSolicitud;
	private Date fechaCrecion;
	private String descripcion;
	private String correo;
	private String productoServicio;
	private Factura factura;
	private Filial filial;
	private Empleado empleadoAsignado;
	private Date fechaAsignacion;
	private String respuesta;
	private Date fechaRespuesta;
	private int satisfaccion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	public Date getFechaCrecion() {
		return fechaCrecion;
	}
	public void setFechaCrecion(Date fechaCrecion) {
		this.fechaCrecion = fechaCrecion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getProductoServicio() {
		return productoServicio;
	}
	public void setProductoServicio(String productoServicio) {
		this.productoServicio = productoServicio;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Filial getFilial() {
		return filial;
	}
	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	public Empleado getEmpleadoAsignado() {
		return empleadoAsignado;
	}
	public void setEmpleadoAsignado(Empleado empleadoAsignado) {
		this.empleadoAsignado = empleadoAsignado;
	}
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}
	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}
	public int getSatisfaccion() {
		return satisfaccion;
	}
	public void setSatisfaccion(int satisfaccion) {
		this.satisfaccion = satisfaccion;
	}
}
