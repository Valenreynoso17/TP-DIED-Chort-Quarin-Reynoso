package gestores;

import java.util.ArrayList;
import java.util.List;

import clases.Boleto;
import clases.Estacion;

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
	
}
