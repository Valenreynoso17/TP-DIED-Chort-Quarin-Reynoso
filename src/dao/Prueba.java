package dao;

import java.time.LocalDate;
import java.time.LocalTime;

import clases.Boleto;
import clases.Estacion;
import clases.Recorrido;
import enums.EstadoEstacion;


public class Prueba {
	public static void main(String[] args) {
		BoletoDAO dao = new BoletoPostgreSQLImpl();
		EstacionDAO daoEstacion = new EstacionPostgreSQLImpl();
		
		Estacion e1 = new Estacion(12, "A", LocalTime.of(8, 10), LocalTime.of(10, 20), EstadoEstacion.OPERATIVA);
		Estacion e2 = new Estacion(13, "B", LocalTime.of(8, 10), LocalTime.of(11, 20), EstadoEstacion.OPERATIVA);
		Recorrido r1 = new Recorrido(e1, e2, 10, 10, 10.0);
		Boleto boleto = new Boleto(1, "f@gmail.com", "Fede", LocalDate.now(), r1);
		
		//dao.insertar(boleto);
		//daoEstacion.insertar(e1);
		daoEstacion.eliminar(e1);
		System.out.println(daoEstacion.buscar());
	}
}
