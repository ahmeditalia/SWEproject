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

    
    

    public List<Store> getOwnedStores() {
        return OwnedStores;
    }
    public void AddNewStore(String storeName,IDataBase dataBase) {
    	Store store=new Store(storeName, this);
    	OwnedStores.add(store);
    	dataBase.InsertNewStore(store);
    }

}