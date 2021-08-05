package dao;

import java.util.List;

import clases.CustomColor;

public interface CustomColorDAO extends DAO {
	public List<CustomColor> buscar();
	public void insertar(CustomColor color);
}
