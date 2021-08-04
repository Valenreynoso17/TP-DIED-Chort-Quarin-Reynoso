package interfaces.fede.dialogs;

import java.awt.BasicStroke;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.StrokeBorder;
import javax.swing.plaf.basic.BasicBorders;

public class DialogLeyenda extends JDialog {
	public DialogLeyenda(String descripcionVentana) {
		this.setSize(new Dimension(350, 350));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Informacion");
		
		JPanel panel = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		panel.setLayout(gbl);
		
		JTextArea txtArea = new JTextArea(descripcionVentana);
		txtArea.setPreferredSize(new Dimension(250, 250));
		txtArea.setMargin(new Insets(10, 10, 10, 10));
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setOpaque(false);
		txtArea.setBorder(
				   javax.swing.BorderFactory.createCompoundBorder(
				      javax.swing.BorderFactory.createStrokeBorder(new BasicStroke(1)),
				      javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)
				   )
				);
		txtArea.setEditable(false);
		GridBagConstraints gbc_txtArea = new GridBagConstraints();
		gbc_txtArea.gridx = 0;
		gbc_txtArea.gridy = 0;
		panel.add(txtArea, gbc_txtArea);
		
		this.setContentPane(panel);
	}
}
