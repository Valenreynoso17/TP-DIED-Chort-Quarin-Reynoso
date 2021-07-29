package gestores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.Boleto;
import clases.Estacion;
import clases.Recorrido;
import dao.BoletoDAO;
import dao.BoletoPostgreSQLImpl;

public class GestorBoleto {
	private static GestorBoleto gestor;
	private BoletoDAO dao;
	private List<Boleto> boletos;
	private static Integer siguienteNroBoleto;
	
	private GestorBoleto() {
		boletos = new ArrayList<>();
		dao = new BoletoPostgreSQLImpl();
		siguienteNroBoleto = dao.getUltimoNroBoleto() + 1;
	}
	
	public static GestorBoleto getInstance() {
		if (gestor == null) {
			gestor = new GestorBoleto();
		}
		
		return gestor;
	}
	
	
	public static Integer getSiguienteNroBoleto() {
		return siguienteNroBoleto;
	}
	
	public void cargarBoleto(Integer nroBoleto, String correoCliente, String nombreCliente, LocalDate fechaVenta, Recorrido recorrido) {
		//boletos.add(new Boleto(nroBoleto, correoCliente, nombreCliente, fechaVenta, recorrido));
		dao.insertar(new Boleto(nroBoleto, correoCliente, nombreCliente, fechaVenta, recorrido));
		siguienteNroBoleto++;
	}
	
}
