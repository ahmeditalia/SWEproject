package src;

import java.util.*;

/**
 * 
 */
public class AdminController {

	public AdminController() {
	}

	public void AddProductToSystem(String productName, String category, String brand) {
		Product newP = new Product(productName, category, brand);

	}

	/**
	 * @return
	 */
	public List<Product> getSuggestedProducts() {
		// TODO implement here
		return null;
	}

}