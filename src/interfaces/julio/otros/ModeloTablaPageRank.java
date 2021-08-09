package interfaces.julio.otros;

import java.util.Hashtable;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import clases.Estacion;
import clases.Ruta;
import enums.EstadoEstacion;
import gestores.GestorRuta;

	
public class ModeloTablaPageRank extends DefaultTableModel{
	
	private GestorRuta gestorRuta = GestorRuta.getInstance();
	
	private static final Integer maximasIteraciones = 100;
	private static final double tolerancia = 0.0001;
	
	private Hashtable<Integer, Double> tablaHashImportancia = new Hashtable<Integer, Double>();
	
	public ModeloTablaPageRank() {
		this.addColumn("Id"); 
		this.addColumn("Nombre"); 
		this.addColumn("Estado");
		this.addColumn("Cantidad de caminos que llegan a la estación (Origen)");
		this.addColumn("Importancia (0 - 1)");
		
		
	}
	
	public void iniciarTablaHashImportancia(List<Estacion> estaciones) {
		
		for(Estacion e : estaciones) {
			
			tablaHashImportancia.put(e.getId(), 1.0);	//Comienza con todas las importancias en 1
		}
	}
	
	   public Class getColumnClass(int columna)
	   {
	      if (columna == 0) return Integer.class;
	      if (columna == 1) return String.class;
	      if (columna == 2) return EstadoEstacion.class;
	      if (columna == 3) return Integer.class;
	      if (columna == 4) return Double.class;
	      return Object.class;
	   }
	
	   public void cargarTablaPageRank(List<Estacion> estaciones, Double amortiguacion) {
		   
		   this.iniciarTablaHashImportancia(estaciones);
		
		   for(Estacion e : estaciones) {
				
				this.calcularPageRank(e, estaciones, amortiguacion);
				
				this.addRow(new Object[] {e.getId()
										, e.getNombre()
										, e.getEstado()
										, this.rutasEntrantesA(e)
										, String.format("%.3f", tablaHashImportancia.get(e.getId()) /*tablaHashImportancia.get(e.getId()*/)});
		   }

	}
	   
	   private void calcularPageRank(Estacion e, List<Estacion> estaciones, Double d) {
		
//		   def update_pagerank(self, d, n):
//			   in_neighbors = self.parents
//			   pagerank_sum = sum((node.pagerank / len(node.children)) for node in in_neighbors)
//			   random_walk = d / n
//			   self.pagerank = random_walk + (1-d) * pagerank_sum
		   
		   Hashtable<Integer, Double> tablaAnterior = (Hashtable<Integer, Double>) tablaHashImportancia.clone();
		   List<Ruta> rutasEntrantes;
		   Double caminata;
		   Double sumaPageRank;
		   
		   int i = 0;
		   
		   do {
			   
			   System.out.println("Estacion: "+ e.getNombre()+" iteracion: "+ i);
		   
			   rutasEntrantes = gestorRuta.getRutasEntrantesA(e);
			   
			   caminata = d / estaciones.size();
			   
			   sumaPageRank = 0.0;
			   
			   tablaAnterior.replace(e.getId(), tablaHashImportancia.get(e.getId())); //Se copian los valores para comparar luego con la tolerancia
			   
			   System.out.println(tablaAnterior.toString());
			   
			   for(Ruta r : rutasEntrantes) {

				   sumaPageRank += tablaHashImportancia.get(r.getOrigen().getId()) / gestorRuta.getRutasSaliente(r.getOrigen()).size();
			   }
			   
			   tablaHashImportancia.replace(e.getId(), caminata + (1-d) * sumaPageRank);
			   System.out.println(tablaHashImportancia.toString());
			   System.out.println("Cambio de valor: "+ tablaHashImportancia.get(e.getId()));
			   
			   i++;
			   
		   } while(i < maximasIteraciones && toleranciaAceptada(tablaAnterior.get(e.getId()), tablaHashImportancia.get(e.getId())));
		   
	}
	   
//	   public boolean toleranciaAceptada(Hashtable<Integer, Double> anterior, Hashtable<Integer, Double> actual) {
//		boolean toleranciaAlcanzada = true;
//		
//		Integer contadorDePosicionesIguales = 0;
//		
//			for(Integer i : anterior.keySet()) {
//				
//				System.out.println("Anterior: " + anterior.get(i));
//				System.out.println("Actual: " + actual.get(i));
//				if(Math.abs(anterior.get(i)-actual.get(i)) < tolerancia) {
//					contadorDePosicionesIguales++;
//				}
//			}
//			
//			System.out.println("Contador: " + contadorDePosicionesIguales);
//			
//			if(contadorDePosicionesIguales == anterior.keySet().size()) {	//Si todas las posiciones violan la tolerancia establecida
//				toleranciaAlcanzada = false;
//			}
//		
//		return toleranciaAlcanzada;
//	}
	   
	   public boolean toleranciaAceptada(Double anterior, Double actual) {
		   
		   System.out.println(anterior);
		   System.out.println(actual);
		   System.out.println(anterior-actual);
		   System.out.println(Math.abs(anterior-actual));
		   System.out.println(Math.abs(anterior-actual) < tolerancia);
		   return !(Math.abs(anterior-actual) < tolerancia);
	   }

	public void limpiarTabla() {

			this.setRowCount(0); //Elimino todas las filas de la tabla
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
