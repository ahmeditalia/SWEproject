package src;



import java.util.*;

/**
 * 
 */
public class StoreUIController {

    /**
     * Default constructor
     */
    public StoreUIController() {
    }

    public StoreUIController(StoreOwner user) {
		// TODO Auto-generated constructor stub
    	CurrentUser=user;
	}
    private StoreOwner CurrentUser;
    private Store CurrentStore;
    private IDataBase database= new DataBase();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addNewStore(String Sname) {
		// TODO Auto-generated method stub
    	
    	CurrentUser.AddNewStore(Sname);
    	database.InsertNewStore(new Store(Sname));
    	
	}
    public List<String> getBrandsNames(){
    	return database.RetreiveBrandsNames();
    }
    public List<String> getCategoriesNames(){
    	return database.RetreiveCategoriesNames();
    }
    
    public Store searchForStore(String sName){
    	return  CurrentUser.searchForStore(sName);
    }   
    
    public void setCurrentStore(String currS){
    	CurrentStore= searchForStore(currS);
    }
    public Store getCurrentStore() {
        // TODO implement here
        return CurrentStore;
    }
    public void AddProduct(String ProductName, float price, int quantity, String category, String brand) {
    	Product newP= new Product();
		newP.setName(ProductName);
		newP.setPrice(price);
		newP.setQuantity(quantity);
		newP.setCategory(category);
		newP.setBrand(brand);
		CurrentUser.AddProductToStore(newP,CurrentStore.getStoreName());
		database.InsertProductToStore(CurrentStore, newP);
    }

    public StoreOwner getCurrentUser() {
        // TODO implement here
        return CurrentUser;
    }

    /**
     * @param value
     */
    public void setCurrentUser(StoreOwner value) {
        // TODO implement here
    }

    /**
     * @return
     */
     
    public void SuggestProduct(String productName, String Category, String Brand) {
        // TODO implement here
    	database.InsertSuggestedProduct(new Product( productName, Category, Brand));
    }

    /**
     * @return
     */
    public List<Product> GetSystemProducts() {
        // TODO implement here
        return database.RetreiveSysProducts();
    }
   
    public void ChangeStore(String storeName) {
        // TODO implement here
    }
}