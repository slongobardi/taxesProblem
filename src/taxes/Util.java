package taxes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

/**
 * Helper class 
 * @author Simona
 *
 */
public class Util {

	/**
	 * HashSet to check product type
	 */
	private static Set<String> exemptProductList = null;
	static	{
		exemptProductList = new HashSet<String>();
		exemptProductList.add("book");
		exemptProductList.add("headache pills");
		exemptProductList.add("packet of headache pills");
		exemptProductList.add("box of imported chocolates");
		exemptProductList.add("imported box of chocolates");
		exemptProductList.add("box of chocolates");
		exemptProductList.add("chocolate");
		exemptProductList.add("chocolate bar");
		exemptProductList.add("pills");
	}
	/**
	 * method to rounded to the nearest 5 percent
	 * @param amount to be rounded
	 * @return
	 */
	static public float nearest5Percent(float amount) {

		return new BigDecimal(Math.ceil(amount * 20)/20).setScale(2,RoundingMode.HALF_UP).floatValue();

	}

	/**
	 * method to rounded price
	 * @param amount to be rounded
	 * @return
	 */
	public static float roundPrice(float amount) {

		return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP)
				.floatValue();

	}
	
	public static boolean isExempt(String name) {
		return exemptProductList.contains(name);
	}
	
	/**
	 * read input file and parse it
	 * @param fileName input file name
	 */
	public static void getFromFile(String fileName) {
		ShoppingBasket sc = new ShoppingBasket();
		try {
		    BufferedReader in = new BufferedReader(new FileReader(fileName));
		    String str;
		    while ((str = in.readLine()) != null) {
		    	if (ProductParser.matches(str) && !str.isEmpty())
		    		sc.put(ProductParser.parser(str), ProductParser.count(str)); 
		    		else
		    			if (!str.isEmpty()) System.out.println("unknown line format: " + str);
		    }
		    in.close();
		} catch (IOException e) {
			System.out.println("error:" + e.getMessage());
			return;
		}
		sc.printOrderInput();
		sc.printOrderResults();
	}
}