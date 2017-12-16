package src;



import java.util.*;

/**
 * 
 */
public class StoreOwner extends User {

    /**
     * Default constructor
     */
    public StoreOwner() {
    }
    
    private List<Store> OwnedStores= new ArrayList<>();
    
    // Sa2aaaaaaaaaaaaaaa added functions 
    public List<String>getStoresName(){
    	List<String> names= new ArrayList<>();
    	for(int i=0;i<OwnedStores.size();i++){
    		names.add(OwnedStores.get(i).getStoreName());
    	}
    	return names;
    }
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

    /**
     * @return
     */
    
    public List<Store> getOwnedStores() {
        // TODO implement here
        return OwnedStores;
    }

    

    
    public void AddNewStore(String StoreName) {
    	OwnedStores.add(new Store(StoreName,this));
    }

}