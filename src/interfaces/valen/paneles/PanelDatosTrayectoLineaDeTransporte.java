package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.LineaDeTransporte;
import clases.Ruta;
import gestores.GestorTrayecto;

public class PanelDatosTrayectoLineaDeTransporte extends JPanel{
	
	GridBagConstraints gbc;
	GestorTrayecto gestorTrayecto;
	List<ElementoListaEdicionLineaDeTransporte> listaElementos;
	
	public PanelDatosTrayectoLineaDeTransporte(LineaDeTransporte lineaDeTransporte) {
		
		gestorTrayecto = GestorTrayecto.getInstance();
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(2,1,2,1);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		
		// Necesito obtener las rutas que pertenecen al trayecto que esta asociado con la linea de transporte
		List<Ruta> listaRutas = lineaDeTransporte.getTrayecto().getListaRutas();
		listaElementos = new ArrayList<ElementoListaEdicionLineaDeTransporte>();
		
		ElementoListaEdicionLineaDeTransporte elemAux;
		
		for(Ruta unaRuta: listaRutas) {
			elemAux = new ElementoListaEdicionLineaDeTransporte(unaRuta);
			listaElementos.add(elemAux);
			this.add(elemAux, gbc);
		}
		
	}
	
	public List<ElementoListaEdicionLineaDeTransporte> recuperarDatos() {
		return listaElementos;
	}
}
