package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import clases.Trayecto;

public class TrayectoSQLImp implements TrayectoDAO{
	
	String host = "localhost";
	String port = "5432";
	String usr = "postgres";
	String pass = "ChortQuarinReynoso";
	
	@Override
	public List<Trayecto> buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertar(Trayecto trayecto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trayecto buscarTrayectoPorIdLinea(Integer idLinea) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, pass);
			conn.setAutoCommit(false);
			
			// Consulta para obtener todas las lineas de trayecto
			st = conn.prepareStatement("SELECT * " + 
									   "FROM died.trayecto " + 
									   "WHERE id_linea_de_transporte = (?)");
			st.setInt(1, idLinea);
			
			rs = st.executeQuery();
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
		}
		
		return null;
	}

}
