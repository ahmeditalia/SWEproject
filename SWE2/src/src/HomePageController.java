package src;
import java.util.*;

public class HomePageController {
	private User user;
	HomePageController() {

	}
	public void LogIn(String username, String password) {
		IDataBase IDataBase1 = new DataBase();

		if (IDataBase1.RetreiveUser(username, password).getType() == 1) {
			user = new NormalUser();
			user=IDataBase1.RetreiveUser(username, password);
		} else if (IDataBase1.RetreiveUser(username, password).getType() == 2) {
			user = new StoreOwner();
			user=IDataBase1.RetreiveUser(username, password);
		}
		else if (IDataBase1.RetreiveUser(username, password).getType() == 3) {
			user = new Administrator();
			user=IDataBase1.RetreiveUser(username, password);
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

	public void Register(String username, String password, String email, String phoneNumber, String gender, String address, int accountType) {
		IDataBase IDataBase1 = new DataBase();
		if(accountType==1)
		{
			NormalUser user=new NormalUser(username,password,email,phoneNumber,gender,address,accountType);
			IDataBase1.InsertUser(user);
		}
		else if(accountType==2)
		{
			
		}
		else if(accountType==3){
			
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(NormalUser value) {
		user = value;
	}

	public List<String> getCategoriesNames() {
		IDataBase IDataBase1 = new DataBase();
		return (IDataBase1.RetreiveCategoriesNames());
	}

	public List<Product>getAllProducts(){
		IDataBase IDataBase1 = new DataBase();
		return (IDataBase1.RetreiveAllProducts());
	}
	public List<Product>getProducts(String category,String store){
		List<Product> products =getAllProducts();
		List<Product> temp=new ArrayList<Product>();
		for(int i=0;i<products.size();i++){
			if((products.get(i).getBrand()==category||category=="All")&&(products.get(i).getStore().getStoreName()==store||store=="All")){
				temp.add(products.get(i));
			}
		}
		return temp;
	}
	public boolean checkVoucherCards(String card){
		IDataBase IDataBase1 = new DataBase();
		return (IDataBase1.CheckVoucherCard(card));
	}
}