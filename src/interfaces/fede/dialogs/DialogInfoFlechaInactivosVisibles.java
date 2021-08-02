package interfaces.fede.dialogs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Flecha;
import clases.Ruta;
import interfaces.fede.otros.RenderInfoFlecha;

public class DialogInfoFlechaInactivosVisibles extends JDialog {
	public DialogInfoFlechaInactivosVisibles(Flecha f) {
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		this.setSize(200, 250);
		this.setLocationRelativeTo(null);
		this.setTitle("Info " + f.getEstacionOrigen().getNombre() + " --> " + f.getEstacionDestino().getNombre());
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		DefaultListModel<Ruta> model = new DefaultListModel<>();
		JList<Ruta> lista = new JList<>(model);
		model.addAll(f.getRutas());
		lista.setCellRenderer(new RenderInfoFlecha<Ruta>());
		
		JScrollPane scrollPane = new JScrollPane(lista);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		add(scrollPane, gbc_comboBox);
	}
}
