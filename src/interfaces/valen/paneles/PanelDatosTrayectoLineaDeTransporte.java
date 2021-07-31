package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
//		List<Ruta> listaRutas = gestorTrayecto.();
		
		ElementoListaEdicionLineaDeTransporte e1 = new ElementoListaEdicionLineaDeTransporte();
		ElementoListaEdicionLineaDeTransporte e2 = new ElementoListaEdicionLineaDeTransporte();
		ElementoListaEdicionLineaDeTransporte e3 = new ElementoListaEdicionLineaDeTransporte();
		ElementoListaEdicionLineaDeTransporte e4 = new ElementoListaEdicionLineaDeTransporte();
		ElementoListaEdicionLineaDeTransporte e5 = new ElementoListaEdicionLineaDeTransporte();
		ElementoListaEdicionLineaDeTransporte e6 = new ElementoListaEdicionLineaDeTransporte();
		ElementoListaEdicionLineaDeTransporte e7 = new ElementoListaEdicionLineaDeTransporte();
		ElementoListaEdicionLineaDeTransporte e8 = new ElementoListaEdicionLineaDeTransporte();
		ElementoListaEdicionLineaDeTransporte e9 = new ElementoListaEdicionLineaDeTransporte();
		
		this.add(e1, gbc);
		this.add(e2, gbc);
		this.add(e3, gbc);
//		this.add(e4, gbc);
//		this.add(e5, gbc);
//		this.add(e6, gbc);
//		this.add(e7, gbc);
//		this.add(e8, gbc);
//		this.add(e9, gbc);
		
	}
}
