package src;

import java.util.*;

public class Store {

<<<<<<< HEAD
	public Store() {
	}

	public Store(String SName, StoreOwner owner) {
		this.StoreName = SName;
		this.Owner = owner;
	}

	private String StoreName;
	private List<Product> StoreProducts;
	private StoreOwner Owner;
	private Map<Product, User> SoldProducts;

	public void AddProduct(Product product) {

	}

	/**
	 * @param product
	 * @param Buyer
	 */
	public void SellProduct(Product product, User Buyer) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public String getStoreName() {
		// TODO implement here
		return "";
	}

	/**
	 * @param value
	 */
	public void setStoreName(String value) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public List<Product> getStoreProducts() {
		// TODO implement here
		return null;
	}

	/**
	 * @param value
	 */
	public void setStoreProducts(List<Product> value) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public StoreOwner getOwner() {
		// TODO implement here
		return null;
	}

	/**
	 * @param value
	 */
	public void setOwner(StoreOwner value) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public Map<Product, User> getSoldProducts() {
		// TODO implement here
		return null;
	}

	/**
	 * @param value
	 */
	public void setSoldProducts(Map<Product, User> value) {
		// TODO implement here
	}
=======
    /**
     * Default constructor
     */
    public Store() {
    }

    /**
     * 
     */
    private String StoreName;

    private List<Product> StoreProducts= new ArrayList<>();
    private StoreOwner Owner= new StoreOwner();
    private Map<Product,User> SoldProducts= new HashMap<>();
   
    
    public Product getMostViewedP(){
		Product mostP= new Product();
    	if (StoreProducts.size()>0){
    		mostP=StoreProducts.get(0);
        	for(int i=1;i<StoreProducts.size();i++){
        		if (StoreProducts.get(i).getViews()>mostP.getViews())
        			mostP=StoreProducts.get(i);
        	}
    	}
    	return mostP;
    }
    public void AddProduct(Product product) {
        StoreProducts.add(product);
        }
    public void SellProduct(Product product, User Buyer) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getStoreName() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setStoreName(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Product> getStoreProducts() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setStoreProducts(List<Product> value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public StoreOwner getOwner() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setOwner(StoreOwner value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Map<Product,User> getSoldProducts() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setSoldProducts(Map<Product,User> value) {
        // TODO implement here
    }
>>>>>>> e81b0ad0570a60651c62f41d0b0aade3e2d0d85a

}