package src;



import java.util.*;

/**
 * 
 */
public interface IDataBase {


	public void writeAll();
	
	public void readAll();
	
    public List<Product> RetreiveProduct(String ProductName);

    public User RetreiveUser(String username, String password);

    public List<String> RetreiveCategoriesNames();

    public List<String> RetreiveBrandsNames();

    public List<Product> RetreiveCategoryProducts(String categoryName);
    
    public List<Product> RetreiveAllProducts();
    
    public List<String> RetreiveStoreNames();

    public List<Product> RetreiveSuggestedProduct();

    public void InsertUser(User NewUser);

    public void InsertProductToStore(Store store, Product product);

    public List<Product> RetreiveSysProducts();

    public void InsertProductToSystem(Product product);
    
    public void InsertBrand(String bName);

    public void InsertSuggestedProduct(Product product);

    public void InsertNewStore(Store store);
    
    public void provideVoucherCard(String VoucherNo);
    
    public boolean CheckVoucherCard(String VoucherNo);
        
    public void deleteProduct(Product product);
}