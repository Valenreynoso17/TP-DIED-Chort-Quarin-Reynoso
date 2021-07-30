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

import excepciones.InputInvalidaException;
import excepciones.InputVacioException;
import interfaces.julio.frames.EstacionEditar;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.otros.PopUpMantenimiento;

public class PanelEstacionEditar extends JPanel{

	
	private JComboBox<String> comboBox;
	private JButton button;
	private JTextField nombre;
	private JTextField horaApertura;
	private JTextField minutoApertura;
	private JTextField horaCierre;
	private JTextField minutoCierre;
	private JTextField field;
	private JLabel label;
	
	private EstacionGestionar frameAnterior;
	private PopUpMantenimiento popUpMantenimiento;
	
	private LocalTime horarioAux;
	
	public PanelEstacionEditar(EstacionEditar frame, Vector filaSeleccionada) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Editar Estación"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Nombre: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 0;
		c.weightx = 0.0; c.weighty = 0.1;
		this.add(label, c);
		
		nombre = new JTextField((String) filaSeleccionada.elementAt(1));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 0;
		c.gridwidth = 3;
		this.add(nombre, c);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 1;
		
		label = new JLabel("Horario de apertura: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 1;
		this.add(label, c);
		
		horarioAux = (LocalTime) filaSeleccionada.elementAt(2);
		
		horaApertura = new JTextField(Integer.toString(horarioAux.getHour()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 1;
		this.add(horaApertura, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2; c.gridy = 1;
		this.add(label, c);
		
		minutoApertura = new JTextField(Integer.toString(horarioAux.getMinute()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3; c.gridy = 1;
		this.add(minutoApertura, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de cierre: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 2;
		this.add(label, c);
		
		horarioAux = (LocalTime) filaSeleccionada.elementAt(3);
		
		horaCierre = new JTextField(Integer.toString(horarioAux.getHour()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 2;
		c.weightx = 0.1;
		this.add(horaCierre, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2; c.gridy = 2;
		this.add(label, c);
		
		minutoCierre = new JTextField(Integer.toString(horarioAux.getMinute()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3; c.gridy = 2;
		this.add(minutoCierre, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Estado: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 3;
		this.add(label, c);
		
		field = new JTextField(filaSeleccionada.elementAt(4).toString());
		//field.setHighlighter(null);
		//field.setEnabled(false);
		field.setEditable(false);
		//c.anchor = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1; c.gridy = 3;
		c.weightx = 0.2;
		c.gridwidth = 3;
		this.add(field, c);
		//c.weightx = 0.0;
		c.gridwidth = 1;
		
		button = new JButton("Inicio de tarea de mantenimiento");
		if(filaSeleccionada.elementAt(4).toString() == "EN_MANTENIMIENTO")
			button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				popUpMantenimiento = new PopUpMantenimiento();
				popUpMantenimiento.setVisible(true);
			}
		});
		
		
		c.anchor = GridBagConstraints.CENTER;
		//c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 3;
		this.add(button, c);
		
		button = new JButton("Fin de tarea de mantenimiento");
		if(filaSeleccionada.elementAt(4).toString() == "OPERATIVA")
			button.setEnabled(false);
		c.anchor = GridBagConstraints.CENTER;
		//c.weightx = 0.5;
		c.gridx = 5;
		c.gridy = 3;
		this.add(button, c);
		
		button = new JButton("Cancelar");
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
		c.gridy = 4;
		this.add(button, c);
		
		button = new JButton("Confirmar edición");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					try {
						
						inputEstaVacia();
						inputEsValida();
						
						frame.dispose();
						frameAnterior = new EstacionGestionar();
					
				}catch (InputVacioException IVE) {
					
					JOptionPane.showMessageDialog(frame,
							"Faltan completar los siguientes campos:\n\n"+IVE.getMessage(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}catch (InputInvalidaException IIE) {
					
					JOptionPane.showMessageDialog(frame,
							IIE.getMessage(),	//VER
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 5;
		c.gridy = 4;
		this.add(button, c);
		
		button = new JButton("Editar ubicación");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { }
		
					
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 4;
		this.add(button, c);
		
	}
	
	public void inputEstaVacia() throws InputVacioException{
		String error = "";
		boolean algunoVacio = false;
		
		if(nombre.getText().isEmpty()) {
			error += "- Nombre\n";
			algunoVacio = true;
		}
		
		if(horaApertura.getText().isEmpty() || minutoApertura.getText().isEmpty()) {
			error += "- Hora de apertura\n";
			algunoVacio = true;
		}
		
		if(horaCierre.getText().isEmpty() || minutoCierre.getText().isEmpty()) {
			error += "- Hora de cierre\n";
			algunoVacio = true;
		}
		
		if(algunoVacio) {
			
			throw new InputVacioException(error);
		}
			
				
	}
	
	public void inputEsValida() throws InputInvalidaException{
		//TODO
		if(validarDatoInteger(horaApertura) || validarDatoInteger(minutoApertura) ||
		   validarDatoInteger(horaCierre) || validarDatoInteger(minutoCierre) || validarDatoString(nombre))

				throw new InputInvalidaException();
	}
	
	public boolean validarDatoInteger(JTextField field) {
		
		try {
			Integer.parseInt(field.getText());
		} catch(NumberFormatException e) {
			
			return true;
		}
		
		return false;
	}
	
	public boolean validarDatoString(JTextField field) {
		
		if(field.getText().length() > 30)
			return true;
		
		return false;
	}

}

	
