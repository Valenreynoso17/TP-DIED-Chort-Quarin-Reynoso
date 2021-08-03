package interfaces.fede.frames;

import java.awt.Point;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import clases.Estacion;
import dao.EstacionDAO;
import dao.EstacionPostgreSQLImpl;
import enums.EstadoEstacion;
import gestores.GestorEstacion;

public class App {
	public static void main(String[] args) {
		/*EstacionDAO dao = new EstacionPostgreSQLImpl();
		//dao.modificar(new Estacion(1, "A", LocalTime.now(), LocalTime.now().plusHours(6), new Point(100, 100), EstadoEstacion.EN_MANTENIMIENTO, null));
		List<Estacion> estaciones = dao.buscar();
		
		for (Estacion e : estaciones) {
			e.getPosicion().x += 10;
			e.getPosicion().y += 10;
			
		}
		System.out.println("Empieza actu");
		dao.actualizarPosicion(estaciones);
		
		System.out.println("Termina actu");*/
		Map<Estacion, Estacion> map = new TreeMap<>();
		System.out.println(map.getClass());
	}
}
