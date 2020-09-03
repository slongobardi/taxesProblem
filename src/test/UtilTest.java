package test;

import static org.junit.Assert.*;

import org.junit.Test;

import taxes.Util;

public class UtilTest {

	@Test
	public void testNearest5Percent() {
		assertTrue(Math.abs((Util.nearest5Percent(1.03f)) - 1.05) < 0.0001);
	}

	@Test
	public void testRoundPrice() {
		assertTrue(Math.abs((Util.roundPrice(10.125456f) - 10.12)) > 0.008);
	}

	@Test
	public void testIsExempt() {
		assertTrue(Util.isExempt("book"));
	}

}
