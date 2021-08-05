package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Estacion;
import excepciones.InputInvalidaException;
import excepciones.InputVacioException;
import excepciones.RutaYaAgregadaException;
import gestores.GestorEstacion;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.valen.frames.VentanaAltaLineaDeTransporte;
import interfaces.valen.otros.ElementoListaTrayecto;
import interfaces.valen.otros.TextPrompt;

public class PanelRutaLineaDeTransporte extends JPanel{

	GestorEstacion gestorEstacion;
	
	JLabel labelSeleccione;
	JComboBox<String> estacionOrigen;
	JComboBox<String> estacionDestino;
	JLabel labelDistancia;
	JTextField distancia;
	JLabel labelDuracion;
	JTextField duracion;
	JLabel labelCantMaxPasajeros;
	JTextField cantMaxPasajeros;
	JLabel labelEstadoRuta;
	JComboBox<String> estadoRuta;
	JLabel labelCosto;
	JTextField costo;
	JButton botonAgregar;
	JButton botonEliminar;
	JButton botonModificar;
	ElementoListaTrayecto unElemento;
	List<ElementoListaTrayecto> listaTrayecto;
	PanelPrincipalAltaLineaDeTransporte panelPadre;
	VentanaAltaLineaDeTransporte frame;
	GridBagConstraints gbc;
	String[] opcionesEstado = {"Activa", "No activa"};
	String[] opcionesEstaciones;
	
	public PanelRutaLineaDeTransporte(VentanaAltaLineaDeTransporte frame, PanelPrincipalAltaLineaDeTransporte panel, List<ElementoListaTrayecto> listaTrayecto) {
		
		gestorEstacion = GestorEstacion.getInstance();
		this.listaTrayecto = listaTrayecto;
		this.panelPadre = panel;
		this.frame = frame;
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 1),"Ruta"));
		
		// Componentes
		labelSeleccione = new JLabel("Seleccione una ruta");
		
		this.obtenerEstaciones();
		
		estacionOrigen = new JComboBox<String>(opcionesEstaciones);
		estacionDestino = new JComboBox<String>(opcionesEstaciones);
		
		labelDistancia = new JLabel("Distancia:");
		distancia = new JTextField();
		TextPrompt tpDistancia = new TextPrompt("Kilómetros", distancia);
		labelDuracion = new JLabel("Duración del viaje:");
		duracion = new JTextField();
		TextPrompt tpDuracion = new TextPrompt("Minutos", duracion);
		labelCantMaxPasajeros = new JLabel("Cantidad máxima pasajeros:");
		cantMaxPasajeros = new JTextField();
		TextPrompt tpCantMaxPasajeros = new TextPrompt("Pasajeros", cantMaxPasajeros);
		labelEstadoRuta = new JLabel("Estado ruta:");
		estadoRuta = new JComboBox<String>(opcionesEstado);
		labelCosto = new JLabel("Costo:");
		costo = new JTextField();
		TextPrompt tpCosto = new TextPrompt("Pesos", costo);
		botonAgregar = new JButton("Agregar nueva ruta");
		botonAgregar.addActionListener(e -> this.agregarRuta());
		
		gbc.weighty = 1.0;	
		gbc.weightx = 1.0;
		
		// Agregando componentes
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(labelSeleccione, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(estacionOrigen, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(estacionDestino, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(labelDistancia, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(distancia, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(labelDuracion, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(duracion, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(labelCantMaxPasajeros, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cantMaxPasajeros, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(labelEstadoRuta, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(estadoRuta, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 6;;
		this.add(labelCosto, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(costo, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.CENTER;
		botonAgregar.setPreferredSize(new Dimension(128, 26));
		botonAgregar.setMargin(new Insets(0, 0, 0, 0));
		this.add(botonAgregar, gbc);
		
	}
	
	public PanelRutaLineaDeTransporte(VentanaAltaLineaDeTransporte frame, PanelPrincipalAltaLineaDeTransporte panel, List<ElementoListaTrayecto> listaTrayecto, ElementoListaTrayecto unElemento) {
		
		this.unElemento = unElemento;
		this.gestorEstacion = GestorEstacion.getInstance();
		this.listaTrayecto = listaTrayecto;
		this.panelPadre = panel;
		this.frame = frame;
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		this.setBorder(BorderFactory.createTitledBorder("Ruta"));
		
		// Componentes
		labelSeleccione = new JLabel("Seleccione una ruta");
		
		this.obtenerEstaciones();
		
		estacionOrigen = new JComboBox<String>(opcionesEstaciones);
		estacionOrigen.setSelectedItem(unElemento.getEstacionOrigen());
		
		estacionDestino = new JComboBox<String>(opcionesEstaciones);
		estacionDestino.setSelectedItem(unElemento.getEstacionDestino());
		
		labelDistancia = new JLabel("Distancia:");
		distancia = new JTextField(String.valueOf(unElemento.getDistancia()));
		TextPrompt tpDistancia = new TextPrompt("Kilómetros", distancia);
		
		labelDuracion = new JLabel("Duración del viaje:");
		duracion = new JTextField(String.valueOf(unElemento.getDuracion()));
		TextPrompt tpDuracion = new TextPrompt("Minutos", duracion);
		
		labelCantMaxPasajeros = new JLabel("Cantidad máxima pasajeros:");
		cantMaxPasajeros = new JTextField(String.valueOf(unElemento.getCantMaxPasajeros()));
		TextPrompt tpCantMaxPasajeros = new TextPrompt("Pasajeros", cantMaxPasajeros);
		
		labelEstadoRuta = new JLabel("Estado ruta:");
		estadoRuta = new JComboBox<String>(opcionesEstado);
		estadoRuta.setSelectedItem(unElemento.getEstado());
		
		labelCosto = new JLabel("Costo:");
		costo = new JTextField(String.valueOf(unElemento.getCosto()));
		TextPrompt tpCosto = new TextPrompt("Pesos", costo);
		
		botonEliminar = new JButton("Eliminar ruta");
		botonEliminar.addActionListener(e -> eliminarRuta());
		botonModificar = new JButton("Modificar ruta");
		botonModificar.addActionListener(e -> confirmarModificacion());
		
		gbc.weighty = 1.0;	
		gbc.weightx = 1.0;
		
		// Agregando componentes
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(labelSeleccione, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(estacionOrigen, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(estacionDestino, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(labelDistancia, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(distancia, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(labelDuracion, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(duracion, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(labelCantMaxPasajeros, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cantMaxPasajeros, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(labelEstadoRuta, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(estadoRuta, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 6;;
		this.add(labelCosto, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(costo, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(botonEliminar, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.CENTER;
		botonModificar.setPreferredSize(new Dimension(128, 26));
		this.add(botonModificar, gbc);
		
	}
	
	private void confirmarModificacion() {
		
		try {
			
			inputEstaVacia();
			inputEsValida(estacionOrigen.getSelectedItem(), estacionDestino.getSelectedItem(), distancia.getText(), duracion.getText(), cantMaxPasajeros.getText(), costo.getText());
			
			listaTrayecto.remove(unElemento);
			
			unElemento.setEstacionOrigen((String) estacionOrigen.getSelectedItem());
			unElemento.setEstacionDestino((String) estacionDestino.getSelectedItem());
			unElemento.setDistancia(Integer.parseInt(distancia.getText()));
			unElemento.setDuracion(Integer.parseInt(duracion.getText()));
			unElemento.setCantMaxPasajeros(Integer.parseInt(cantMaxPasajeros.getText()));
			unElemento.setCosto(Integer.parseInt(costo.getText()));
			unElemento.setEstado((String) estadoRuta.getSelectedItem());
			
			if(listaTrayecto.contains(unElemento)) throw new RutaYaAgregadaException();
			
			Boolean seInsertoEnLaLista = false;
			Integer i = 0;
			while(i < listaTrayecto.size() && !seInsertoEnLaLista) {
				if(listaTrayecto.get(i).getEstacionOrigen() == unElemento.getEstacionDestino()) {
					listaTrayecto.add(i, unElemento);
					seInsertoEnLaLista = true;
				}
				if(listaTrayecto.get(i).getEstacionDestino() == unElemento.getEstacionOrigen()) {
					listaTrayecto.add(i+1, unElemento);
					seInsertoEnLaLista = true;
				}
				i++;
			}
			
			if(!seInsertoEnLaLista) {
				listaTrayecto.add(unElemento);
			}
			
			panelPadre.actualizar();
			
		}catch (InputVacioException IVE) {
		
			JOptionPane.showMessageDialog(frame,
										  "Faltan completar los siguientes campos:\n\n"+IVE.getMessage(),
										  "Error",
										  JOptionPane.ERROR_MESSAGE);
		}catch (InputInvalidaException IIE) {
		
			JOptionPane.showMessageDialog(frame,
										  IIE.getMessage() + "- La estacion de origen debe ser distinta a la estacion de destino. \n"
										  				   + "- La distancia debe ser un número entero mayor a 0. \n"
										  				   + "- La duración del viaje debe ser un número entero mayor a 0. \n"
										  				   + "- La cantidad máxima de pasajeros debe ser un número entero mayor a 0. \n"
										  				   + "- El costo debe ser un número mayor 0. \n",	
										  "Error",
										  JOptionPane.ERROR_MESSAGE);
			
		} catch (RutaYaAgregadaException RYAE) {
			
			JOptionPane.showMessageDialog(frame,
					  					  RYAE.getMessage(),	
					  					  "Error",
					  					  JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void eliminarRuta() {
		listaTrayecto.remove(unElemento);
		panelPadre.actualizar();
	}
	
	private void agregarRuta() {
		
		try {
			
			inputEstaVacia();
			inputEsValida(estacionOrigen.getSelectedItem(), estacionDestino.getSelectedItem(), distancia.getText(), duracion.getText(), cantMaxPasajeros.getText(), costo.getText());
		
			// En principio llegan sólo valores válidos
			ElementoListaTrayecto elementoAux = new ElementoListaTrayecto((String) estacionOrigen.getSelectedItem(),
																		  (String) estacionDestino.getSelectedItem(),
																		  Integer.parseInt(distancia.getText()),
																		  Integer.parseInt(duracion.getText()),
																		  Integer.parseInt(cantMaxPasajeros.getText()),
																		  Integer.parseInt(costo.getText()),
																		  (String) estadoRuta.getSelectedItem());
			
			if(listaTrayecto.contains(elementoAux)) throw new RutaYaAgregadaException();
			
			Boolean seInsertoEnLaLista = false;
			Integer i = 0;
			while(i < listaTrayecto.size() && !seInsertoEnLaLista) {
				if(listaTrayecto.get(i).getEstacionOrigen() == elementoAux.getEstacionDestino()) {
					listaTrayecto.add(i, elementoAux);
					seInsertoEnLaLista = true;
				}
				if(listaTrayecto.get(i).getEstacionDestino() == elementoAux.getEstacionOrigen()) {
					listaTrayecto.add(i+1, elementoAux);
					seInsertoEnLaLista = true;
				}
				i++;
			}
			
			if(!seInsertoEnLaLista) {
				listaTrayecto.add(elementoAux);
			}
			
			
			panelPadre.actualizar();
			
			
		}catch (InputVacioException IVE) {
		
			JOptionPane.showMessageDialog(frame,
										  "Faltan completar los siguientes campos:\n\n"+IVE.getMessage(),
										  "Error",
										  JOptionPane.ERROR_MESSAGE);
		}catch (InputInvalidaException IIE) {
		
			JOptionPane.showMessageDialog(frame,
										  IIE.getMessage() + "- La estacion de origen debe ser distinta a la estacion de destino. \n"
										  				   + "- La distancia debe ser un número entero mayor a 0. \n"
										  				   + "- La duración del viaje debe ser un número entero mayor a 0. \n"
										  				   + "- La cantidad máxima de pasajeros debe ser un número entero mayor a 0. \n"
										  				   + "- El costo debe ser un número mayor 0. \n",	
										  "Error",
										  JOptionPane.ERROR_MESSAGE);
			
		} catch (RutaYaAgregadaException RYAE) {
			
			JOptionPane.showMessageDialog(frame,
					  					  RYAE.getMessage(),	
					  					  "Error",
					  					  JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public void inputEstaVacia() throws InputVacioException{
		String error = "";
		boolean algunoVacio = false;
		
		if(distancia.getText().isEmpty()) {
			error += "- Distancia\n";
			algunoVacio = true;
		}
		
		if(duracion.getText().isEmpty()) {
			error += "- Duración\n";
			algunoVacio = true;
		}
		
		if(cantMaxPasajeros.getText().isEmpty()) {
			error += "- Cantidad máxima de pasajeros\n";
			algunoVacio = true;
		}
		
		if(costo.getText().isEmpty()) {
			error += "- Costo\n";
			algunoVacio = true;
		}
		
		if(algunoVacio) {
			
			throw new InputVacioException(error);
		}
			
				
	}
	
	public void inputEsValida(Object estacionOrigen, Object estacionDestino, String dist, String dur, String cantPasa, String costo) throws InputInvalidaException{
		
		// Checkear que son todos numeros y mayores a 0
		try {
			if(!(!estacionOrigen.equals(estacionDestino) && Integer.parseInt(dist) >= 0 && Integer.parseInt(dur) >= 0 && Integer.parseInt(cantPasa) >= 0 && Double.parseDouble(costo) >= 0)) {
				throw new InputInvalidaException();
			}
		}catch (NumberFormatException nfe) {
			throw new InputInvalidaException();
		}
	}
	
	private void obtenerEstaciones() {
		List<String> listaEstaciones = gestorEstacion.getStringEstaciones();
		String[] arrayEstaciones = new String[listaEstaciones.size()];
		listaEstaciones.toArray(arrayEstaciones);
		opcionesEstaciones = new String[listaEstaciones.size()];
		listaEstaciones.toArray(opcionesEstaciones);
	}
}
