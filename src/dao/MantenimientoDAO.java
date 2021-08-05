package dao;

import java.time.LocalDate;
import java.util.List;

import clases.Mantenimiento;

public interface MantenimientoDAO extends DAO{
	public List<Mantenimiento> buscar();
	public void eliminar(Mantenimiento mantenimiento);
	public void insertar(Mantenimiento mantenimiento) ;
	public void modificar(Mantenimiento mantenimiento, LocalDate fF);
	public Integer getUltimoIdMantenimiento();
}
