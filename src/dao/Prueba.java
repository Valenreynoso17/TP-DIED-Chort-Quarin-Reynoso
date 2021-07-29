package dao;

import java.time.LocalDate;

import clases.Boleto;
import clases.Estacion;
import clases.Recorrido;


public class Prueba {
	public static void main(String[] args) {
		BoletoDAO dao = new BoletoPostgreSQLImpl();
		
		Estacion e1 = new Estacion("1", "A", null, null);
		Estacion e2 = new Estacion("2", "B", null, null);
		Recorrido r1 = new Recorrido(e1, e2, 10, 10, 10.0);
		Boleto boleto = new Boleto(1, "f@gmail.com", "Fede", LocalDate.now(), r1);
		
		dao.insertar(boleto);
	}
}
