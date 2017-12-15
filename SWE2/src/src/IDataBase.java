package src;



import java.util.*;

/**
 * 
 */
public interface IDataBase {

    /**
     * @param ProductName 
     * @return
     */
    public List<Product> RetreiveProduct(String ProductName);

    /**
     * @param username 
     * @param password 
     * @return
     */
    public User RetreiveUser(String username, String password);

    /**
     * @return
     */
    public List<String> RetreiveCategoriesNames();

    public List<String> RetreiveBrandsNames();

    /**
     * @param categoryName 
     * @return
     */
    public List<Product> RetreiveCategoryProducts(String categoryName);

    /**
     * @param CartOwnerName 
     * @param product
     */
    public void InsertProductToCart(String CartOwnerName, Product product);

    /**
     * @param NewUser
     */
    public void InsertUser(User NewUser);

    /**
     * @param CartOwnerName
     */
    public void EmptyUserCart(String CartOwnerName);

    /**
     * @param StoreOwnerName 
     * @param StoreName 
     * @param product
     */
    public void InsertProductToStore(String StoreOwnerName, String StoreName, Product product);

    /**
     * @return
     */
    public List<Product> RetreiveSysProducts();

    /**
     * @param product
     */
    public void InsertProductToSystem(Product product);

    /**
     * @param product
     */
    public void InsertSuggestedProduct(Product product);

    /**
     * @param store
     */
    public void InsertNewStore(Store store);

}