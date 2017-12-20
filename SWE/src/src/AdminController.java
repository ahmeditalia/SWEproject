package src;

import java.util.*;

/**
 * 
 */
public class AdminController {

	
	private Administrator admin;
	private IDataBase database;
	
	public AdminController() {
	}
	public AdminController(Administrator admin, IDataBase dataBase) {
		this.admin=admin;
		this.database=dataBase;
	}
	public void AddProductToSystem(String productName, String category, String brand) {
		Product newP = new Product(productName, category, brand);
		database.InsertProductToSystem(newP);
	}

	public List<Product> getSuggestedProducts() {
		return database.RetreiveSuggestedProduct();
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	
	public List<String> getCategories()
	{
		return database.RetreiveCategoriesNames();
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
		database.provideVoucherCard(voucherNo);
		return voucherNo;
	}
	public void addBrandToSystem(String bName){
		database.InsertBrand(bName);
	}
	public List<String> getSysBrands(){
		return database.RetreiveBrandsNames();
	}
}