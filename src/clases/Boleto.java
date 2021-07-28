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

}
