package gestores;

import java.awt.Point;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import clases.Estacion;
import clases.Mantenimiento;
import dao.EstacionDAO;
import dao.EstacionPostgreSQLImpl;
import enums.EstadoEstacion;

public class GestorMantenimiento {
	
	private List<Mantenimiento> mantenimientos;
	private static GestorMantenimiento gestor;
	private GestorEstacion gestorEstacion;	//ver si se usa
	private EstacionDAO dao;
	
	private GestorMantenimiento() {
		dao = new MantenimientoPostgreSQLImpl();
		mantenimientos = new ArrayList<>(dao.buscar());
	}
	
	public static GestorMantenimiento getInstance() {
		if (gestor == null) {
			gestor = new GestorMantenimiento();
		}
		
		return gestor;
	}
	
	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}
	
	public void agregarMantenimiento(Integer i, LocalDate fI, String o) {
		mantenimientos.add(new Mantenimiento(i, fI, o));
	}

}
