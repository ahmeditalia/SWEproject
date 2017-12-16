package src;

/**
 * 
 */
public class Product {

	/**
	 * Default constructor
	 */
	public Product() {
	}

	public Product(String productName, String category, String brand) {
		Name = productName;
		Category = category;
		Brand = brand;
	}

	public Product(String id, String name, float price, int quantity, String category, String brand, Store store) {
		Name = name;
		ID = id;
		Price = price;
		Quantity = quantity;
		Category = category;
		Brand = brand;
		this.store = store;
	}

	private String Name;
	private String ID;
	private float Price;
	private int Quantity;
	private String Category;
	private String Brand;
	private Store store;
	private int Views;

	public String getName() {
		return Name;
	}

	public void setName(String value) {
		this.Name = value;
	}

	public String getID() {
		return ID;
	}

	public void setID(String value) {
		this.ID = value;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float value) {
		Price = value;
	}

	/**
	 * @return
	 */
	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int value) {
		Quantity = value;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String value) {
		this.Category = value;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String value) {
		this.Brand = value;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store value) {
		this.store = value;
	}

	public int getViews() {
		return Views;
	}

	public void setViews(int views) {
		Views = views;
	}

}