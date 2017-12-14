package src;



import java.util.*;

/**
 * 
 */
public class DataBase implements IDataBase {

    /**
     * Default constructor
     */
    public DataBase() {
    }

    /**
     * @param ProductName 
     * @return
     */
    public List<Product> RetreiveProduct(String ProductName) {
        // TODO implement here
        return null;
    }

    /**
     * @param username 
     * @param password 
     * @return
     */
    public User RetreiveUser(String username, String password) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<String> RetreiveCategoriesNames() {
        // TODO implement here
        return null;
    }

    /**
     * @param categoryName 
     * @return
     */
    public List<Product> RetreiveCategoryProducts(String categoryName) {
        // TODO implement here
        return null;
    }

    /**
     * @param CartOwnerName 
     * @param product
     */
    public void InsertProductToCart(String CartOwnerName, Product product) {
        // TODO implement here
    }

    /**
     * @param NewUser
     */
    public void InsertUser(User NewUser) {
        // TODO implement here
    }

    /**
     * @param CartOwnerName
     */
    public void EmptyUserCart(String CartOwnerName) {
        // TODO implement here
    }

    /**
     * @param StoreOwnerName 
     * @param StoreName 
     * @param product
     */
    public void InsertProductToStore(String StoreOwnerName, String StoreName, Product product) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Product> RetreiveSysProducts() {
        // TODO implement here
        return null;
    }

    /**
     * @param product
     */
    public void InsertProductToSystem(Product product) {
        // TODO implement here
    }

    /**
     * @param product
     */
    public void InsertSuggestedProduct(Product product) {
        // TODO implement here
    }

    /**
     * @param store
     */
    public void InsertNewStore(Store store) {
        // TODO implement here
    }

}