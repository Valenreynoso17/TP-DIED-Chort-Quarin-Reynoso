package gestores;

import java.util.ArrayList;
import java.util.List;

import clases.LineaDeTransporte;
import clases.Trayecto;
import dao.LineaDeTransporteDAO;
import dao.LineaDeTransporteSQLImp;
import dao.TrayectoDAO;
import dao.TrayectoSQLImp;

public class GestorTrayecto {
	private List<Trayecto> listaTrayectos;
	private static GestorTrayecto gestor;
	private TrayectoDAO trayectoDAO;
	
	private GestorTrayecto() {
		listaTrayectos = new ArrayList<Trayecto>();
		trayectoDAO = new TrayectoSQLImp();
	}
	
	public static GestorTrayecto getInstance() {
		
		if (gestor == null) gestor = new GestorTrayecto();
		
		return gestor;
	}
	
	public Trayecto buscarTrayectoPorIdLinea(Integer idLinea) {
		trayectoDAO.buscarTrayectoPorIdLinea(idLinea);
		
		return null;
	}
}
