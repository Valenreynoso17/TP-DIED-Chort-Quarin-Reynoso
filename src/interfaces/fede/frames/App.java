package interfaces.fede.frames;

import java.util.List;

import clases.Estacion;
import gestores.GestorEstacion;

public class App {
	public static void main(String[] args) {
		FrameVentaBoleto.pruebaGrafico();
		GestorEstacion gestor = GestorEstacion.getInstance();
		List<Estacion> estaciones = gestor.getEstaciones();
		FrameVentaBoleto2.crearVentana(null, estaciones.get(0), estaciones.get(1));
	}
}
