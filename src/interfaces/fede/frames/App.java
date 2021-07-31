package interfaces.fede.frames;

import java.util.List;

import clases.Estacion;
import dao.EstacionDAO;
import dao.EstacionPostgreSQLImpl;
import gestores.GestorEstacion;

public class App {
	public static void main(String[] args) {
		EstacionDAO dao = new EstacionPostgreSQLImpl();
		List<Estacion> estacion = dao.buscar();
		
		for (Estacion e : estacion) System.out.println(e.toString());
	}
}
