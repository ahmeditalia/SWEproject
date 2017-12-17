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
	
	private List<Store> OwnedStores;
    public StoreOwner() {
        OwnedStores= new ArrayList<>();
    }
    
    StoreOwner(String Username,String Password,String E_mail,String PhoneNumber,String Gender,String Address,int Type){
    	this.Username=Username;
        this.Password=Password;
        this.E_mail=E_mail;
        this.PhoneNumber=PhoneNumber;
        this.Gender=Gender;
        this.Address=Address;
        this.Type=Type;
        OwnedStores= new ArrayList<>();
    }

    
    
    
   
    public Store searchForStore(String sName){
    	for (int i=0;i<OwnedStores.size();i++){
    		if (OwnedStores.get(i).getStoreName()== sName)
    			return OwnedStores.get(i);
    	}
    	return null;
    }

    public List<Store> getOwnedStores() {
        return OwnedStores;
    }
    public void AddNewStore(String storeName) {
    	Store store=new Store(storeName, this);
    	OwnedStores.add(store);
    	new DataBase().InsertNewStore(store);
    }

}