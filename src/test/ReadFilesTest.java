package test;

import org.junit.Test;

import taxes.Util;

public class ReadFilesTest {

	@Test
	public void testFileEntry1() {
		Util.getFromFile("shoppingListFile/in1.txt");
	}
	
	@Test
	public void testFileEntry2() {
		Util.getFromFile("shoppingListFile/in2.txt");
	}
	
	@Test
	public void testFileEntry3() {
		Util.getFromFile("shoppingListFile/in3.txt");
	}

}
