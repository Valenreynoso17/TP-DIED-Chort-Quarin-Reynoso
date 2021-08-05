package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import excepciones.InputInvalidaException;
import interfaces.valen.paneles.PanelGridListaGestionLineas;

public class PanelEstacionBusqueda extends JPanel{
	
	private JLabel label;
	private JButton button;
	
	private JTextField id, nombre, horaApertura, minutoApertura, horaCierre, minutoCierre;
	
	public PanelEstacionBusqueda(PanelEstacionTablaResultado panelTabla, JFrame frame) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Búsqueda de Estaciones"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Id: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 0;
		c.weighty = 0.1;
		c.gridheight = 1; c.gridwidth = 1;
		this.add(label, c);
		
		id = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 0;
		c.gridwidth = 3;
		//c.weightx = 0.1;
		this.add(id, c);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 1;
		//c.weightx = 0.0;
		
		label = new JLabel("Nombre: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5; c.gridy = 0;
		c.weightx = 0.1;
		this.add(label, c);
		
		nombre = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6; c.gridy = 0;
		c.gridwidth = 3;
		this.add(nombre, c);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 1;
		
		label = new JLabel("Horario de apertura: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 1;
		this.add(label, c);
		
		horaApertura = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 1;
		c.weightx = 0.1;
		this.add(horaApertura, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2; c.gridy = 1;
		this.add(label, c);
		
		minutoApertura = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3; c.gridy = 1;
		this.add(minutoApertura, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Horario de cierre: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5; c.gridy = 1;
		this.add(label, c);
		
		horaCierre = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6; c.gridy = 1;
		c.weightx = 0.1;
		this.add(horaCierre, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 7; c.gridy = 1;
		this.add(label, c);
		
		minutoCierre = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8; c.gridy = 1;
		this.add(minutoCierre, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		button = new JButton("Buscar estación");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						inputEsValida(camposNoVacios());
						panelTabla.actualizarTabla(camposNoVacios());
						
					}catch (InputInvalidaException IIE) {
						
						JOptionPane.showMessageDialog(frame,
								IIE.getMessage()+"- El id es obligatoriamente un número entero mayor a 0.\n"+
										  "- El nombre puede tener como máximo 30 caracteres de longitud. \n"+
										  "- La hora debe encontrarse en el intervalo [0, 23]. \n"+
										  "- Los minutos deben encontrarse en el intervalo [0,59].\n",	
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4; c.gridy = 2;
		this.add(button, c);
	}
	
	public String[] camposNoVacios() {
		
		String[] campos = new String[6];
		
		if(!id.getText().isEmpty())
			campos[0] = id.getText();
		if(!nombre.getText().isEmpty())
			campos[1] = nombre.getText();
		if(!horaApertura.getText().isEmpty())
			campos[2] = horaApertura.getText();
		if(!minutoApertura.getText().isEmpty())
			campos[3] = minutoApertura.getText();
		if(!horaCierre.getText().isEmpty())
			campos[4] = horaCierre.getText();
		if(!minutoCierre.getText().isEmpty())
			campos[5] = minutoCierre.getText();
		
		return campos;
	}
	
	public void inputEsValida(String[] campos) throws InputInvalidaException{
		
		if(campos[0] != null) {
			if(!validarId(id))
				throw new InputInvalidaException();
		}
		if(campos[1] != null) {
			if(!validarNombre(nombre))
				throw new InputInvalidaException();
		}
		if(campos[2] != null) {
			if(!validarHora(horaApertura))
				throw new InputInvalidaException();
		}
		if(campos[3] != null) {
			if(!validarMinuto(minutoApertura))
				throw new InputInvalidaException();
		}
		if(campos[4] != null) {
			if(!validarHora(horaCierre))
				throw new InputInvalidaException();
		}
		if(campos[5] != null) {
			if(!validarMinuto(minutoCierre))
				throw new InputInvalidaException();
		}

	}
	
	public boolean validarId(JTextField field) { //Retorna false si no es integer o si es menor o igual a 0
		
		try {
			Integer id = Integer.parseInt(field.getText());
			
			if(id > 0) {
				
				return true; 
			}
			else {
				
				return false;
			}
			
		} catch(NumberFormatException e) {
			
			return false;
		}
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
	
	

}
