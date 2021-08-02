package interfaces.fede.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Recorrido;
import excepciones.InputInvalidaException;
import excepciones.InputVacioException;
import interfaces.fede.frames.FrameVentaBoleto3;

public class PanelVentaBoleto3 extends JPanel {
	public PanelVentaBoleto3(Recorrido recorrido) {
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[]{0.1, 0.5, 0.1};
		gbl.rowWeights = new double[]{0.5, 0.1, 0.0, 0.0};
		this.setLayout(gbl);
		
		
		PanelDatosVentaBoleto panelDatos = new PanelDatosVentaBoleto(recorrido);	
		GridBagConstraints gbc_panelDatos = new GridBagConstraints();
		gbc_panelDatos.gridx = 1;
		gbc_panelDatos.gridy = 0;
		gbc_panelDatos.insets = new Insets(5, 5, 5, 5);
		this.add(panelDatos, gbc_panelDatos);
		
		JButton botonAtras = new JButton("  Atras  ");
		botonAtras.addActionListener(e -> {
			volverAtras();
			}
		);
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 1;
		gbc_botonAtras.insets = new Insets(5, 5, 5, 5);
		this.add(botonAtras, gbc_botonAtras);
		
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.addActionListener(e -> {
			try {
				panelDatos.validarCamposNoVacios();
				panelDatos.validarNombre();
				panelDatos.validarCorreo();
				panelDatos.crearBoleto();
				
				JOptionPane.showMessageDialog(null, "Boleto comprado con éxito.", "Exito", JOptionPane.INFORMATION_MESSAGE);
				((FrameVentaBoleto3) getPadre()).volverAlMenu();
			}
			catch (InputVacioException exc) {
				JOptionPane.showMessageDialog(getPadre(),"Faltan completar los siguientes campos:" + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (InputInvalidaException exc) {
				JOptionPane.showMessageDialog(getPadre(),exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		GridBagConstraints gbc_botonSiguiente = new GridBagConstraints();
		gbc_botonSiguiente.gridx = 2;
		gbc_botonSiguiente.gridy = 1;
		gbc_botonSiguiente.insets = new Insets(5, 5, 5, 5);
		this.add(botonSiguiente, gbc_botonSiguiente);
	}
	
	
	public JFrame getPadre() {
		return (JFrame) this.getTopLevelAncestor();
	}
	
	public void volverAtras() {
		getPadre().dispose();
		((FrameVentaBoleto3) getPadre()).abriVentanaAnterior();
	}
}
