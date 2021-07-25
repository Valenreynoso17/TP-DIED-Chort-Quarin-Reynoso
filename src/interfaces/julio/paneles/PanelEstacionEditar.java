package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.julio.frames.EstacionEditar;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.otros.PopUpMantenimiento;

public class PanelEstacionEditar extends JPanel{

	
	private JComboBox<String> comboBox;
	private JButton button;
	private JTextField field;
	private JLabel label;
	
	private EstacionGestionar frameAnterior = new EstacionGestionar();
	private PopUpMantenimiento popUpMantenimiento = new PopUpMantenimiento();
	
	private LocalTime horarioAux;
	
	public PanelEstacionEditar(EstacionEditar frame, Vector filaSeleccionada) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 5), "Editar Estación"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Id:? ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.0;
		c.weighty = 0.1;
		this.add(label, c);
		
		field = new JTextField((String) filaSeleccionada.elementAt(0));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Nombre: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(label, c);
		
		field = new JTextField((String) filaSeleccionada.elementAt(1));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de apertura: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 2;
		this.add(label, c);
		
		horarioAux = (LocalTime) filaSeleccionada.elementAt(2);
		
		//String hola = Integer.toString(horario.getHour());
		
		field = new JTextField(Integer.toString(horarioAux.getHour()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 2;
		this.add(label, c);
		
		field = new JTextField(Integer.toString(horarioAux.getMinute()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 2;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de cierre: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 3;
		this.add(label, c);
		
		horarioAux = (LocalTime) filaSeleccionada.elementAt(3);
		
		field = new JTextField(Integer.toString(horarioAux.getHour()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 0.1;
		this.add(label, c);
		c.weightx = 0.0;
		
		field = new JTextField(Integer.toString(horarioAux.getMinute()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 3;
		//c.weightx = 0.2;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Estado: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 4;
		this.add(label, c);
		
		field = new JTextField(filaSeleccionada.elementAt(4).toString());
		//field.setHighlighter(null);
		//field.setEnabled(false);
		field.setEditable(false);
		//c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 4;
		c.weightx = 0.2;
		this.add(field, c);
		c.weightx = 0.0;
		
		button = new JButton("Inicio de tarea de mantenimiento");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				popUpMantenimiento.setVisible(true);
		}
		});
		
		
		c.anchor = GridBagConstraints.CENTER;
		//c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 4;
		this.add(button, c);
		
		button = new JButton("Fin de tarea de mantenimiento");
		c.anchor = GridBagConstraints.CENTER;
		//c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 4;
		this.add(button, c);
		
		button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frameAnterior.setVisible(true);
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		this.add(button, c);
		
		button = new JButton("Confirmar edición");
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 5;
		this.add(button, c);
		
	}

	
}
