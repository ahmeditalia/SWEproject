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

    /**
     * 
     */
    private StoreOwner CurrentUser;

    /**
     * 
     */
    private Store CurrentStore;



    /**
     * @param user
     */
    public void StoreUIController(StoreOwner user) {
        // TODO implement here
    }

    /**
     * @param storeName
     */
    public void ChangeStore(String storeName) {
        // TODO implement here
    }

    /**
     * @param ProductName 
     * @param price 
     * @param quantity 
     * @param category 
     * @param brand
     */
    public void AddProduct(String ProductName, float price, int quantity, String category, String brand) {
        // TODO implement here
    }

    /**
     * @return
     */
    public StoreOwner getCurrentUser() {
        // TODO implement here
        return null;
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
    public Store getCurrentStore() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setCurrentStore(Store value) {
        // TODO implement here
    }

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
    public List<String> GetCategoriesNames() {
        // TODO implement here
        return null;
    }

}