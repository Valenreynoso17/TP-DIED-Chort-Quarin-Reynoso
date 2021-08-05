package dao;

import java.util.List;

import clases.LineaDeTransporte;

public interface LineaDeTransporteDAO extends DAO{
	public List<LineaDeTransporte> buscar();
	public void eliminar(LineaDeTransporte lineaDetransporte);
	public void insertar(LineaDeTransporte lineaDeTransporte);
	public void modificar(LineaDeTransporte lineaDeTransporte);
	public Integer getUltimoIdLinea();
}
