package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import clases.LineaDeTransporte;
import interfaces.fede.panelesGrafos.PanelGrafico;
import interfaces.valen.frames.VentanaEdicionLineaDeTransporte;

public class PanelPrincipalEdicionLineaDeTransporte extends JPanel{
	
	PanelDatosLineaDeTransporte panelDatosLinea;
	PanelDatosTrayectoLineaDeTransporte panelDatosTrayecto;
	PanelBotonesEdicionLinea panelBotones;
	GridBagConstraints gbc = new GridBagConstraints();
	LineaDeTransporte lineaDeTransporte;
	
	public PanelPrincipalEdicionLineaDeTransporte(VentanaEdicionLineaDeTransporte frame, LineaDeTransporte lineaDeTransporte) {
		
		this.lineaDeTransporte = lineaDeTransporte;
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		// GridBag de 3x1
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		
		// Primer componente - panel datos linea
		gbc.gridy = 0;
		panelDatosLinea = new PanelDatosLineaDeTransporte(frame, lineaDeTransporte);
		this.add(panelDatosLinea, gbc);
		
		// Segundo componente - panel datos trayecto
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		
		panelDatosTrayecto = new PanelDatosTrayectoLineaDeTransporte();
		JScrollPane panelScrollDatosTrayecto = new JScrollPane(panelDatosTrayecto, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelScrollDatosTrayecto.setBorder(BorderFactory.createTitledBorder("Datos del trayecto"));
		this.add(panelScrollDatosTrayecto, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 0.0;
		
		// Tercer componente - panel botones
		gbc.gridy = 2;
		panelBotones = new PanelBotonesEdicionLinea(frame);
		this.add(panelBotones, gbc);
		
	}

}
