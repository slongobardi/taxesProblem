package taxes;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingBasket {

	private final Map<Product, Integer> productMap = new HashMap<Product, Integer>();

	DecimalFormat df = new DecimalFormat("###.00");

	public void put (Product item, int count){

		Integer i = this.productMap.get(item); 
		if ( i!= null) count += i;
		this.productMap.put(item, count);
	}

	public void remove (Product item) {
		this.productMap.remove(item);
	}

	public void clear () {
		this.productMap.clear();
	}

	public Set<Product> getItems() {
		return productMap.keySet();
	}

	public int getQuantity(Product item){
		return productMap.get(item);	
	}

	public double getTaxtotal() {
		double taxtotal = 0;
		for (Product item : productMap.keySet()){		
			double subTotal = item.getInitPrice() * getQuantity(item);
			double subInitTotal = item.getInitPrice() * getQuantity(item);
			taxtotal += subTotal - subInitTotal;
		}
		return taxtotal;
	}

	public float getTotal() {
		float total = 0;
		for (Product item : productMap.keySet()){		
			float subTotal = item.getInitPrice() * getQuantity(item);
			total += subTotal;
		}
		return Util.roundPrice(total);
	}

	public void printOrderInput() {
		System.out.println("Order input: ");
		for ( Product item : productMap.keySet() ){
			System.out.println(productMap.get(item) + " " + item.getName() + " at " + df.format(item.getInitPrice()));
		}	
		System.out.println();
	}

	public void printOrderResults() {	
		float taxtotal = 0f;
		float total = 0f;
		System.out.println("Order results: ");
		Set<Product> taxedItems = productMap.keySet();
		for (Product item : taxedItems){
			float price = TaxCalculator.getPrice(item);
			float subTotal = price * getQuantity(item);
			float subInitTotal = item.getInitPrice() * getQuantity(item);
			taxtotal += subTotal - subInitTotal;
			total += subTotal;
			System.out.println(getQuantity(item) + " " + item.getName() + ": " + df.format(subTotal));
		}
		total = Util.roundPrice(total);
		System.out.println("Sales Taxes: "+df.format(taxtotal));
		System.out.println("Total: "+df.format(total));
		System.out.println();
	}
}
