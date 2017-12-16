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

<<<<<<< HEAD
	}

	/**
	 * @return
	 */
	public List<Product> getSuggestedProducts() {
		// TODO implement here
		return null;
	}

    public void AddProductToSystem(String productName, String category, String brand) {
        // TODO implement here
    }
    public List<Product> getSuggestedProducts() {
        // TODO implement here
        return null;
    }
>>>>>>> c439e86e104a5a72cba153e7e197d2c9fcf32a38

}