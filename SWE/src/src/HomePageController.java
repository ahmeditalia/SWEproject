package src;

import java.util.*;

public class HomePageController {
	private User user;
	private IDataBase dataBase;

	HomePageController() {
		
	}
	HomePageController(IDataBase data) {
		dataBase=data;
	}

	public void LogIn(String username, String password) {
		user = dataBase.RetreiveUser(username, password);
	}

	public List<Product> DirectSearch(String SearchText) {
		List<Product> products = dataBase.RetreiveProduct(SearchText);
		for (int i = 0; i < products.size(); i++) {
			products.get(i).updateViews();
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
			dataBase.InsertUser(user);
		} else if (accountType == 2) {
			StoreOwner user = new StoreOwner(username, password, email, phoneNumber, gender, address, accountType);
			dataBase.InsertUser(user);
		} else if (accountType == 3) {
			Administrator user = new Administrator(username, password, email, phoneNumber, gender, address,
					accountType);
			dataBase.InsertUser(user);
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(NormalUser value) {
		user = value;
	}

	public List<String> getCategoriesNames() {
		return (dataBase.RetreiveCategoriesNames());
	}
	public List<String> RetreiveStoreNames() {
		return (dataBase.RetreiveStoreNames());
	}
	public List<Product> getAllProducts() {
		return (dataBase.RetreiveAllProducts());
	}

	public List<Product> getProducts(String category, String store) {
		List<Product> products = new ArrayList<>();
		if (category.equals("All"))
			products = getAllProducts();
		else {
			products = dataBase.RetreiveCategoryProducts(category);
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
		return (dataBase.CheckVoucherCard(card));
	}
}