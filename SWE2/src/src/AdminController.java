package src;

import java.util.*;

/**
 * 
 */
public class AdminController {

	private IDataBase iDataBase = new DataBase();
	public AdminController() {
	}
	public void AddProductToSystem(String productName, String category, String brand) {
		Product newP = new Product(productName, category, brand);
		iDataBase.InsertProductToSystem(newP);
	}

	public List<Product> getSuggestedProducts() {
		return iDataBase.RetreiveSysProducts();
	}
}