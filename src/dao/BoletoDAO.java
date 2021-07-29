package dao;

import java.util.List;

import clases.Boleto;

public interface BoletoDAO extends DAO{
	public List<Boleto> buscar();
	public void eliminar();
	public void insertar(Boleto boleto);
	public void modificar();
}
