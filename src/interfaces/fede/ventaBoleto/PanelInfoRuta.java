package interfaces.fede.ventaBoleto;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.WindowConstants;

import clases.Estacion;
import clases.Ruta;
import enums.EstadoRuta;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

public class PanelInfoRuta extends JPanel{
	public PanelInfoRuta() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		DefaultListModel<Ruta> model = new DefaultListModel<>();
		JList<Ruta> lista = new JList<>(model);
		model.addElement(new Ruta(new Estacion("123", "B", null, null, new Point(50, 50)), new Estacion("123", "B", null, null, new Point(50, 50)), 2, 2, 2, EstadoRuta.ACTIVA, 2));
		model.addElement(new Ruta(new Estacion("123", "B", null, null, new Point(50, 50)), new Estacion("123", "B", null, null, new Point(50, 50)), 2, 2, 2, EstadoRuta.ACTIVA, 2));
		lista.setCellRenderer(new Render<Ruta>());
		
		
		JScrollPane scrollPane = new JScrollPane(lista);
		scrollPane.setPreferredSize(new Dimension(60, 80));
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		add(scrollPane, gbc_comboBox);
		
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setContentPane(new PanelInfoRuta());
		frame.pack();
		frame.setVisible(true);
	}
	
}
