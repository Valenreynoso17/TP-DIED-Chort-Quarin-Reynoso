package dao;

import java.util.List;

import clases.Trayecto;

public interface TrayectoDAO {
	public List<Trayecto> buscar();
	public void eliminar();
	public void insertar(Trayecto trayecto);
	public void modificar();
	public Integer getUltimoIdTrayecto();
}
