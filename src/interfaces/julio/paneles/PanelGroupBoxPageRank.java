package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelGroupBoxPageRank extends JPanel{


		private JLabel label;
		private JTextField field;
		private JButton button;
		private GridBagConstraints gbc;
		
		public PanelGroupBoxPageRank(PanelPageRank panelPadre) {
			
			this.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Cargar variable de amortiguación"));
			this.setLayout(new GridBagLayout());
			gbc = new GridBagConstraints();
			
			gbc.gridx = 0; gbc.gridy = 0;
			gbc.weightx = 0.1;
			gbc.anchor = GridBagConstraints.CENTER;
			
			
			label = new JLabel("Ingrese el valor de la variable de amortiguación (d) entre 0.00 y 1.00: ");
			
			this.add(label, gbc);
			
			field = new JTextField();
			gbc.gridx = 1;
			gbc.weightx = 0.2;
			gbc.insets = new Insets(0, 0, 0, 50);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			this.add(field, gbc);
			gbc.fill = GridBagConstraints.NONE;
			
			label = new JLabel("(0.85 por defecto) ");
			label.setForeground(Color.gray);
			gbc.gridx = 2;
			gbc.weightx = 0.1;
			
			this.add(label, gbc);
			
			button = new JButton("Calcular");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						panelPadre.ingresoNuevoValorDeAmortiguacion(field);
				}
			});
			gbc.gridx = 3;
			this.add(button, gbc);
			
			
		}

}
