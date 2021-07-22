package interfaces.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VerdaderaVentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerdaderaVentanaPrincipal frame = new VerdaderaVentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VerdaderaVentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gestionar estaciones");
		btnNewButton.setBounds(123, 95, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrar tarea de mantenimiento");
		btnNewButton_1.setBounds(679, 95, 193, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gestionar l\u00EDneas de transporte");
		btnNewButton_2.setBounds(101, 273, 177, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Adquirir boleto");
		btnNewButton_3.setBounds(724, 273, 103, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SALIR");
		btnNewButton_4.setBounds(463, 481, 61, 23);
		contentPane.add(btnNewButton_4);
		this.setLocationRelativeTo(null); //Para centrar
		
	}

}
