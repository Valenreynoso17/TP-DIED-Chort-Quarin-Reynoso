package interfaces.fede.panelesGrafos;

import java.awt.Graphics2D;
import java.util.List;
import java.util.Set;

import clases.Dibujable;
import clases.Estacion;
import clases.Flecha;
import clases.Recorrido;
import gestores.GestorRecorrido;
import interfaces.fede.otros.GamaColor;

public class PanelSoloEntreOrigenDestino extends PanelPintaSoloVisibles {
	protected Set<Estacion> estRecorridas;
	protected GestorRecorrido gestorRecorridos;
	
	public PanelSoloEntreOrigenDestino(List<Recorrido> recorridos) {
		super(recorridos.get(0).getOrigen(), recorridos.get(0).getDestino());
		
		this.descripcionPantalla = 		"- En esta pantalla se muestran todas las estaciones por las que se puede pasar para ir desde la estacion origen a la estacion destino. Estas dos ultimas se resaltan en otro color.\n"
									+ 	"- Presione una flecha para ver las líneas que tienen ruta entre las estaciones y en la direccion de la flecha.\n"
									+ 	"- Colores de flechas:\n"
									+ 	"		Negra: varias lineas\n"
									+ 	"		Otro color: unica linea. Se muestra su color\n";
		
		gestorRecorridos = GestorRecorrido.getInstance();
		estRecorridas = gestorRecorridos.getEstacionesRecorridas(recorridos);
	}
	
	/*public PanelSoloEntreOrigenDestino(Estacion origen, Estacion destino) {
		super(origen, destino);
		
		gestorRecorridos = GestorRecorrido.getInstance();
		List<Recorrido> recorridos = gestorRecorridos.getRecorridos(origen, destino);
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
				if (d instanceof Estacion) chequearPreferredSize((Estacion) d);
			}
		}
	}
}
