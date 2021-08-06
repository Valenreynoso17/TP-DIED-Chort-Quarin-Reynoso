package gestores;

import java.awt.Point;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import clases.Estacion;
import clases.Mantenimiento;
import dao.EstacionDAO;
import dao.EstacionPostgreSQLImpl;
import dao.MantenimientoDAO;
import dao.MantenimientoPostgreSQLImpl;
import enums.EstadoEstacion;

public class GestorMantenimiento {
	
	private List<Mantenimiento> mantenimientos;
	private static GestorMantenimiento gestor;
	private static Integer siguienteIdMantenimiento;
	private MantenimientoDAO dao;
	
	private GestorMantenimiento() {
		dao = new MantenimientoPostgreSQLImpl();
		mantenimientos = new ArrayList<>(dao.buscar());
		Thread t1 = new Thread(() -> {
			siguienteIdMantenimiento = dao.getUltimoIdMantenimiento() + 1;
		});
		t1.run();
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
	
	public Mantenimiento agregarMantenimiento(LocalDate fI, String o, Integer iE) {
		Mantenimiento m = new Mantenimiento(siguienteIdMantenimiento, fI, o, iE);
		mantenimientos.add(m);
		dao.insertar(m);
		return m;
	}
	
	public void modificarFechaFin(Mantenimiento m, LocalDate fF) {
		
		m.setFechaFin(fF);
		dao.modificar(m, fF);
	}
	
	public List<Mantenimiento> buscarMantenimientosAsociadosAEstacionPorId(Integer idEst){
		return mantenimientos.stream().filter(r -> r.getIdEstacion() == idEst).collect(Collectors.toList());
	}
	
	

}
