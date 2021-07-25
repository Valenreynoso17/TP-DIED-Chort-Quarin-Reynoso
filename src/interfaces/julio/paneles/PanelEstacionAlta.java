package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.julio.frames.EstacionAlta;
import interfaces.julio.frames.EstacionGestionar;

public class PanelEstacionAlta extends JPanel{
	
	private JComboBox<String> comboBox;
	private JButton button;
	private JLabel label;
	
	private JTextField id;
	private JTextField nombre;
	private JTextField horaApertura;
	private JTextField minutoApertura;
	private JTextField horaCierre;
	private JTextField minutoCierre;
	private JTextField estado;
	
	private EstacionGestionar frameAnterior;
	
	public PanelEstacionAlta(EstacionAlta frame) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 5), "Dar de alta Estación"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Id:? ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.0;
		c.weighty = 0.1;
		this.add(label, c);
		
		id = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		this.add(id, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Nombre: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(label, c);
		
		nombre = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		this.add(nombre, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de apertura: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 2;
		this.add(label, c);
		
		horaApertura = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		this.add(horaApertura, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 2;
		this.add(label, c);
		
		minutoApertura = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 2;
		this.add(minutoApertura, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de cierre: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 3;
		this.add(label, c);
		
		horaCierre = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		this.add(horaCierre, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 0.1;
		this.add(label, c);
		
		minutoCierre = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 3;
		c.weightx = 0.3;
		this.add(minutoCierre, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Estado: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 4;
		this.add(label, c);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("OPERATIVA");
		comboBox.addItem("EN MANTENIMIENTO");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 4;
		this.add(comboBox, c);
		
		button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frameAnterior = new EstacionGestionar();
				frameAnterior.setVisible(true);
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		this.add(button, c);
		
//		yourJTextField.getDocument().addDocumentListener(new DocumentListener() {  //Interesante para implementar!!
//			  public void changedUpdate(DocumentEvent e) {
//			    changed();
//			  }
//			  public void removeUpdate(DocumentEvent e) {
//			    changed();
//			  }
//			  public void insertUpdate(DocumentEvent e) {
//			    changed();
//			  }
//
//			  public void changed() {
//			     if (yourJTextField.getText().equals("")){
//			       loginButton.setEnabled(false);
//			     }
//			     else {
//			       loginButton.setEnabled(true);
//			    }
//
//			  }
//			});
		
		button = new JButton("Crear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(id.getText().isEmpty() || nombre.getText().isEmpty() || horaApertura.getText().isEmpty() ||
				   minutoApertura.getText().isEmpty() || horaCierre.getText().isEmpty() || minutoCierre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame,
						    "Debe completar todos los campos correctamente.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}else {
				
				//frame.dispose();
				//frameEdicion = new EstacionEditar(filaSeleccionada);
				//frameEdicion.setVisible(true);
			}
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 5;
		this.add(button, c);
		
	}

}
