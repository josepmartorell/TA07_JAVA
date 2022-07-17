import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * @author jtech
 *
 */
public class MainApp2 extends JFrame{
	
	private final static float IVA = 0.21F;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<String, Float> goods = new Hashtable<String, Float>();
		boolean loop = false;
		float cash = 0;
		int unidades = 0;
		
		// GENERAMOS LOS ARTICULOS DEL SUPERMERCADO
		generateGoods(goods);
		
		// PASAMOS POR CAJA LOS ARTICULOS Y SU CANTIDAD HASTA PULSAR LA OPCION SALIR
		do {
			Object article = selectArticle();
			int units = inputUnits();
			float amount = priceArticle(goods, article, units);
			cash += amount;
			unidades += unidades;
			loop = showOption();
		}while(loop != false);
		
		float money = payment();
		showPurchase(unidades, cash, money);
		JOptionPane.showMessageDialog(null, "Feliz compra!");

	}
	
	/**
	 * Shows the purchase
	 */
	public static void showPurchase(int units, float cash, float change) {
		
		JOptionPane.showMessageDialog(null, "IVA: "+IVA+"% "+"UNIDADES: "+units+" BRUTO: "+cash+" PVP: "+cash*IVA+" CAMBIO: "+change);
			
	}
	
	public static float payment() {
		
		float parsedCash = 0;
		String userData = JOptionPane.showInputDialog(null, "Introduzca la cantidad en efectivo","PROCESO DE PAGO");
		if (userData == null) {
			System.out.println("CANCELADO");
			System.exit(0);
		}else {
			parsedCash = Integer.parseInt(userData);
		}
		return parsedCash;
	}
	
	public static void generateGoods(Hashtable<String, Float> goods) {
		
		goods.put("Boligrafo", 2.50F);
		goods.put("Zapatillas", 12.50F); 
		goods.put("Guantes", 6.40F);
		goods.put("Camiseta", 12.15F); 
		goods.put("Bombilla", 2.50F);
		goods.put("Abanico", 3.50F);
		goods.put("Sombrero",60.60F); 
		goods.put("Cortinas", 16.50F);
		goods.put("Armilla", 29.20F);
		goods.put("Lámpara", 78.20F);
		
	}
	
	/**
	 * cash flow 
	 */
	public static float priceArticle(Hashtable<String, Float> goods, Object article,int units) {
		
		float cash = (float) goods.get(article);
				
		return cash*units;
	
	}
	

	/**
	 * Article selector input
	 */
	public static Object selectArticle() {
	   
		Object selectionData = JOptionPane.showInputDialog(new JFrame(), "Seleccione un artículo","FLUJO DE CAJA",JOptionPane.INFORMATION_MESSAGE, null, 
				new Object[] { "Boligrafo", "Zapatillas", "Guantes", "Camiseta", "Bombilla", "Abanico", "Sombrero", "Cortinas", "Armilla", "Lámpara" }, 
				"Boligrafo");
		
		if (selectionData == null) {
			System.out.println("CANCELADO");
			System.exit(0);
		}
			
		return selectionData;
		
	}
	   
	/**
	 * Article units input
	 */
	public static int inputUnits() {
		 
	   int units = 0;	
	   String userData = JOptionPane.showInputDialog(null,"Cantidad de unidades del artículo","FLUJO DE CAJA",JOptionPane.INFORMATION_MESSAGE);
	   
		if (userData == null) {
			System.out.println("CANCELADO");
			System.exit(0);
		}else {
			units = Integer.parseInt(userData);
		}
		return units;


   }
	
	/**
	 * @return a boolean to break the cash flow loop
	 */
	public static boolean showOption() {
		
		boolean gate = false;
		
		int n = JOptionPane.showConfirmDialog(null, "Pase por caja el siguiente producto","FLUJO DE CAJA",JOptionPane.YES_NO_OPTION);
		
		if (n == JOptionPane.YES_OPTION) {
			gate = true;
		
		} else if (n == JOptionPane.NO_OPTION) {
		
		} else {
			
		}
		return gate;
				
	}
   
	/**
	 * @param priceUnit
	 * @param units
	 * @return priceUnit*units*VAT;
	 * 
	 * Calculate final price for 
	 */
	public static float calculatePriceVAT(float total, int units ) {
	   
	   return total*IVA;

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

	   



