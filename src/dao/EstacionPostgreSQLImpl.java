package dao;

import java.awt.Point;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import clases.Estacion;
import clases.Recorrido;
import enums.EstadoEstacion;
import gestores.GestorMantenimiento;

public class EstacionPostgreSQLImpl implements EstacionDAO {

	GestorMantenimiento gestorMantenimiento;
	
	public EstacionPostgreSQLImpl() {
		Thread t1 = new Thread(() -> {
			gestorMantenimiento = GestorMantenimiento.getInstance();
		});
		t1.run();
	}
	
	@Override
	public List<Estacion> buscar() {
		List<Estacion> estaciones = new ArrayList<>();
		String consulta = "SELECT * "
						+ "FROM died.estacion "
						+ "ORDER BY 1"	;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
			st = conn.prepareStatement(consulta);
			rs = st.executeQuery();
			
			while(rs.next()) {				
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String estado = rs.getString("estado");
				LocalTime horaApertura = rs.getTime("horarioapertura").toLocalTime();
				LocalTime horaCierre = rs.getTime("horariocierre").toLocalTime();
				Point posicion = new Point();
				posicion.x = rs.getInt("posicion_x");
				posicion.y = rs.getInt("posicion_y");
				
				// TODO falta agregarle que busque los mantenimientos
				if (estado.equals("OPERATIVA")) estaciones.add(new Estacion(id, nombre, horaApertura, horaCierre, posicion, EstadoEstacion.OPERATIVA, gestorMantenimiento.buscarMantenimientosAsociadosAEstacionPorId(id)));
				else estaciones.add(new Estacion(id, nombre, horaApertura, horaCierre, posicion, EstadoEstacion.EN_MANTENIMIENTO, gestorMantenimiento.buscarMantenimientosAsociadosAEstacionPorId(id)));
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
		
		return estaciones;
	}

	@Override
	public void eliminar(Estacion estacion) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			conn.setAutoCommit(false);
			
			// Borrar una tupla de la tabla implica borrar todas las instancias que la tengan como clave for�nea
			st = conn.prepareStatement( "DELETE FROM died.ruta " +
										"WHERE id_estacion_origen = (?) OR id_estacion_destino = (?);" +
	   				   					"DELETE FROM died.recorrido " +
	   				   					"WHERE id_estacion_origen = (?) OR id_estacion_destino = (?);" +
	   				   					"DELETE FROM died.mantenimiento " +
					   				    "WHERE id_estacion = (?);" +
									    "DELETE FROM died.estacion " +
									    "WHERE id = (?);");
			
			st.setInt(1, estacion.getId());
			st.setInt(2, estacion.getId());
			st.setInt(3, estacion.getId());
			st.setInt(4, estacion.getId());
			st.setInt(5, estacion.getId());
			st.setInt(6, estacion.getId());
			
			Integer nro = st.executeUpdate();
			conn.commit();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
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
	public void insertar(Estacion estacion) {

		String insercionEstacion = 	"INSERT INTO died.estacion "
								+ 	"VALUES (?, ?, ?, ?, ?);";
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// TODO Falta cargar la relacion con ruta
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
			
			st = conn.prepareStatement(insercionEstacion);
			st.setInt(1, this.getUltimoIdEstacion()+1);
			st.setString(2, estacion.getNombre());
			st.setString(3, estacion.getEstado().toString());
			st.setTime(4, Time.valueOf(estacion.getHorarioApertura()));
			st.setTime(5, Time.valueOf(estacion.getHorarioCierre()));	
			st.executeUpdate();
			
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
	public void modificar(Estacion estacion) {

		String modificacionEstacion = 	"UPDATE died.estacion "
									+ 	"SET 	nombre = ?, "
									+ 	"		estado = ?, "
									+ 	" 		horarioapertura = ?, "
									+ 	"		horariocierre = ? "
									+ 	"WHERE id = ?; ";
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
			
			st = conn.prepareStatement(modificacionEstacion);
			st.setString(1, estacion.getNombre());
			st.setString(2, estacion.getEstado().toString());
			st.setTime(3, Time.valueOf(estacion.getHorarioApertura()));
			st.setTime(4, Time.valueOf(estacion.getHorarioCierre()));	
			st.setInt(5, estacion.getId());	
			st.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
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
	public void actualizarPosicion(List<Estacion> estaciones) {
		String modificacionEstacion = 	"UPDATE died.estacion "
									+ 	"SET 	posicion_x = ?, "
									+ 	"		posicion_y = ? "
									+ 	"WHERE id = ?; ";
		
		String consulta = "";
		
		for (int i=0; i<estaciones.size(); i++) {
			consulta += modificacionEstacion;
		}
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
					
			st = conn.prepareStatement(consulta);
			
			System.out.println("Llego a modificar posicion estacion");
			
			for (int i=0; i<estaciones.size(); i++) {
				st.setInt(1 + 3*i, estaciones.get(i).getPosicion().x);
				st.setInt(2 + 3*i, estaciones.get(i).getPosicion().y);	
				st.setInt(3 + 3*i, estaciones.get(i).getId());				
			}
			
			st.executeUpdate();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
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
	public Integer getUltimoIdEstacion() {
		String obtenerID = "SELECT max(id) "
						+  "FROM died.estacion;";
		Integer id = null;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
			// Se realiza una consulta para encontrar el id correspondiente a la siguiente lineaDeTransporte
			st = conn.prepareStatement(obtenerID);
			rs = st.executeQuery();
			rs.next();
			id = rs.getInt("max");
			if (rs.wasNull()) id = 0;
			rs.close();
			st.close();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			if (rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
		}
		
		return id;
	}
	
}
