package gestores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import clases.CustomColor;
import clases.LineaDeTransporte;
import dao.CustomColorDAO;
import dao.CustomColorSQLImp;
import dao.LineaDeTransporteDAO;
import dao.LineaDeTransporteSQLImp;

public class GestorColor {
	private List<CustomColor> listaColores;
	private static GestorColor gestor;
	private CustomColorDAO customColorDAO;
	
	private GestorColor() {
		customColorDAO = new CustomColorSQLImp();
		listaColores = new ArrayList<CustomColor>(customColorDAO.buscar());
		listaColores.add(0, new CustomColor(-1, "Ninguno", 255, 255, 255));		
	}
	
	public static GestorColor getInstance() {
		
		if (gestor == null) gestor = new GestorColor();
		
		return gestor;
	}
	
	public List<CustomColor> getColores(){
		return listaColores;
	}
	
	public CustomColor buscarColorPorNombre(String nom) {
		Optional<CustomColor> occ = (listaColores.stream().filter(e -> e.getNombre().equals(nom)).findFirst());
		return occ.get();
	}
}
