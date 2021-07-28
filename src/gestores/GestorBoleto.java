package gestores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.Boleto;
import clases.Estacion;
import clases.Recorrido;

public class GestorBoleto {
	private static GestorBoleto gestor;
	private List<Boleto> boletos;
	
	private GestorBoleto() {
		boletos= new ArrayList<>();
	}
	
	public static GestorBoleto getInstance() {
		if (gestor == null) {
			gestor = new GestorBoleto();
		}
		
		return gestor;
	}
	
	public Integer getSiguienteNroBoleto() {
		return 100;
	}
	
	public void crearBoleto(Integer nroBoleto, String correoCliente, String nombreCliente, LocalDate fechaVenta, Recorrido recorrido) {
		boletos.add(new Boleto(nroBoleto, correoCliente, nombreCliente, fechaVenta, recorrido));
	}
	
}
