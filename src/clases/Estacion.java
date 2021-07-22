package clases;

<<<<<<< HEAD
public class Estacion {
=======
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import enums.EstadoEstacion;

public class Estacion {
	
	private String id;
	private String nombre;
	private EstadoEstacion estado;
	private LocalTime horarioApertura;
	private LocalTime horarioCierre;
	
	private List<Mantenimiento> mantenimientos;
	
	//private Point posicion; //VER
	
	public Estacion(String i, String n, LocalTime hA, LocalTime hC) {
		this.id = i;
		this.nombre = n;
		this.horarioApertura = hA;
		this.horarioCierre = hC;
		this.estado = EstadoEstacion.OPERATIVA;
		this.mantenimientos = new ArrayList<Mantenimiento>();
	}
	
	public void aniadirMantenimiento(Mantenimiento m) {
		this.mantenimientos.add(m);
	}
	
>>>>>>> 4676fe1 (Atributos y generadores)

}
