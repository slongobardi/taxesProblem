package taxes;

/**
 * define product to be sold
 * @author Simona
 *
 */
public class Product {

	private String name;
	private boolean isImported = false;
	private boolean isExempt = false;
	private float initPrice;

	public Product(String name, float initPrice) {
		this.name = name;
		this.initPrice = initPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public boolean isExempt() {
		return isExempt;
	}

	public void setExempt(boolean isExempt) {
		this.isExempt = isExempt;
	}

	public void setInitPrice(float price) {
		this.initPrice = price;
	}

	public float getInitPrice() {
		return this.initPrice;
	}
	

	@Override
	public int hashCode() {
		return name.hashCode() + new Integer((int) (initPrice * 100));
	}
	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		} else if (obj instanceof Product) {
			return (((Product) obj).hashCode() == this.hashCode());

		} else
			return false;
	}

}