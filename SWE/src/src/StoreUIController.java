package src;

import java.util.*;

/**
 * 
 */
public class StoreUIController {

	/**
	 * Default constructor
	 */
	private IDataBase dataBase;
	public StoreUIController() {
	}

	public StoreUIController(StoreOwner user,IDataBase data) {
		CurrentUser = user;
		dataBase=data;
	}

	private StoreOwner CurrentUser;
	private Store CurrentStore;

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addNewStore(String Sname) {
		CurrentUser.AddNewStore(Sname,dataBase);
	}

	public List<String> getBrandsNames() {
		return dataBase.RetreiveBrandsNames();
	}

	public List<String> getCategoriesNames() {
		return dataBase.RetreiveCategoriesNames();
	}


	public Store getCurrentStore() {
		return CurrentStore;
	}

	public void AddProduct(String ProductName, float price, int quantity, String category, String brand) {
		CurrentStore.AddProduct(ProductName, price, quantity, category, brand,dataBase);
	}

	public StoreOwner getCurrentUser() {
		return CurrentUser;
	}

	/**
	 * @param value
	 */
	public void setCurrentUser(StoreOwner value) {
		this.CurrentUser = value;
	}

	public void SuggestProduct(String productName, String Category, String Brand) {
		dataBase.InsertSuggestedProduct(new Product(productName, Category, Brand));
	}

	/**
	 * @return
	 */
	public List<Product> getCategoryProducts(String categoryName){
		return dataBase.RetreiveCategoryProducts(categoryName);
	}
	public List<Product> GetSystemProducts() {
		return dataBase.RetreiveSysProducts();
	}
	public void setCurrentStore(int storeindex) {
		this.CurrentStore=CurrentUser.getOwnedStores().get(storeindex);
	}
}