package interfaces.fede.dialogs;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.WindowConstants;

import clases.Estacion;
import clases.Flecha;
import clases.Ruta;
import enums.EstadoRuta;
import interfaces.fede.otros.RenderInfoFlecha;

public class DialogInfoFlechaInactivosNoVisibles extends JDialog {
	public DialogInfoFlechaInactivosNoVisibles(Flecha f, ListCellRenderer<Ruta> render) {
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setTitle("Info " + f.getEstacionOrigen().getNombre() + " --> " + f.getEstacionDestino().getNombre());
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		DefaultListModel<Ruta> model = new DefaultListModel<>();
		JList<Ruta> lista = new JList<>(model);
		model.addAll(f.getRutasActivas());	
		lista.setCellRenderer(render);
		
		
		JScrollPane scrollPane = new JScrollPane(lista);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		add(scrollPane, gbc_comboBox);
	}
}
