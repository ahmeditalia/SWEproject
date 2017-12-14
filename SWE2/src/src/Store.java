package src;



import java.util.*;

/**
 * 
 */
public class Store {

    /**
     * Default constructor
     */
    public Store() {
    }

    /**
     * 
     */
    private String StoreName;

    /**
     * 
     */
    private List<Product> StoreProducts;

    /**
     * 
     */
    private StoreOwner Owner;

    /**
     * 
     */
    private Map<Product,User> SoldProducts;




    /**
     * @param product
     */
    public void AddProduct(Product product) {
        // TODO implement here
    }

    /**
     * @param product 
     * @param Buyer
     */
    public void SellProduct(Product product, User Buyer) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getStoreName() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setStoreName(String value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Product> getStoreProducts() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setStoreProducts(List<Product> value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public StoreOwner getOwner() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setOwner(StoreOwner value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Map<Product,User> getSoldProducts() {
        // TODO implement here
        return null;
    }

    /**
     * @param value
     */
    public void setSoldProducts(Map<Product,User> value) {
        // TODO implement here
    }

}