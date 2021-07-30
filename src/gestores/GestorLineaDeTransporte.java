package gestores;

import java.util.ArrayList;
import java.util.List;

import clases.LineaDeTransporte;
import dao.LineaDeTransporteDAO;
import dao.LineaDeTransporteSQLImp;

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
	
	// TODO: no se si se hace asi
	public List<LineaDeTransporte> getLineasDeTransporte(){
		
		LineaDeTransporteDAO lineaDAO = new LineaDeTransporteSQLImp();
		lineasDeTransporte = lineaDAO.buscar();
		
		return lineasDeTransporte;
	}
	
}
