package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.CustomColor;
import clases.LineaDeTransporte;
import dao.LineaDeTransporteDAO;
import enums.EstadoLineaDeTransporte;
import interfaces.valen.frames.VentanaEdicionLineaDeTransporte;
import interfaces.valen.otros.ColorPicker;

public class PanelDatosLineaDeTransporte extends JPanel{

	JLabel labelNombreLinea;
	JTextField nombreLinea;
	JLabel labelEstado;
	JComboBox<String> estado;
	JLabel labelColor;
	ColorPicker colorPicker;
	GridBagConstraints gbc;
	LineaDeTransporte lineaDeTransporte;
	String[] opcionesEstado = {"Activa", "No activa"};
	VentanaEdicionLineaDeTransporte frame;
	
	public PanelDatosLineaDeTransporte(VentanaEdicionLineaDeTransporte frame, LineaDeTransporte lineaDeTransporte) {
		
		this.frame = frame;
		this.lineaDeTransporte = lineaDeTransporte;
		
		this.setBorder(BorderFactory.createTitledBorder("Datos de la línea"));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		// Componentes
		labelNombreLinea = new JLabel("Nombre de la línea:");
		nombreLinea = new JTextField(lineaDeTransporte.getNombre());
		nombreLinea.setForeground(Color.BLACK);
		labelEstado = new JLabel("Estado:");
		
		estado = new JComboBox<String>(opcionesEstado);
		estado.setSelectedIndex(0);
		if (lineaDeTransporte.getEstado() == EstadoLineaDeTransporte.NO_ACTIVA) estado.setSelectedIndex(1);
		
		labelColor = new JLabel("Color:");
		colorPicker = new ColorPicker(frame, this, lineaDeTransporte.getColor());
		
		// Configuraciones gbc
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridy = 0;
		
		gbc.gridx = 0;
		this.add(labelNombreLinea, gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(nombreLinea, gbc);
		gbc.weightx = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 2;
		this.add(labelEstado, gbc);
		
		gbc.gridx = 3;
		this.add(estado, gbc);
		
		gbc.gridx = 4;
		this.add(labelColor, gbc);
		
		gbc.gridx = 5;
		this.add(colorPicker, gbc);
	}
	
	public String getNuevoNombre() {
		return this.nombreLinea.getText();
	}
	
	public String getNuevoEstado() {
		return (String) this.estado.getSelectedItem();
	}
	
	public CustomColor getNuevoColor() {
		return colorPicker.getColor();
	}
	
	public void cambiarColorPicker(CustomColor color) {
		this.remove(colorPicker);
		
		this.revalidate();
    	this.repaint();
    	
    	gbc.gridx = 5;
    	colorPicker = new ColorPicker(frame, this, color);
    	
    	this.add(colorPicker, gbc);
	}
}
