package interfaces.fede.panelesGrafos;

import java.awt.Graphics2D;
import java.util.List;
import java.util.Set;

import clases.Dibujable;
import clases.Estacion;
import clases.Flecha;
import clases.Recorrido;
import gestores.GestorRecorrido;

public class PanelSoloEntreOrigenDestino extends PanelPintaSoloVisibles {
	protected Set<Estacion> estRecorridas;
	protected GestorRecorrido gestorRecorridos;
	
	public PanelSoloEntreOrigenDestino(List<Recorrido> recorridos) {
		super(recorridos.get(0).getOrigen(), recorridos.get(0).getDestino());
		
		gestorRecorridos = GestorRecorrido.getInstance();
		estRecorridas = gestorRecorridos.getEstacionesRecorridas(recorridos);
	}
	
	/*public PanelSoloEntreOrigenDestino(Estacion origen, Estacion destino) {
		super(origen, destino);
		
		gestorRecorridos = GestorRecorrido.getInstance();
		estRecorridas = gestorRecorridos.getEstacionesRecorridas(recorridos);
	}*/
	
	@Override
	protected void dibujarGrafo(Graphics2D g2d){
		for (Dibujable d : dibujables) {
			if (estRecorridas.contains(d) 
					|| (d instanceof Flecha && estRecorridas.contains(((Flecha) d).getEstacionOrigen()) 
							&& estRecorridas.contains(((Flecha) d).getEstacionDestino()))) {
				if (d.equals(origen) || d.equals(destino)) ((Estacion) d).dibujarse(g2d, GamaColor.VERDE);
				else d.dibujarse(g2d);
			}
		}
	}
}
