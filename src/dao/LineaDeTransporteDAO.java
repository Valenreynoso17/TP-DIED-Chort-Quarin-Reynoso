package dao;

import java.util.List;

import clases.LineaDeTransporte;

public interface LineaDeTransporteDAO {
	public List<LineaDeTransporte> buscar();
	public void eliminar();
	public void insertar(LineaDeTransporte lineaDeTransporte);
	public void modificar();
}
