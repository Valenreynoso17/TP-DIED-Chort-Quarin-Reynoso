package dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.CustomColor;
import clases.LineaDeTransporte;
import enums.EstadoLineaDeTransporte;

public class CustomColorSQLImp implements CustomColorDAO{
	
	@Override
	public List<CustomColor> buscar() {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			conn.setAutoCommit(false);
			
			// Consulta para obtener todas las lineas de trayecto
			st = conn.prepareStatement("SELECT * "
									 + "FROM died.color AS color");
			
			rs = st.executeQuery();
			conn.commit();
			
			List<CustomColor> lista = new ArrayList<CustomColor>();
			
			while(rs.next()) {
				CustomColor colorAux = new CustomColor(rs.getInt("id"),rs.getString("nombre_color"), rs.getInt("r"), rs.getInt("g"), rs.getInt("b"));
				lista.add(colorAux);
			}
			
			return lista;
			
		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}catch (ClassNotFoundException e) {e.printStackTrace();}
		finally {
			if (rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
		}

		return null;
	}

	@Override
	public void insertar(CustomColor color) {		
	}

}
