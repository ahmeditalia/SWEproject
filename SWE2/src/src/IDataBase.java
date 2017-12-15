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

    /**
     * @param categoryName 
     * @return
     */
    public List<Product> RetreiveCategoryProducts(String categoryName);

    /**
     * @param CartOwnerName 
     * @param product
     */
    public void InsertProductToCart(Cart cart);

    /**
     * @param NewUser
     */
    public void InsertUser(User NewUser);

    /**
     * @param CartOwnerName
     */
    public void EmptyUserCart(NormalUser user);

    /**
     * @param StoreOwnerName 
     * @param StoreName 
     * @param product
     */
    public void InsertProductToStore(Store store, Product product);

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
    
    
    public void provideVoucherCard(String VoucherNo);
    
    public boolean CheckVoucherCard(String VoucherNo);

}