package interfaces.julio.otros;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import clases.Estacion;
import clases.Ruta;
import enums.EstadoEstacion;
import gestores.GestorRuta;

	
public class ModeloTablaPageRank extends DefaultTableModel{
	
	private GestorRuta gestorRuta = GestorRuta.getInstance();
	
	 int[] anchoColumnas = {
	            50, 50, 150, 500
	        };

	public ModeloTablaPageRank() {
		this.addColumn("Id"); 
		this.addColumn("Nombre"); 
		this.addColumn("Estado");
		this.addColumn("Cantidad de caminos que llegan a la estación (Origen)");
	}
	
	public int[] getAnchoColumnas() {
		return anchoColumnas;
	}
	
	   public Class getColumnClass(int columna)
	   {
	      if (columna == 0) return Integer.class;
	      if (columna == 1) return String.class;
	      if (columna == 2) return EstadoEstacion.class;
	      if (columna == 3) return Integer.class;
	      return Object.class;
	   }
	
	   public void cargarTablaPageRank(List<Estacion> estaciones) {
		
		for(Estacion e : estaciones) {
			this.addRow(new Object[] {e.getId()
									, e.getNombre()
									, e.getEstado()
									, this.rutasEntrantesA(e)});
		}

	}
	   
	   public String rutasEntrantesA(Estacion e) {
		   
		   String resultado = null;
		   List<Ruta> rutasEntrantes = gestorRuta.getRutasEntrantesA(e);
		   
		   if(rutasEntrantes.size() == 0) {
			   
			   resultado = "0 (Ninguna ruta llega a esta estación)";
		   }
		   else {
			   
			   resultado = Integer.toString(gestorRuta.getRutasEntrantesA(e).size())+" (";
			   
			   resultado += rutasEntrantes.get(0).getOrigen();	rutasEntrantes.remove(0);
			   
			   for(Ruta r : rutasEntrantes) {
				   
				   resultado += " - " + r.getOrigen();
			   }
			   
			   resultado += ")";
		   }
		   
		   
		   return resultado;
	   }
	
}
