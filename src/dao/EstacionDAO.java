package dao;

import java.util.List;

import clases.Boleto;
import clases.Estacion;

public interface EstacionDAO {
	public List<Estacion> buscar();
	public void eliminar(Estacion estacion);
	public void insertar(Estacion estacion) ;
	public void modificar(Estacion estacion);
	public void actualizarPosicion(List<Estacion> estacion);
}
