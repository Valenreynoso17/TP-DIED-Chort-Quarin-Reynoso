package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.CustomColor;
import clases.Estacion;
import clases.LineaDeTransporte;
import clases.Ruta;
import excepciones.InputInvalidaException;
import excepciones.InputVacioException;
import excepciones.NombreColorEnUsoException;
import excepciones.RutaYaAgregadaException;
import excepciones.TrayectoInvalidoException;
import excepciones.TrayectoVacioException;
import gestores.GestorLineaDeTransporte;
import interfaces.fede.panelesGrafos.PanelGrafico;
import interfaces.fede.panelesGrafos.PanelPintaTodo;
import interfaces.valen.frames.VentanaAltaLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;
import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;
import interfaces.valen.otros.ElementoListaTrayecto;

public class PanelPrincipalAltaLineaDeTransporte extends JPanel{
	
	PanelAltaLineaDeTransporte panelAlta;
	PanelRutaLineaDeTransporte panelRuta;
	PanelTrayectoLineaDeTransporte panelTrayecto;
	GridBagConstraints gbc;
	JButton botonCancelar;
	JButton botonSiguiente;
	VentanaAltaLineaDeTransporte frame;
	
	List<ElementoListaTrayecto> listaTrayecto;
	
	public PanelPrincipalAltaLineaDeTransporte(VentanaAltaLineaDeTransporte frame) {
		
		this.frame = frame;
		listaTrayecto = new LinkedList<ElementoListaTrayecto>();
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		
		// PanelAltaLinea
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		panelAlta = new PanelAltaLineaDeTransporte(frame);
		this.add(panelAlta, gbc);
		
		//PanelGrafo
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridheight = 3;
		PanelPintaTodo panelGrafo = new PanelPintaTodo();
		JScrollPane panelScrollGrafo = new JScrollPane(panelGrafo);
		panelScrollGrafo.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Líneas de transporte"));
		this.add(panelScrollGrafo, gbc);
		gbc.gridheight = 1;
		gbc.weightx = 0.0;
		
		// PanelRuta
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridheight = 2;
		panelRuta = new PanelRutaLineaDeTransporte(frame, this, listaTrayecto);
		this.add(panelRuta, gbc);
		gbc.gridheight = 1;
		
		
		// PanelTrayecto
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panelTrayecto = new PanelTrayectoLineaDeTransporte(this, listaTrayecto);
		this.add(panelTrayecto, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		// Boton Cancelar
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(e -> this.cancelar());
		this.add(botonCancelar, gbc);
		
		// Boton Siguiente
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.addActionListener(e -> this.siguientePantalla());
		this.add(botonSiguiente, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
	}
	
	public void actualizar() {

		this.remove(panelRuta);
    	this.remove(panelTrayecto);
    	
    	this.revalidate();
    	this.repaint();
    	
    	gbc.fill = GridBagConstraints.BOTH;
    	gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridheight = 2;
		panelRuta = new PanelRutaLineaDeTransporte(frame, this, listaTrayecto);
		this.add(panelRuta, gbc);
		gbc.gridheight = 1;
    	
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panelTrayecto = new PanelTrayectoLineaDeTransporte(this, listaTrayecto);
		this.add(panelTrayecto, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
	}
	
	public void actualizarAModoEdicion(ElementoListaTrayecto unElemento) {
		this.remove(panelRuta);
    	
    	this.revalidate();
    	this.repaint();
    	
    	gbc.fill = GridBagConstraints.BOTH;
    	gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridheight = 2;
		panelRuta = new PanelRutaLineaDeTransporte(frame, this, listaTrayecto, unElemento);
		this.add(panelRuta, gbc);
		gbc.gridheight = 1;
	}
	
	public void cancelar() {
		//Custom JOptionPane
				Object[] options = {"No",
				                    "Si"};
				int n = JOptionPane.showOptionDialog(frame,
												     "¿Está seguro que desea cancelar el alta? \n" +
												     "Todos los cambios realizados se perderán.",
												     "Cancelar alta de línea",
												     JOptionPane.YES_NO_OPTION,
												     JOptionPane.QUESTION_MESSAGE,
												     null,
												     options,
												     options[0]);
				
				if(n == JOptionPane.NO_OPTION){
					frame.dispose();
					 new VentanaGestionLineasDeTransporte();
				}
	}
	
	public void siguientePantalla() {
		
		try {
			
			inputEstaVacia();
			inputEsValida(panelAlta.getNombreLinea(), panelAlta.getColorLinea());
			nombreColorEnUso(panelAlta.getNombreLinea(), panelAlta.getColorLinea());
			trayectoVacio();
			trayectoValido();
		
			frame.setVisible(false);
			new VentanaSiguienteAltaLineaDeTransporte(frame, panelAlta.getNombreLinea(), panelAlta.getEstadoLinea(), panelAlta.getColorLinea(), listaTrayecto);
			
		}catch (InputVacioException IVE) {
		
			JOptionPane.showMessageDialog(frame,
										  "Faltan completar los siguientes campos:\n\n"+IVE.getMessage(),
										  "Error",
										  JOptionPane.ERROR_MESSAGE);
		}catch (InputInvalidaException IIE) {
		
			JOptionPane.showMessageDialog(frame,
										  IIE.getMessage() + "- El nombre de la línea debe contener menos de 30 caracteres. \n"
										  				   + "- El color seleccionado debe ser un color válido. \n",	
										  "Error",
										  JOptionPane.ERROR_MESSAGE);
			
		} catch (TrayectoVacioException TVE) {
			
			JOptionPane.showMessageDialog(frame,
					  					  TVE.getMessage(),	
					  					  "Error",
					  					  JOptionPane.ERROR_MESSAGE);
			
		} catch (NombreColorEnUsoException NCEUE) {
			
			JOptionPane.showMessageDialog(frame,
					  					  NCEUE.getMessage(),	
					  					  "Error",
					  					  JOptionPane.ERROR_MESSAGE);
			
		} catch (TrayectoInvalidoException TIE) {
			
			JOptionPane.showMessageDialog(frame,
					  TIE.getMessage(),	
					  "Error",
					  JOptionPane.ERROR_MESSAGE);
			
		}
			
	}
	
	public void inputEstaVacia() throws InputVacioException{
		String error = "";
		boolean algunoVacio = false;
		
		if(panelAlta.getNombreLinea().isEmpty()) {
			error += "- Nombre línea\n";
			algunoVacio = true;
		}
		
		if(algunoVacio) {
			
			throw new InputVacioException(error);
		}
			
				
	}
	
	public void inputEsValida(String nombreLinea, CustomColor colorL) throws InputInvalidaException{
		
		if(!(nombreLinea.length() <= 30 && colorL.getNombre() != "Ninguno")) {
			throw new InputInvalidaException();
		}
		
	}
	
	public void trayectoVacio() throws TrayectoVacioException{
		if (listaTrayecto.isEmpty()) throw new TrayectoVacioException();
	}
	
	public void trayectoValido() throws TrayectoInvalidoException {
		
		// verifica que no haya ciclos, que de una estacion salgan dos rutas ni que a una estacion insidan dos rutas
		List<String> estacionesOrigenEnUso = new ArrayList<String>();
		List<String> estacionesDestinoEnUso = new ArrayList<String>();
		
		for(ElementoListaTrayecto elem : listaTrayecto) {
			if(estacionesOrigenEnUso.contains(elem.getEstacionOrigen())) {
				throw new TrayectoInvalidoException("De una estación no pueden salir dos rutas de la misma línea.");
			} else {
				estacionesOrigenEnUso.add(elem.getEstacionOrigen());
			}
			
			if(estacionesDestinoEnUso.contains(elem.getEstacionDestino())) {
				throw new TrayectoInvalidoException("A una estación no pueden llegar dos rutas de la misma línea.");
			} else {
				estacionesDestinoEnUso.add(elem.getEstacionDestino());
			}
			
			if(estacionesOrigenEnUso.contains(elem.getEstacionDestino()) && estacionesDestinoEnUso.contains(elem.getEstacionOrigen())) {
				throw new TrayectoInvalidoException("El trayecto de la línea no puede tener ciclos.");
			} else {
				estacionesOrigenEnUso.add(elem.getEstacionOrigen());
				estacionesDestinoEnUso.add(elem.getEstacionDestino());
			}
		}
		
		
		for(int i = 0; i < listaTrayecto.size() - 1; i++) {
			if(!(listaTrayecto.get(i).getEstacionDestino() == listaTrayecto.get(i+1).getEstacionOrigen())) {
				throw new TrayectoInvalidoException("El trayecto de la línea debe ser conexo.");
			}
		}
		
		
		
	}
	
	public void nombreColorEnUso(String nomb, CustomColor col) throws NombreColorEnUsoException{
		GestorLineaDeTransporte gestorLinea = GestorLineaDeTransporte.getInstance();
		Optional<LineaDeTransporte> optionalLinea = gestorLinea.getLineasDeTransporte().stream().filter(lt -> (lt.getNombre().equals(nomb) || lt.getColor().equals(col))).findAny();
		
		if (!optionalLinea.isEmpty()) {
			throw new NombreColorEnUsoException();
		}
	}

}
