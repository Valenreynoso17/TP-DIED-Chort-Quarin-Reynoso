package gestores;

import java.util.ArrayList;
import java.util.List;

import clases.LineaDeTransporte;
import clases.Ruta;
import clases.Trayecto;
import dao.LineaDeTransporteDAO;
import dao.LineaDeTransporteSQLImp;
import dao.TrayectoDAO;
import dao.TrayectoSQLImp;
import interfaces.valen.otros.ElementoListaTrayecto;

public class GestorTrayecto {
	private List<Trayecto> listaTrayectos;
	private static GestorTrayecto gestor;
	private GestorLineaDeTransporte gestorLinea;
	private TrayectoDAO trayectoDAO;
	private static Integer siguienteIdTrayecto;
	
	private GestorTrayecto() {
		trayectoDAO = new TrayectoSQLImp();
		listaTrayectos = new ArrayList<Trayecto>(trayectoDAO.buscar());
		Thread t1 = new Thread(() -> {
			siguienteIdTrayecto = trayectoDAO.getUltimoIdTrayecto() + 1;
		});
		t1.run();
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
	
	public Trayecto agregarNuevoTrayecto(Integer idLinea, List<ElementoListaTrayecto> listaTrayecto) {
		
		Trayecto trayectoAux = new Trayecto(siguienteIdTrayecto, idLinea, null);
		
		trayectoDAO.insertar(trayectoAux);
		this.listaTrayectos.add(trayectoAux);
		
		GestorRuta gestorRuta = GestorRuta.getInstance();
		List<Ruta> listaAux = gestorRuta.agregarRutas(siguienteIdTrayecto, listaTrayecto, trayectoAux);	
		trayectoAux.asociarRutas(listaAux);
		
		siguienteIdTrayecto++;
		
		return trayectoAux;
	}
	
	public void eliminarTrayecto(Trayecto unTrayecto) {
		GestorRuta gestorRuta = GestorRuta.getInstance();
		gestorRuta.eliminarRutas(unTrayecto.getListaRutas());
		this.listaTrayectos.remove(unTrayecto);
	}
}
