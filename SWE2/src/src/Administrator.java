package src;



import java.io.Serializable;

/**
 * 
 */
public class Administrator extends User implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor
     */
    public Administrator() {
    }
    
    Administrator(String Username,String Password,String E_mail,String PhoneNumber,String Gender,String Address,int Type){
    	this.Username=Username;
        this.Password=Password;
        this.E_mail=E_mail;
        this.PhoneNumber=PhoneNumber;
        this.Gender=Gender;
        this.Address=Address;
        this.Type=Type;
    }


}