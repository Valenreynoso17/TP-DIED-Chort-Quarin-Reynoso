package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import excepciones.InputPageRankInvalidaException;
import interfaces.julio.frames.MenuPrincipal;
import interfaces.julio.frames.PageRank;

public class PanelPageRank extends JPanel{

	private JButton button;
	private JLabel label;

	private GridBagConstraints gbc;
	private PanelGroupBoxPageRank panelGroupBoxPageRank;
	private PanelTablaPageRank panelTablaPageRank;
	private Insets insets = new Insets(10, 10, 10, 10);
	
	private PageRank frameAnterior;
	
	public PanelPageRank(PageRank frame) {
		
		frameAnterior = frame;
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Page Rank de las estaciones"));
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.insets = insets;
		panelGroupBoxPageRank = new PanelGroupBoxPageRank(this);
		this.add(panelGroupBoxPageRank, gbc);
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = insets;
		panelTablaPageRank = new PanelTablaPageRank();
		this.add(panelTablaPageRank, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.weighty = 0.1;
		
		
		button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frameAnterior.dispose();
				new MenuPrincipal();
			}
		});
		gbc.insets = new Insets(0,100,15,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(button, gbc);
		
		
	}
	
	public void ingresoNuevoValorDeAmortiguacion(JTextField campo) {
		
			try {
				
				if(campo.getText().isEmpty()) {		//Si es nulo que tome el valor 0.85
					panelTablaPageRank.setNuevoValorDeAmortiguacion(0.85);
				}
				else {
				
					inputEsValido(campo);
					
					panelTablaPageRank.setNuevoValorDeAmortiguacion(Double.parseDouble(campo.getText()));
				}
			
			} catch (InputPageRankInvalidaException IPRIE) {
				
				JOptionPane.showMessageDialog(frameAnterior,
						IPRIE.getMessage(),
					    "Error",
					    JOptionPane.ERROR_MESSAGE);
			}
	}

	public void inputEsValido(JTextField campo) throws InputPageRankInvalidaException{ //Retorna false si no es integer o si no se encuentra en el rango [0, 23]
		
		try {
			Double valorAmortiguacion = Double.parseDouble(campo.getText());
			
			if(valorAmortiguacion < 0 || valorAmortiguacion > 1)
				throw new InputPageRankInvalidaException();
			
		} catch(NumberFormatException e) {
			
			throw new InputPageRankInvalidaException();
		}
	}
}
