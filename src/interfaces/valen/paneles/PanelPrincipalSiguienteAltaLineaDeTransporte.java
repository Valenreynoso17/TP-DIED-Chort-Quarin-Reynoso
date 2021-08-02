package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.CustomColor;
import interfaces.valen.frames.VentanaAltaLineaDeTransporte;
import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;
import interfaces.valen.otros.ColorPicker;
import interfaces.valen.otros.ElementoListaTrayecto;

public class PanelPrincipalSiguienteAltaLineaDeTransporte extends JPanel{

	PanelResumenAltaLinea panelResumen;
	PanelTablaAltaLinea panelTabla;
	PanelBotonesResumenAltaLinea panelBotones;
	List<ElementoListaTrayecto> listaTrayecto;
	GridBagConstraints gbc;
	
	public PanelPrincipalSiguienteAltaLineaDeTransporte(VentanaAltaLineaDeTransporte frameAbuelo,VentanaSiguienteAltaLineaDeTransporte framePadre, String nombreLinea, Integer estadoLinea, CustomColor colorLinea, List<ElementoListaTrayecto> listaTrayecto) {
		
		this.listaTrayecto = listaTrayecto;
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		// GridBag de 3x1
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		// Primer componente - Panel resumen
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.0;
		panelResumen = new PanelResumenAltaLinea(framePadre, nombreLinea, estadoLinea, colorLinea);
		this.add(panelResumen, gbc);
		
		// Segundo componente - Panel tabla
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		panelTabla = new PanelTablaAltaLinea(listaTrayecto);
		this.add(panelTabla, gbc);
		
		// Tercer componente - Panel botones
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 0.0;
		panelBotones = new PanelBotonesResumenAltaLinea(frameAbuelo, framePadre);
		this.add(panelBotones, gbc);
		
	}
}
