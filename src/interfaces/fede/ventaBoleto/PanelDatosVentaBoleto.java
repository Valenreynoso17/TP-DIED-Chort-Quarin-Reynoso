package interfaces.fede.ventaBoleto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Recorrido;

public class PanelDatosVentaBoleto extends JPanel {
	private Recorrido recorrido;
	
	public PanelDatosVentaBoleto(Recorrido recorrido) {
		this.recorrido = recorrido;
		this.setPreferredSize(new Dimension(600, 400));
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[]{0.1, 0.5, 0.1};
		gbl.rowWeights = new double[]{0.5, 0.1, 0.0, 0.0};
		this.setLayout(gbl);
		
		JLabel lblNroBoleto = new JLabel("Nro. boleto");
		GridBagConstraints gbc_lblNroBoleto = new GridBagConstraints();
		gbc_lblNroBoleto.gridx = 0;
		gbc_lblNroBoleto.gridy = 0;
		gbc_lblNroBoleto.insets = new Insets(5, 5, 5, 5);
		this.add(lblNroBoleto, gbc_lblNroBoleto);
		
		JTextField tfNroBoleto = new JTextField();
		GridBagConstraints gbc_tfNroBoleto = new GridBagConstraints();
		gbc_tfNroBoleto.gridx = 1;
		gbc_tfNroBoleto.gridy = 0;
		gbc_tfNroBoleto.insets = new Insets(5, 5, 5, 5);
		this.add(tfNroBoleto, gbc_tfNroBoleto);
	}
}
