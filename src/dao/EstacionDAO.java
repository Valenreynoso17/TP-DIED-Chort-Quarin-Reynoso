package dao;

import java.util.List;

import clases.Boleto;
import clases.Estacion;

public interface EstacionDAO {
	public List<Estacion> buscar();
	public void eliminar();
	public void insertar() ;
	public void modificar();
}
