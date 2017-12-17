package src;



import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class StoreOwner extends User implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public StoreOwner() {
    }
    
    StoreOwner(String Username,String Password,String E_mail,String PhoneNumber,String Gender,String Address,int Type){
    	this.Username=Username;
        this.Password=Password;
        this.E_mail=E_mail;
        this.PhoneNumber=PhoneNumber;
        this.Gender=Gender;
        this.Address=Address;
        this.Type=Type;
    }

    
    private List<Store> OwnedStores= new ArrayList<>();
    
   
    public Store searchForStore(String sName){
    	for (int i=0;i<OwnedStores.size();i++){
    		if (OwnedStores.get(i).getStoreName()== sName)
    			return OwnedStores.get(i);
    	}
    	return null;
    }
    public void AddProductToStore(Product product, String storeName) {
    	Store s= new Store();
    	s= searchForStore(storeName);
    	if (s!=null){
    		s.AddProduct(product);
    	}
    }
    public List<Store> getOwnedStores() {
        // TODO implement here
        return OwnedStores;
    }
    public void AddNewStore(String StoreName) {
    	OwnedStores.add(new Store(StoreName,this));
    }

}