/**
 * 
 */
package model;

/**
 * @author mathewalexander
 *
 */
public class Product {

	private String sku;
	private String producttype; 
	private String flavor;
	private double cost;
	private double price;
	private int quantity;

	/**
	 
	 * @param sku
	 * @param producttype
	 * @param flavor
	 * @param cost
	 * @param price
	 * @param quantity
	 */
	public Product( String sku, String producttype, String flavor, double cost, double price, int quantity) {
		
		this.sku = sku;
		this.producttype = producttype;
		this.flavor = flavor;
		this.cost = cost;
		this.price = price;
		this.quantity = quantity;
	}

	public Product() {
	
		this.sku = "nosku";
		this.producttype = "no type";
		this.flavor = "no falvor";
		this.cost = 0;
		this.price = 0;
		this.quantity =0;
	}
	
	
	

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the type
	 */
	public String getproducttype() {
		return producttype;
	}

	/**
	 * @param type the type to set
	 */
	public void setproducttype(String ProductType) {
		this.producttype = ProductType;
	}

	/**
	 * @return the flavor
	 */
	public String getFlavor() {
		return flavor;
	}

	/**
	 * @param flavor the flavor to set
	 */
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [SKU=" + sku + ", Product Type=" + producttype + ", Flavor=" + flavor + ", Cost="
				+ cost + ", Price=" + price + ", Quantity=" + quantity + "]";
	}
	

}

