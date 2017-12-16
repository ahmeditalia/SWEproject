package src;

import java.io.Serializable;
import java.util.*;

public class Store implements Serializable{

	public Store() {
	}

	public Store(String SName, StoreOwner owner){
		this.StoreName = SName;
		this.Owner = owner;
	}
	public Store(String SName) {
		this.StoreName = SName;
		
	}
	private String StoreName;
	private List<Product> StoreProducts = new ArrayList<>();
	private StoreOwner Owner = new StoreOwner();
	private Map<Product, User> SoldProducts = new HashMap<>();
  
	public Product getMostViewedP() {
		Product mostP = new Product();
		if (StoreProducts.size() > 0) {
			mostP = StoreProducts.get(0);
			for (int i = 1; i < StoreProducts.size(); i++) {
				if (StoreProducts.get(i).getViews() > mostP.getViews())
					mostP = StoreProducts.get(i);
			}
		}
		return mostP;
	}

	public void AddProduct(Product product) {
		StoreProducts.add(product);
	}

	public void SellProduct(Product product, User user) {
		SoldProducts.put(product, user);
	}

	public String getStoreName() {
		return this.StoreName;
	}

	public void setStoreName(String value) {
		this.StoreName = value;
	}

	public List<Product> getStoreProducts() {
		return StoreProducts;
	}

	public void setStoreProducts(List<Product> value) {
		this.StoreProducts = value;
	}

	public StoreOwner getOwner() {
		return this.Owner;
	}

	public void setOwner(StoreOwner value) {
		this.Owner = value;
	}

	public Map<Product, User> getSoldProducts() {
		return this.SoldProducts;
	}

	public void setSoldProducts(Map<Product, User> value) {
		this.SoldProducts = value;
	}

}