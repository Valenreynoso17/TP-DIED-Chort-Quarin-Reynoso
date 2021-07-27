package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interfaces.fede.panelesGrafos.PanelGrafico;
import interfaces.valen.frames.VentanaEdicionLineaDeTransporte;

public class PanelPrincipalEdicionLineaDeTransporte extends JPanel{
	
	PanelDatosLineaDeTransporte panelDatosLinea;
	PanelDatosTrayectoLineaDeTransporte panelDatosTrayecto;
	PanelBotonesEdicionLinea panelBotones;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public PanelPrincipalEdicionLineaDeTransporte(VentanaEdicionLineaDeTransporte frame) {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		// GridBag de 3x1
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		
		// Primer componente - panel datos linea
		gbc.gridy = 0;
		panelDatosLinea = new PanelDatosLineaDeTransporte();
		this.add(panelDatosLinea, gbc);
		
		// Segundo componente - panel datos trayecto
		gbc.gridy = 1;
		panelDatosTrayecto = new PanelDatosTrayectoLineaDeTransporte();
		JScrollPane panelScrollDatosTrayecto = new JScrollPane(panelDatosTrayecto);
		panelScrollDatosTrayecto.setBorder(BorderFactory.createTitledBorder("Datos del trayecto"));
		this.add(panelScrollDatosTrayecto, gbc);
		
		// Tercer componente - panel botones
		gbc.gridy = 2;
		panelBotones = new PanelBotonesEdicionLinea();
		this.add(panelBotones, gbc);
		
	}

}
