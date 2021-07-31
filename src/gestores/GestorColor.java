package gestores;

import java.util.ArrayList;
import java.util.List;

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
	}
	
	public static GestorColor getInstance() {
		
		if (gestor == null) gestor = new GestorColor();
		
		return gestor;
	}
	
	public List<CustomColor> getColores(){
		return listaColores;
	}
}
