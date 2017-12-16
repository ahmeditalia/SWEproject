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
    private StoreOwner CurrentUser= new StoreOwner();
    private Store CurrentStore= new Store();

    private IDataBase database= new DataBase();
 

    /**
     * @param storeName
     */
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addNewStore(String Sname) {
		// TODO Auto-generated method stub
    	CurrentUser.AddNewStore(Sname);

	}
    public List<String> getBrandsNames(){
    	return database.RetreiveBrandsNames();
    }
    public List<String> getCategoriesNames(){
    	return database.RetreiveCategoriesNames();
    }
    
    public Store searchForStore(String sName){
    	return  searchForStore(sName);
    }   
    
    
    public void setCurrentStore(String currS){
    	CurrentStore= searchForStore(currS);
    }
    public Store getCurrentStore() {
        // TODO implement here
        return CurrentStore;
    }
    public void AddProduct(String ID,String ProductName, float price, int quantity, String category, String brand) {
    	Product newP= new Product();
		newP.setID(ID);
		newP.setName(ProductName);
		newP.setPrice(price);
		newP.setQuantity(quantity);
		newP.setCategory(category);
		newP.setBrand(brand);
		CurrentUser.AddProductToStore(newP,CurrentStore.getStoreName());
    }

    /**
     * @return
     */
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
    

    

    /**
     * @param productName 
     * @param Category 
     * @param Brand
     */
    public void SuggestProduct(String productName, String Category, String Brand) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Product> GetSystemProducts() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
   
    public void ChangeStore(String storeName) {
        // TODO implement here
    }
}