import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainApp4 {
	
	private final static float IVA = 0.21F;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable<String, Float> products= new Hashtable<String,Float>();
		boolean loop = false;
		float money = 0;
		float totalWeight = 0;
		float cashFlow = 0;
		
		// GENERAMOS CARTA DE PRODUCTOS NOMBRE - PRECIO UNIDAD 100 GRAMOS
		generateCatalogue(products);
		
		// INTRODUCIMOS LOS ALIMENTOS Y LAS UNIDADES POR CADA 100 GRAMOS DEL PRODUCTO EN EL CARRITO DE LA COMPRA
		do {
			Object food = selectFood();
			float weight = foodWeight();
			float price = priceFood(products, food, weight);
			cashFlow += price;
			totalWeight += weight;
			loop = showOption();
		}while(loop != false);
		
		money = payment();
		showPurchase(totalWeight, cashFlow, money);
		JOptionPane.showMessageDialog(null, "Vuelva pronto!");
	}
	
	public static void showPurchase(float weight, float cash, float change) {
		
		JOptionPane.showMessageDialog(null, "IVA: "+IVA+"% "+"UNIDADES: "+weight+" BRUTO: "+cash+" PVP: "+cash*IVA+" CAMBIO: "+change);
			
	}
		
	public static float payment() {
		
		float parsedCash = 0;
		String userData = JOptionPane.showInputDialog(null, "Introduzca la cantidad en efectivo","PROCESO DE PAGO");
		if (userData == null) {
			System.out.println("CANCELADO");
			System.exit(0);
		}else {
			parsedCash = Float.parseFloat(userData);
		}
		return parsedCash;
	}
		
	public static float priceFood(Hashtable<String, Float> products, Object food, float weight) {
		
		float cash = (float) products.get(food);
				
		return cash*weight;
	
	}
	
	public static float foodWeight() {
		
		float totalWeight = 0;
		String userData = JOptionPane.showInputDialog(null, "Introduzca la cantidad en kilogramos del producto", 
				"UNIDADES DE 100 KG", JOptionPane.INFORMATION_MESSAGE);
		if (userData == null) {
			System.out.println("CANCELADO");
			System.exit(0);
		}else {
			totalWeight = Float.parseFloat(userData);
		}
		return totalWeight;
	}
	
	public static Object selectFood() {
		   
		Object selectionData = JOptionPane.showInputDialog(new JFrame(), "Seleccione un producto","CASH FLOW",JOptionPane.INFORMATION_MESSAGE, null, 
				new Object[] { "Morcilla", "Queso manchego", "Jamón ibérico", "Queso roquefort", "Pan rústico", "Longaniza", "Chorizo rojo", "Carne picada", "Mortadela", "Queso de gorgonzola"}, 
				"Jamón ibérico");
		
		if (selectionData == null) {
			System.out.println("CANCELADO");
			System.exit(0);
		}
			
		return selectionData;
		
	}
	

	
	public static boolean showOption() {
		
		boolean gate = false;
		
		int n = JOptionPane.showConfirmDialog(null, "Desea añadir un nuevo producto","CASH FLOW",JOptionPane.YES_NO_OPTION);
		
		if (n == JOptionPane.YES_OPTION) {
			gate = true;
		
		} else if (n == JOptionPane.NO_OPTION) {
		
		} else {
			
		}
		return gate;
	}
		
	public static void generateCatalogue(Hashtable<String, Float> goods) {
		
		new Hashtable<String,Float>();
	
		goods.put("Morcilla", 4.50F);
		goods.put("Queso manchego", 12.50F); 
		goods.put("Jamón ibérico", 7.40F);
		goods.put("Queso roquefort", 12.15F); 
		goods.put("Pan rústico", 4.50F);
		goods.put("Longaniza", 6.50F);
		goods.put("Chorizo rojo",4.60F); 
		goods.put("Carne picada", 4.50F);
		goods.put("Mortadela", 10.20F);
		goods.put("Queso de gorgonzola", 16.20F);
		
	}
	
}
