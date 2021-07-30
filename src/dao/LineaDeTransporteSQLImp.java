package dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.LineaDeTransporte;
import clases.Recorrido;
import enums.EstadoLineaDeTransporte;

public class LineaDeTransporteSQLImp implements LineaDeTransporteDAO{

	String host = "localhost";
	String port = "5432";
	String usr = "postgres";
	String pass = "Valen123";
	
	@Override
	public List<LineaDeTransporte> buscar() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, pass);
//			conn.setAutoCommit(false);
			
			// Consulta para obtener todas las lineas de trayecto
			st = conn.prepareStatement("SELECT * "
									 + "FROM died.linea_de_transporte AS linea, died.color AS color "
									 + "WHERE linea.id = color.id;");
			
			rs = st.executeQuery();
//			conn.commit();
			
			List<LineaDeTransporte> lista = new ArrayList<LineaDeTransporte>();
			
			while(rs.next()) {
				LineaDeTransporte auxLinea = new LineaDeTransporte(rs.getInt("id"),rs.getString("nombre"),new Color(rs.getInt("r"), rs.getInt("g"), rs.getInt("b")), EstadoLineaDeTransporte.valueOf(rs.getString("estado")), null);
				lista.add(auxLinea);
			}
			
			return lista;
			
		}catch (SQLException e) {
//			conn.rollback();
		}catch (ClassNotFoundException e) {e.printStackTrace();}
		finally {
			if (rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
		}

		return null;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertar(LineaDeTransporte lineaDeTransporte) {
		
	}	

	@Override
	public void modificar() {
		
	}
	
	public static void main(String[] args) {
		
		LineaDeTransporteSQLImp linea = new LineaDeTransporteSQLImp();
		linea.insertar(null);
	}

}


