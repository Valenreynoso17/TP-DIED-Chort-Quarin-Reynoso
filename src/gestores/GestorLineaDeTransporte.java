package gestores;

import java.util.ArrayList;
import java.util.List;

import clases.LineaDeTransporte;
import dao.LineaDeTransporteDAO;
import dao.LineaDeTransporteSQLImp;

public class GestorLineaDeTransporte {

	private List<LineaDeTransporte> lineasDeTransporte;
	private static GestorLineaDeTransporte gestor;
	private LineaDeTransporteDAO lineaDAO;
	
	private GestorLineaDeTransporte() {
		lineaDAO = new LineaDeTransporteSQLImp();
		lineasDeTransporte = new ArrayList<LineaDeTransporte>(lineaDAO.buscar());
	}
	
	public static GestorLineaDeTransporte getInstance() {
		
		if (gestor == null) gestor = new GestorLineaDeTransporte();
		
		return gestor;
	}
	
	public List<LineaDeTransporte> getLineasDeTransporte(){		
		return lineasDeTransporte;
	}
	
	public void borrarLineaDeTransporte(LineaDeTransporte lineaDeTransporte) {
		lineaDAO.eliminar(lineaDeTransporte);
	}
	
}
