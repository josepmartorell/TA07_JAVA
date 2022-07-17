import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainApp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<String, Float> catalogo = new Hashtable<String,Float>();
		Hashtable<String, Integer> stock = new Hashtable<String,Integer>();
		boolean nextArticle = true;
		
		// GENERAMOS AUTOMATICAMENTE UN CATÁLOGO DE 10 ARTÍCULOS Y MOSTRAMOS EL CATALOGO
		generateArticles(catalogo);
		showArticles(catalogo);
		
		// INTRODUCIMOS LOS ARTICULOSY LAS CANTIDADES DE UNIDADES EN EL STOCK GUARDANDOLOS CADA VEZ
		do {
			Object articulo = selectArticle();
			int cantidad = numArticles();
			storeArticle(stock, articulo, cantidad);
			nextArticle = showOption();
		}while(nextArticle != false);	
		
		// MOSTRAMOS EL STOCK POR PANTALLA COMPROBANDO QUE LOS ARTICULOS SE HAN AÑADIDO
		showStock(stock);
		
		// FINALMENTE SELECCIONAMOS UN ARTICULO PARA QUE NOS MUESTRE EL DETALLE		
		Object articulo = selectArticle();	
		showArticle(stock, articulo);		


	}
	
	public static void generateArticles(Hashtable<String, Float> articulos) {
		
		new Hashtable<String,Float>();
	
		articulos.put("Boligrafo", 4.50F);
		articulos.put("Zapatillas", 12.50F); 
		articulos.put("Guantes", 7.40F);
		articulos.put("Camiseta", 12.15F); 
		articulos.put("Bandolera", 4.50F);
		articulos.put("Abrigo", 49.50F);
		articulos.put("Pantalones",60.60F); 
		articulos.put("Calcetines", 4.50F);
		articulos.put("Gemelos", 29.20F);
		articulos.put("Americana", 78.20F);

		
	}
	
	
	/**
	 * @return the article selected to incorporate to stock database
	 */
	public static Object selectArticle() {
		   
		Object selectionData = JOptionPane.showInputDialog(new JFrame(), "Añadir artículo al stock","AÑADIR AL STOCK",JOptionPane.INFORMATION_MESSAGE, null, 
				new Object[] { "Boligrafo", "Zapatillas","Guantes", "Camiseta", "Bandolera", "Abrigo", "Pantalones", "Calcetines", "Gemelos", "Americana" }, 
				"Zapatillas");
		
		if (selectionData == null) {
			System.out.println("CANCELADO");
			System.exit(0);
		}
		
		return selectionData;
		
	}
	
	/**
	 * @return the amount of unities about the selected article
	 */
	public static int numArticles() {
		
		int cantidad = 0;
		String nombreAlumno = JOptionPane.showInputDialog(null, "Introduzca la cantidad de unidades del artículo", 
				"UNIDADES DEL STOCK", JOptionPane.INFORMATION_MESSAGE);
		if (nombreAlumno == null) {
			System.out.println("CANCELADO");
			System.exit(0);
		}else {
			cantidad = Integer.parseInt(nombreAlumno);
		}
		return cantidad;
	}
	
	/**
	 * @param stock
	 * @param articulo
	 * @param precio
	 */
	public static void storeArticle(Hashtable<String, Integer> stock, Object articulo, float precio) {
		
		stock.put((String) articulo, (int) precio);
	}
	
	/**
	 * @param str
	 * @param table
	 */
	public static void showArticle(Hashtable<String, Integer> table, Object articulo) {
		
		JOptionPane.showMessageDialog(null, "ARTÍCULO: "+articulo+"\nUNIDADES: "+table.get(articulo).toString().replace("{", "\n").replace("}", "").replace(",", "\n").replace("=", "").replace("'", ""), "DETALLE DEL ARTÍCULO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * @param table
	 */
	public static void showArticles(Hashtable<?, ?> table) {
		
		JOptionPane.showMessageDialog(null, table.toString().replace("{", "\n").replace("}", "").replace(",", " €\n").replace("=", " \t").replace("'", " "), "CATÁLOGO DE ARTÍCULOS", JOptionPane.INFORMATION_MESSAGE);
					
	}
	
	public static void showStock(Hashtable<?, ?> table) {
		
		JOptionPane.showMessageDialog(null, table.toString().replace("{", "\n").replace("}", "").replace(",", "\n").replace("=", " UNIDADES \t").replace("'", " "), "STOCK DE ARTÍCULOS", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * @return returns a boolean true or false according to the option selected, if false do while breaks
	 */
	public static boolean showOption() {
		
		boolean gate = false;
		
		int n = JOptionPane.showConfirmDialog(null, "Desea añadir un nuevo articulo","CURSO PROGRAMACIÓN",JOptionPane.YES_NO_OPTION);
		
		if (n == JOptionPane.YES_OPTION) {
			gate = true;
		
		} else if (n == JOptionPane.NO_OPTION) {
		
		} else {
			
		}
		return gate;
				
	}
		
		
		
}


