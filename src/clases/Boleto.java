package clases;

import java.time.LocalDate;

public class Boleto {
	
	private Integer nroBoleto;
	private String correoCliente;
	private String nombreCliente;
	private LocalDate fechaVenta;
	
	private Recorrido recorrido;
	
	public Boleto(Integer nroBoleto, String correoCliente, String nombreCliente, LocalDate fechaVenta, Recorrido recorrido) {
		this.nroBoleto = nroBoleto;
		this.correoCliente = correoCliente;
		this.nombreCliente = nombreCliente;
		this.fechaVenta = fechaVenta;
		this.recorrido = recorrido;
	}

	public Integer getNroBoleto() {
		return nroBoleto;
	}

	public void setNroBoleto(Integer nroBoleto) {
		this.nroBoleto = nroBoleto;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	
	

}
