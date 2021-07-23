package clases;

import java.time.LocalDate;

public class Boleto {
	
	private String nroBoleto;
	private String correoCliente;
	private String nombreCliente;
	private LocalDate fechaVenta;
	private double costo;
	
	private Recorrido recorrido;
	
	public Boleto(String nB, String cC, String nC, LocalDate fV, double c, Recorrido r) {
		this.nroBoleto = nB;
		this.correoCliente = cC;
		this.nombreCliente = nC;
		this.fechaVenta = fV;
		this.costo = c;
		this.recorrido = r;
	}

}
