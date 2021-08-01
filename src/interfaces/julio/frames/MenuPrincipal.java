package interfaces.julio.frames;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.julio.paneles.PanelEstacionAlta;
import interfaces.julio.paneles.PanelMenuPrincipal;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	public MenuPrincipal() {
		super("Sistema de Gestión de Transporte Multimodal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new PanelMenuPrincipal(this);
		setContentPane(contentPane);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
		
		

		
	}
	
	}
