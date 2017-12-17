package src;

import java.io.Serializable;
import java.util.*;

public class Store implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public void AddProduct(String name,float price,int quantity,String category,String brand){
		Product newProduct=new Product(name, price, quantity, category, brand, this);
		StoreProducts.add(newProduct);
		new DataBase().InsertProductToStore(this, newProduct);
	}

	public void SellProduct(Product product, User user) {
		for(int i=0;i<StoreProducts.size();i++)
		{
			if(StoreProducts.get(i)==product)
			{
				if(StoreProducts.get(i).getQuantity()==1)
				{
					StoreProducts.remove(i);
					new DataBase().updateStoreInfo(this);
				}
				StoreProducts.get(i).setQuantity(StoreProducts.get(i).getQuantity()-1);
				new DataBase().updateProductInfo(StoreProducts.get(i));
			}
		}
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