package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import clases.Boleto;
import clases.Recorrido;

public class BoletoPostgreSQLImpl implements BoletoDAO {
	private String ip, port, usr, psw;
	
	public BoletoPostgreSQLImpl() {
		this.ip = "localhost";
		this.port = "5432";
		this.usr = "postgres";
		this.psw = "DarkSouls";
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertar(Boleto boleto) {
		Recorrido recorrido = boleto.getRecorrido();
		String obtenerID = 		"SELECT max(id)"
							+ 	"FROM died.recorrido;";
		String insercionRecorrido = 	"INSERT INTO died.recorrido "
									+ 	"VALUES (?, ?, ?, ?, ?, ?);";
		String insercionBoleto = 	"INSERT INTO died.boleto "
								+ 	"VALUES (?, ?, ?, ?, ?);";
		Integer id = null;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ ip + ":" + port + "/", usr, psw);
			
			// Se realiza una consulta para encontrar el id correspondiente al siguiente recorrido
			st = conn.prepareStatement(obtenerID);
			rs = st.executeQuery();
			rs.next();
			id = rs.getInt("max");
			if (rs.wasNull()) id = 1;
			else id += 1;
			rs.close();
			st.close();
			
			try {
				conn.setAutoCommit(false);
				// Se insertan los datos del recorrido
				st = conn.prepareStatement(insercionRecorrido);
				st.setInt(1, id);
				st.setInt(2, recorrido.getDistancia());
				st.setInt(3, recorrido.getDuracion());
				st.setDouble(4, recorrido.getCosto());
				st.setInt(5, Integer.parseInt(recorrido.getOrigen().getId()));
				st.setInt(6, 2);
				st.executeUpdate();
				st.close();
				
				// Se insertan datos del boleto
				st = conn.prepareStatement(insercionBoleto);
				st.setInt(1, boleto.getNroBoleto());
				st.setString(2, boleto.getNombreCliente());
				st.setString(3, boleto.getCorreoCliente());
				st.setDate(4, Date.valueOf(boleto.getFechaVenta()));
				st.setInt(5, id);		
				st.executeUpdate();
				conn.commit();
			}
			catch (SQLException e) {
				conn.rollback();
			}
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}	
		}
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Boleto> buscar() {
		// TODO Auto-generated method stub
		return null;
	}

}
