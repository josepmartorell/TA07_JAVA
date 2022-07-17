import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * @author jtech
 *
 */
public class MainApp2 extends JFrame{
	
	private final static float VAT = 0.21F;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<String, Float> articulos = new Hashtable<String, Float>();
		
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
	 * Shows the stock
	 */
	public static void showList() {
		
		
		
	}
	
	/**
	 * Article selector input
	 */
	public static void selectArticle() {
	   
		Object selectionData = JOptionPane.showInputDialog(new JFrame(), "Seleccione un artículo","CARRITO DE LA COMPRA",JOptionPane.INFORMATION_MESSAGE, null, 
				new Object[] { "Peine", "Boligrafo", "Libreta", "Zapatillas", "Toalla", "Guantes", "Vajilla", "Olla", "Camiseta", "Bombilla", "Abanico", "Sombrero", "Cortinas", "Armilla", "Lámpara" }, 
				"Zapatillas");
   
		System.out.println("El usuario ha elegido "+selectionData);
		
		inputUnits();
			
	}
	   
	/**
	 * Adds a new article
	 */
	public static void inputUnits() {
		 
	   String userData = JOptionPane.showInputDialog(null,"Cantidad de unidades del artículo","CARRITO DE LA COMPRA",JOptionPane.PLAIN_MESSAGE);
	   System.out.println("El usuario ha elegido "+userData);

   }
   
	/**
	 * @param priceUnit
	 * @param units
	 * @return priceUnit*units*VAT;
	 * 
	 * Calculate final price for 
	 */
	public static float calculatePriceVAT(float priceUnit, int units ) {
	   
	   return priceUnit*units*VAT;

   }
	   
	/**
	 * @param money
	 * @param totalPurchase
	 * @return
	 */
	public static float change(float money, float totalPurchase) {
		   
		  float result = money-totalPurchase; 
		  
		  if (result <= -1) {
			  return -1;
		  }
		  return result;
		  
	}
	
	   
	   
}
	

	   



