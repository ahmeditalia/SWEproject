package src;

import java.io.Serializable;

public class User implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {
    }
    
    public User(String Username,String Password,String E_mail,String PhoneNumber,String Gender,String Address,int Type){
    	this.Username=Username;
        this.Password=Password;
        this.E_mail=E_mail;
        this.PhoneNumber=PhoneNumber;
        this.Gender=Gender;
        this.Address=Address;
        this.Type=Type;
    }

    protected String Username;

    protected String Password;

    protected String E_mail;

    protected String PhoneNumber;

    protected String Gender;

    protected String Address;

    protected int Type;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String value) {
        Username=value;
    }
    public String getPassword() {
        return Password;
    }

    public void setPassword(String value) {
        Password=value;
    }
    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String value) {
        E_mail=value;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String value) {
        PhoneNumber=value;
    }
    public String getGender() {
        return Gender;
    }

    public void setGender(String value) {
        Gender=value;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String value) {
        Address=value;
    }

    public int getType() {
        return Type;
    }

    public void setType(int value) {
        Type=value;
    }


}