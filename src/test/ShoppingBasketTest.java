package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import taxes.ProductParser;
import taxes.ShoppingBasket;

public class ShoppingBasketTest {

	
	@Test
	public void testInputMultipleItems() {
		ShoppingBasket sc = new ShoppingBasket();
		sc.put(ProductParser.parser("2 book at 12.49"), ProductParser.count("2 book at 12.49"));
		sc.put(ProductParser.parser("2 music CD at 14.99"), ProductParser.count("2 music CD at 14.99"));
		sc.put(ProductParser.parser("2 chocolate bar at 0.85"), ProductParser.count("2 chocolate bar at 0.85"));
		sc.printOrderInput();
		sc.printOrderResults();
	}

	@Test
	public void testDoubleEntry() {
		ShoppingBasket sc = new ShoppingBasket();
		sc.put(ProductParser.parser("2 book at 10.00"), ProductParser.count("2 book at 10.00"));
		sc.put(ProductParser.parser("2 book at 100.00"), ProductParser.count("2 book at 100.00"));
		sc.printOrderInput();
		sc.printOrderResults();
		assertTrue(sc.getItems().size() == 2);
	}

	@Test
	public void testDoubEntry() {
		ShoppingBasket sc = new ShoppingBasket();
		sc.put(ProductParser.parser("2 book at 10.00"), ProductParser.count("2 book at 10.00"));
		sc.put(ProductParser.parser("2 book at 10.00"), ProductParser.count("2 book at 10.00"));
		sc.printOrderInput();
		sc.printOrderResults();
		assertTrue(sc.getItems().size() == 1);
	}
}
