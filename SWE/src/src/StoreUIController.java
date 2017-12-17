package src;

import java.util.*;

/**
 * 
 */
public class StoreUIController {

	/**
	 * Default constructor
	 */
	public StoreUIController() {
	}

	public StoreUIController(StoreOwner user) {
		CurrentUser = user;
	}

	private StoreOwner CurrentUser;
	private Store CurrentStore;

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addNewStore(String Sname) {
		CurrentUser.AddNewStore(Sname);
	}

	public List<String> getBrandsNames() {
		return new DataBase().RetreiveBrandsNames();
	}

	public List<String> getCategoriesNames() {
		return new DataBase().RetreiveCategoriesNames();
	}

	public Store searchForStore(String sName) {
		return CurrentUser.searchForStore(sName);
	}

	public void setCurrentStore(String currS) {
		CurrentStore = searchForStore(currS);
	}

	public Store getCurrentStore() {
		return CurrentStore;
	}

	public void AddProduct(String ProductName, float price, int quantity, String category, String brand) {
		CurrentStore.AddProduct(ProductName, price, quantity, category, brand);
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

	/**
	 * @return
	 */

	public void SuggestProduct(String productName, String Category, String Brand) {
		new DataBase().InsertSuggestedProduct(new Product(productName, Category, Brand));
	}

	/**
	 * @return
	 */
	public List<Product> GetSystemProducts() {
		return new DataBase().RetreiveSysProducts();
	}

	public void ChangeStore(int storeindex) {
		this.CurrentStore=CurrentUser.getOwnedStores().get(storeindex);
	}
}