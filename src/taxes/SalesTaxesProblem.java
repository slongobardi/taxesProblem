package taxes;

/**
 * main class
 * @author Simona
 *
 */
public class SalesTaxesProblem {
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Usage: shoppingListFile/filename(s)");
			System.out.println("example: shoppingListFile/in1.txt source/in2.txt");
			System.exit(0);
		}
		for (String fileName: args) Util.getFromFile(fileName);
	}

}
