package gestores;

import java.util.ArrayList;
import java.util.List;
import clases.Ruta;

public class GestorRuta {
	private List<Ruta> rutas;
	private static GestorRuta gestor;
	
	private GestorRuta() {
		rutas = new ArrayList<>();
	}
	
	public static GestorRuta getInstance() {
		if (gestor == null) {
			gestor = new GestorRuta();
		}
		
		return gestor;
	}
	
	public List<Ruta> getRutas() {
		return rutas;
	}
	
}
