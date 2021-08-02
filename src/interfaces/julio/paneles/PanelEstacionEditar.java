package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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
	private JButton inicioMantenimiento;
	private JButton finMantenimiento;
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
	private LocalDate fechaHoy = LocalDate.now();
	
	public PanelEstacionEditar(EstacionEditar frame, Vector filaSeleccionada) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Editar Estación"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Id: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 0;
		c.weightx = 0.0; c.weighty = 0.1;
		this.add(label, c);
		
		field = new JTextField(filaSeleccionada.elementAt(0).toString());
		field.setEditable(false);
		field.setHorizontalAlignment(JTextField.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 0;
		c.gridwidth = 3;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 1;
		
		label = new JLabel("Nombre: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 1;
		this.add(label, c);
		
		nombre = new JTextField((String) filaSeleccionada.elementAt(1));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 1;
		c.gridwidth = 3;
		this.add(nombre, c);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 1;
		
		label = new JLabel("Horario de apertura: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 2;
		this.add(label, c);
		
		horarioAux = (LocalTime) filaSeleccionada.elementAt(2);
		
		horaApertura = new JTextField(Integer.toString(horarioAux.getHour()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 2;
		this.add(horaApertura, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2; c.gridy = 2;
		this.add(label, c);
		
		minutoApertura = new JTextField(Integer.toString(horarioAux.getMinute()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3; c.gridy = 2;
		this.add(minutoApertura, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de cierre: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 3;
		this.add(label, c);
		
		horarioAux = (LocalTime) filaSeleccionada.elementAt(3);
		
		horaCierre = new JTextField(Integer.toString(horarioAux.getHour()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 3;
		c.weightx = 0.1;
		this.add(horaCierre, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2; c.gridy = 3;
		this.add(label, c);
		
		minutoCierre = new JTextField(Integer.toString(horarioAux.getMinute()));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3; c.gridy = 3;
		this.add(minutoCierre, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Estado: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 4;
		this.add(label, c);
		
		field = new JTextField(filaSeleccionada.elementAt(4).toString());
		//field.setHighlighter(null);
		//field.setEnabled(false);
		field.setEditable(false);
		//c.anchor = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1; c.gridy = 4;
		c.weightx = 0.2;
		c.gridwidth = 3;
		this.add(field, c);
		//c.weightx = 0.0;
		c.gridwidth = 1;
		
		inicioMantenimiento = new JButton("Inicio de tarea de mantenimiento");
		if(filaSeleccionada.elementAt(4).toString() == "EN_MANTENIMIENTO")
			inicioMantenimiento.setEnabled(false);
		inicioMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					popUpMantenimiento = new PopUpMantenimiento(getFrame());						
				
			}
		});
		
		
		c.anchor = GridBagConstraints.CENTER;
		//c.weightx = 0.5;
		c.gridx = 4; c.gridy = 4;
		this.add(inicioMantenimiento, c);
		
		finMantenimiento = new JButton("Fin de tarea de mantenimiento");
		if(filaSeleccionada.elementAt(4).toString() == "OPERATIVA")
			finMantenimiento.setEnabled(false);
		finMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] options = {"Cancelar", "Finalizar"};
				
				int n = JOptionPane.showOptionDialog(frame,
				"¿Realmente desea finalizar la tarea de mantenimiento el dia "
				+fechaHoy.getDayOfMonth()+"/"+fechaHoy.getMonthValue()+"/"+fechaHoy.getYear()+"?",
				"Finalizar tarea de mantenimiento",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
				
				//System.out.println(n);
				
				if(n == 1) {
					System.out.println("Apretó finalizar");
					finMantenimiento.setEnabled(false);
				}
				else {
					System.out.println("Apretó cancelar o cerró la ventana");
				}
			}
		});
		
		c.anchor = GridBagConstraints.CENTER;
		//c.weightx = 0.5;
		c.gridx = 5; c.gridy = 4;
		this.add(finMantenimiento, c);
		
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
		c.gridx = 0; c.gridy = 5;
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
							IIE.getMessage()+"- El nombre puede tener como máximo 30 caracteres de longitud. \n"+
									  "- La hora debe encontrarse en el intervalo [0, 23]. \n"+
									  "- Los minutos deben encontrarse en el intervalo [0,59].\n"+
									  "- La hora de cierre debe ser mayor a la hora de inicio.\n",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 5; c.gridy = 5;
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
		
		if(!validarHora(horaApertura) || !validarMinuto(minutoApertura) ||
		   !validarHora(horaCierre)   || !validarMinuto(minutoCierre)   || !validarNombre(nombre)
		   || !horasValidas(horaApertura, minutoApertura, horaCierre, minutoCierre))

				throw new InputInvalidaException();
	}
	
	public boolean validarHora(JTextField field) { //Retorna false si no es integer o si no se encuentra en el rango [0, 23]
		
		try {
			Integer hora = Integer.parseInt(field.getText());
			
			if(hora > -1 && hora < 24) {
				
				return true; 
			}
			else {
				
				return false;
			}
			
		} catch(NumberFormatException e) {
			
			return false;
		}
	}
	
	public boolean validarMinuto(JTextField field) { //Retorna false si no es integer o si no se encuentra en el rango [0, 59]
		
		try {
			
			Integer minuto = Integer.parseInt(field.getText());
			
			if(minuto > -1 && minuto < 60) {
				
				return true; 
			}
			else {
				
				return false;
			}
			
		} catch(NumberFormatException e) {
			
			return false;
		}
	}
	
	public boolean validarNombre(JTextField field) { //Retorna false si la longitud del string es mayor a 30
		
		if(field.getText().length() > 30)
			return false;
		
		return true;
	}
	
	public boolean horasValidas(JTextField horaApertura, JTextField minutoApertura, JTextField horaCierre, JTextField minutoCierre) {
		
		Integer horaA = Integer.parseInt(horaApertura.getText());
		Integer horaC = Integer.parseInt(horaCierre.getText());
		Integer minutoA = Integer.parseInt(minutoApertura.getText());
		Integer minutoC = Integer.parseInt(minutoCierre.getText());
		
		if(horaC > horaA) {	//Si la hora de cierre es mayor, los minutos no importan (horas validas)
			return true;
		}
		else if(horaC == horaA){	//Si las horas son iguales, debo comparar minutos
			
			if(minutoC > minutoA) { //Minuto de cierre mayor (horas validas)
				return true;
			}
			else {
				return false;	//Minuto de apertura mayor (horas invalidas)
			}
		}
		else {	//Si la hora de apertura es mayor a la de cierre, los minutos no importan (horas invalidas)
			return false;
		}
	}
	
	public void seCreoMantenimiento() {
		inicioMantenimiento.setEnabled(false);
	}
	
	public PanelEstacionEditar getFrame() {
		return this;
	}

}
