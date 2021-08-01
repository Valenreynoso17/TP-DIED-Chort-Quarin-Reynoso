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
	private GestorLineaDeTransporte gestorLinea;
	private TrayectoDAO trayectoDAO;
	
	private GestorTrayecto() {
		trayectoDAO = new TrayectoSQLImp();
		listaTrayectos = new ArrayList<Trayecto>(trayectoDAO.buscar());
	}
	
	public static GestorTrayecto getInstance() {
		
		if (gestor == null) gestor = new GestorTrayecto();
		
		return gestor;
	}
	
	public List<Trayecto> getListaTrayectos(){
		return listaTrayectos;
	}
	
	public Trayecto buscarTrayectoPorId(Integer idTrayecto) {
		return (listaTrayectos.stream().filter(t -> t.getId() == idTrayecto).findFirst()).get();
	}
	
	public void asociarALineas() {
		gestorLinea = GestorLineaDeTransporte.getInstance();
		for(Trayecto unTrayecto : listaTrayectos) {
			LineaDeTransporte auxLinea = (gestorLinea.getLineasDeTransporte().stream().filter(lt -> lt.getId() == unTrayecto.getIdLineaAsociada()).findFirst()).get();
			unTrayecto.asociarLinea(auxLinea);
		}
	}
}
