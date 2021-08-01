package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Ruta;
import clases.Trayecto;
import gestores.GestorLineaDeTransporte;
import gestores.GestorRuta;

public class TrayectoSQLImp implements TrayectoDAO{
	
	String host = "localhost";
	String port = "5432";
	String usr = "postgres";
	String pass = "ChortQuarinReynoso";
	GestorRuta gestorRutas;
	
	public TrayectoSQLImp() {
		gestorRutas = GestorRuta.getInstance();
	}
	
	@Override
	public List<Trayecto> buscar() {
		
		List<Trayecto> lista = new ArrayList<Trayecto>();
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, pass);
			conn.setAutoCommit(false);
			
			// Consulta para obtener todos los trayectos
			st = conn.prepareStatement("SELECT * " + 
									   "FROM died.trayecto;");
			
			rs = st.executeQuery();
			conn.commit();
			
			while(rs.next()) { 
				Trayecto auxTray = new Trayecto(rs.getInt("id_trayecto"), rs.getInt("id_linea_de_transporte"), gestorRutas.buscarRutasAsociadasATrayectoPorID(rs.getInt("id_trayecto")));
				lista.add(auxTray);
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
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
		
		return lista;
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
}
