package taxes;

/**
 * Calculate product tax according to its type and import state
 * @author Simona
 *
 */
public class TaxCalculator {

	public static float getPrice(Product product){
		float tax = 0f;
		float rate = 0.1f;
		float importRate = 0.05f;
		if(product.isExempt()) rate = 0;
		if ( product.isImported()) rate += importRate;
		tax = Util.nearest5Percent(product.getInitPrice() * rate);
		return Util.roundPrice(product.getInitPrice() + tax);
	}

}