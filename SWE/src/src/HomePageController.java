package src;

import java.util.*;

public class HomePageController {
	private User user;

	HomePageController() {

	}

	public void LogIn(String username, String password) {
		user = new DataBase().RetreiveUser(username, password);
	}

	public List<Product> DirectSearch(String SearchText) {
		List<Product> products = new DataBase().RetreiveProduct(SearchText);
		for (int i = 0; i < products.size(); i++) {
			products.get(i).updateViews();
			new DataBase().updateProductInfo(products.get(i));
		}
		return (products);
	}


	public void AddToCart(Product product) {
		((NormalUser) user).AddToCart(product);
	}

	public void Register(String username, String password, String email, String phoneNumber, String gender,
			String address, int accountType) {

		if (accountType == 1) {
			NormalUser user = new NormalUser(username, password, email, phoneNumber, gender, address, accountType);
			new DataBase().InsertUser(user);
		} else if (accountType == 2) {
			StoreOwner user = new StoreOwner(username, password, email, phoneNumber, gender, address, accountType);
			new DataBase().InsertUser(user);
		} else if (accountType == 3) {
			Administrator user = new Administrator(username, password, email, phoneNumber, gender, address,
					accountType);
			new DataBase().InsertUser(user);
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(NormalUser value) {
		user = value;
	}

	public List<String> getCategoriesNames() {
		return (new DataBase().RetreiveCategoriesNames());
	}
	public List<String> RetreiveStoreNames() {
		return (new DataBase().RetreiveStoreNames());
	}
	public List<Product> getAllProducts() {
		return (new DataBase().RetreiveAllProducts());
	}

	public List<Product> getProducts(String category, String store) {
		List<Product> products = new ArrayList<>();
		if (category.equals("All"))
			products = getAllProducts();
		else {
			products = new DataBase().RetreiveCategoryProducts(category);
		}
		List<Product> temp = new ArrayList<Product>();
		for (int i = 0; i < products.size(); i++) {
			if ((products.get(i).getStore().getStoreName().equals(store) || store.equals("All"))) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}

	public boolean checkVoucherCards(String card) {
		return (new DataBase().CheckVoucherCard(card));
	}
}