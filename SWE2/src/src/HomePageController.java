package src;

import java.util.*;

public class HomePageController {
	private NormalUser user;

	HomePageController() {
		user = new NormalUser();
	}

	public void LogIn(String username, String password) {
		IDataBase IDataBase1 = new DataBase();
		if (IDataBase1.RetreiveUser(username, password).getType() == 1) {
			user = new NormalUser();
		} else if (IDataBase1.RetreiveUser(username, password).getType() == 2) {
			StoreOwner userTmb = (StoreOwner) IDataBase1.RetreiveUser(username, password);
			new StoreUI(userTmb);
		}
	}

	public List<Product> DirectSearch(String SearchText) {
		IDataBase IDataBase1 = new DataBase();
		return (IDataBase1.RetreiveProduct(SearchText));
	}

	public List<Product> Explore(String categoryName) {
		IDataBase IDataBase1 = new DataBase();
		return (IDataBase1.RetreiveCategoryProducts(categoryName));
	}

	public void AddToCart(Product product) {
		((NormalUser) user).AddToCart(product);
	}

	public void Register(String username, String password, String email, String phoneNumber, String gender,
			String address, int accountType) {
		IDataBase IDataBase1 = new DataBase();
		User userTemb = new User();
		userTemb.setUsername(username);
		userTemb.setPassword(password);
		userTemb.setAddress(address);
		userTemb.setPhoneNumber(phoneNumber);
		userTemb.setGender(gender);
		userTemb.setType((byte) accountType);
		IDataBase1.InsertUser(userTemb);
	}

	public NormalUser getUser() {
		return user;
	}

	public void setUser(NormalUser value) {
		user = value;
	}

	public List<String> GetCategoriesNames() {
		IDataBase IDataBase1 = new DataBase();
		return (IDataBase1.RetreiveCategoriesNames());
	}
}