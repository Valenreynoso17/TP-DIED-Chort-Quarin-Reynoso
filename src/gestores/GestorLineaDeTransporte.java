package gestores;

import java.util.ArrayList;
import java.util.List;

import clases.CustomColor;
import clases.LineaDeTransporte;
import clases.Ruta;
import clases.Trayecto;
import dao.LineaDeTransporteDAO;
import dao.LineaDeTransporteSQLImp;
import enums.EstadoLineaDeTransporte;
import interfaces.valen.otros.ElementoListaTrayecto;

public class GestorLineaDeTransporte {

	private List<LineaDeTransporte> lineasDeTransporte;
	private static GestorLineaDeTransporte gestor;
	private LineaDeTransporteDAO lineaDAO;
	private static Integer siguienteIdLinea;
	private GestorTrayecto gestorTrayecto;
	
	private GestorLineaDeTransporte() {
		lineaDAO = new LineaDeTransporteSQLImp();
		lineasDeTransporte = new ArrayList<LineaDeTransporte>(lineaDAO.buscar());
		Thread t1 = new Thread(() -> {
			siguienteIdLinea = lineaDAO.getUltimoIdLinea() + 1;
		});
		t1.run();
	}
	
	public static GestorLineaDeTransporte getInstance() {
		
		if (gestor == null) gestor = new GestorLineaDeTransporte();
		
		return gestor;
	}
	
	public List<LineaDeTransporte> getLineasDeTransporte(){		
		return lineasDeTransporte;
	}
	
	public void agregarLineaDeTransporte(String nombreLinea, String estadoLinea, CustomColor colorLinea, List<ElementoListaTrayecto> listaTrayecto) {
		
		LineaDeTransporte lineaAux;
		if (estadoLinea == "Activa") {
			lineaAux = new LineaDeTransporte(siguienteIdLinea, nombreLinea, colorLinea, EstadoLineaDeTransporte.ACTIVA, null);
		} else {
			lineaAux = new LineaDeTransporte(siguienteIdLinea, nombreLinea, colorLinea, EstadoLineaDeTransporte.NO_ACTIVA, null);
		}
		
		lineaDAO.insertar(lineaAux);
		this.lineasDeTransporte.add(lineaAux);
		
		gestorTrayecto = GestorTrayecto.getInstance();
		Trayecto trayectoAux = gestorTrayecto.agregarNuevoTrayecto(siguienteIdLinea, listaTrayecto);
		trayectoAux.asociarLinea(lineaAux);
		
		siguienteIdLinea++;
		
	}
	
	public void borrarLineaDeTransporte(LineaDeTransporte lineaDeTransporte) {
		// Eliminar una linea de la bdd elimina tambien el trayecto asociado y las rutas asociadas
		lineaDAO.eliminar(lineaDeTransporte);
		
		// Sin embargo la linea, el trayecto y las rutas siguen en el sistema
		gestorTrayecto = GestorTrayecto.getInstance();
		gestorTrayecto.eliminarTrayecto(lineaDeTransporte.getTrayecto());
		lineasDeTransporte.remove(lineaDeTransporte);
		
	}
	
	public LineaDeTransporte buscarLineaPorId(Integer idLinea) {
		return (lineasDeTransporte.stream().filter(lt -> lt.getId() == idLinea).findFirst()).get();
	}
}
