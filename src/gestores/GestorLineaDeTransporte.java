package gestores;

import java.util.ArrayList;
import java.util.List;

import clases.LineaDeTransporte;

public class GestorLineaDeTransporte {

	private List<LineaDeTransporte> lineasDeTransporte;
	private static GestorLineaDeTransporte gestor;
	
	private GestorLineaDeTransporte() {
		lineasDeTransporte = new ArrayList<LineaDeTransporte>();
	}
	
	public static GestorLineaDeTransporte getInstance() {
		
		if (gestor == null) gestor = new GestorLineaDeTransporte();
		
		return gestor;
	}
	
	public List<LineaDeTransporte> getLineasDeTransporte(){
		return lineasDeTransporte;
	}
	
}
