package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaces.valen.frames.VentanaAltaLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;
import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;

public class PanelBotonesResumenAltaLinea extends JPanel{
	
	JButton botonCancelar;
	JButton botonAnterior;
	JButton botonTerminado;
	VentanaSiguienteAltaLineaDeTransporte framePadre;
	PanelPrincipalSiguienteAltaLineaDeTransporte panel;
	GridBagConstraints gbc;
	
	public PanelBotonesResumenAltaLinea(VentanaAltaLineaDeTransporte frameAbuelo,VentanaSiguienteAltaLineaDeTransporte framePadre,PanelPrincipalSiguienteAltaLineaDeTransporte panel) {
		
		this.panel = panel;
		this.framePadre = framePadre;
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(5,10,5,10);
		
		// Primer componente - Boton cancelar
		gbc.gridx = 0;
		gbc.weightx = 0.1;
		botonCancelar = new JButton("Cancelar");
		// TODO: tengo que poner un JOptionPane para que pregunte si desea cancelar el alta
		botonCancelar.addActionListener(e -> {
			framePadre.dispose();
			new VentanaGestionLineasDeTransporte();
		});
		this.add(botonCancelar, gbc);
		
		// Segundo componente - Boton anterior
		gbc.gridx = 1;
		gbc.weightx = 0.1;
		gbc.anchor = GridBagConstraints.WEST;
		botonAnterior = new JButton("Volver");
		botonAnterior.addActionListener(e -> {
			framePadre.dispose();
			frameAbuelo.setVisible(true);
		});
		this.add(botonAnterior, gbc);
		
		// Tercer componente - Boton terminar
		gbc.gridx = 2;
		gbc.weightx = 0.9;
		gbc.insets = new Insets(5,10,5,30);
		gbc.anchor = GridBagConstraints.EAST;
		botonTerminado = new JButton("Terminar");
		botonTerminado.addActionListener(e -> confirmarYGuardar());
		this.add(botonTerminado, gbc);
	}
	
	private void confirmarYGuardar() {
		//Custom JOptionPane
		Object[] options = {"Confirmar",
		                    "Cancelar"};
		int n = JOptionPane.showOptionDialog(framePadre,
		    "Está seguro que desea agregar esta línea al sistema?",
		    "Confirmar alta de línea",
		    JOptionPane.OK_CANCEL_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[1]);
		
		if(n==0) {
			framePadre.dispose();
			panel.guardarNuevaLinea();
			new VentanaGestionLineasDeTransporte();
		} 
	}
}
