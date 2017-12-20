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
		StoreProducts = new ArrayList<>();
		SoldProducts = new HashMap<>();
		Owner = new StoreOwner();
		this.StoreName = SName;
		this.Owner = owner;
	}
	public Store(String SName) {
		StoreProducts = new ArrayList<>();
		SoldProducts = new HashMap<>();
		Owner = new StoreOwner();
		this.StoreName = SName;
	}
	private String StoreName;
	private List<Product> StoreProducts;
	private StoreOwner Owner;
	private Map<Product, User> SoldProducts;
	
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

	public void AddProduct(String name,float price,int quantity,String category,String brand,IDataBase dataBase){
		Product newProduct=new Product(name, price, quantity, category, brand, this);
		StoreProducts.add(newProduct);
		dataBase.InsertProductToStore(this, newProduct);
	}

	public float SellProduct(Product product, User user,IDataBase dataBase) {
		float balance=0;
		for(int i=0;i<StoreProducts.size();i++)
		{
			if(StoreProducts.get(i)==product)
			{
				if(StoreProducts.get(i).getQuantity()==1)
				{
					Product temp=StoreProducts.get(i);
					StoreProducts.remove(i);
					dataBase.deleteProduct(temp);
					balance=product.getPrice();
					break;
				}
				StoreProducts.get(i).setQuantity(StoreProducts.get(i).getQuantity()-1);
				balance=product.getPrice();
				//dataBase.updateProductInfo(StoreProducts.get(i));
			}
		}
		SoldProducts.put(product, user);
		return balance;
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