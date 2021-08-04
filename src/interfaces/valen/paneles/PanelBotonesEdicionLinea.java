package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaces.valen.frames.VentanaEdicionLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;

public class PanelBotonesEdicionLinea extends JPanel{

	JButton botonCancelar;
	JButton botonTerminado;
	GridBagConstraints gbc;
	VentanaEdicionLineaDeTransporte frame;
	
	public PanelBotonesEdicionLinea(VentanaEdicionLineaDeTransporte frame, PanelPrincipalEdicionLineaDeTransporte panelPrincipal) {
		
		this.frame = frame;
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		gbc.gridx = 0;
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(e -> this.cancelarEdicion());
		this.add(botonCancelar, gbc);
		
		gbc.gridx = 1;
		botonTerminado = new JButton("Confirmar cambios");
		botonTerminado.addActionListener(e -> this.editarDatos(panelPrincipal));
		this.add(botonTerminado, gbc);
		
	}
	
	public void editarDatos(PanelPrincipalEdicionLineaDeTransporte panelPrincipal) {
		//Custom JOptionPane
		Object[] options = {"Confirmar",
		                    "Cancelar"};
		int n = JOptionPane.showOptionDialog(frame,
										     "¿Está seguro que desea confirmar los cambios realizados?",
										     "Confirmar edición de línea",
										     JOptionPane.OK_CANCEL_OPTION,
										     JOptionPane.QUESTION_MESSAGE,
										     null,
										     options,
										     options[1]);
		
		if(n==0) {
			frame.dispose();
			panelPrincipal.actualizarDatos();
			new VentanaGestionLineasDeTransporte();
		}
		
	}
	
	public void cancelarEdicion() {
		//Custom JOptionPane
		Object[] options = {"Si",
		                    "No"};
		int n = JOptionPane.showOptionDialog(frame,
										     "¿Está seguro que desea cancelar la edición? \n" +
										     "Todos los cambios realizados se perderán.",
										     "Confirmar edición de línea",
										     JOptionPane.OK_CANCEL_OPTION,
										     JOptionPane.QUESTION_MESSAGE,
										     null,
										     options,
										     options[1]);
		
		if(n==0) {
			frame.dispose();
			new VentanaGestionLineasDeTransporte();
		}
	}
}
