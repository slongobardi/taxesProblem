package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import taxes.Product;

public class TaxCalculatorTest {

	@Test
	public void testGetPrice() {
		Product product = new Product("Test", 100.00f);
		assertEquals(product.getName(), "Test");
		System.out.println(product.getInitPrice());
		assertTrue(Math.abs((product.getInitPrice() - 100.00)) < 0.001);
	
	}

}
