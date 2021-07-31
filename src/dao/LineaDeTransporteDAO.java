package dao;

import java.util.List;

import clases.LineaDeTransporte;

public interface LineaDeTransporteDAO {
	public List<LineaDeTransporte> buscar();
	public void eliminar(LineaDeTransporte lineaDetransporte);
	public void insertar(LineaDeTransporte lineaDeTransporte);
	public void modificar();
}
