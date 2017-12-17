package src;

import java.util.*;

/**
 * 
 */
public class AdminController {

	
	private Administrator admin;
	
	public AdminController() {
	}
	public AdminController(Administrator admin) {
		this.admin=admin;
	}
	public void AddProductToSystem(String productName, String category, String brand) {
		Product newP = new Product(productName, category, brand);
		new DataBase().InsertProductToSystem(newP);
	}

	public List<Product> getSuggestedProducts() {
		return new DataBase().RetreiveSuggestedProduct();
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	
	public List<String> getCategories()
	{
		return new DataBase().RetreiveCategoriesNames();
	}
	
	public String voucherGenerator()
	{
		String alphabet="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabscdefghijklmnopqrstuvwxyz";
		String voucherNo="";
		Random random=new Random();
		for(int i=0;i<6;i++)
		{
			voucherNo+=alphabet.charAt(random.nextInt(alphabet.length()));
		}
		new DataBase().provideVoucherCard(voucherNo);
		return voucherNo;
	}
}