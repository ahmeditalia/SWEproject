package src;

import java.io.Serializable;

/**
 * 
 */
public class Product implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
     * Default constructor
     */
	
	public Product() {
    }
	
    public Product(String name,String category,String brand) {
    	Name=name;
    	Category=category;
        Brand=brand;
        Views=0;
    }
    public Product(String name,float price,int quantity,String category,String brand,Store store){
    	Name=name;
        Price=price;
        Quantity=quantity;
        Category=category;
        Brand=brand;
        this.store=store;
        Views=0;
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
    	this.Name=value;
    }


    public String getID() {
        return ID;
    }

    public void setID(String value) {
    	this.ID=value;
    }

    public float getPrice() {
        return Price;
    }


    public void setPrice(float value) {
    	Price=value;
    }

    /**
     * @return
     */
    public int getQuantity() {
        return Quantity;
    }


    public void setQuantity(int value) {
    	Quantity=value;
    }


    public String getCategory() {
        return Category;
    }

    public void setCategory(String value) {
    	this.Category=value;
    }


    public String getBrand() {
        return Brand;
    }

    public void setBrand(String value) {
    	this.Brand=value;
    }


    public Store getStore() {
        return store;
    }


    public void setStore(Store value) {
    	this.store=value;
    }


	public int getViews() {
		return Views;
	}

	public void setViews(int views) {
		Views = views;
	}
	
	public void updateViews()
	{
		Views++;
	}

}