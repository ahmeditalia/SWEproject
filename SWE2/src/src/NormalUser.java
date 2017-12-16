package src;

import java.io.Serializable;

public class NormalUser extends User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cart cart;
    NormalUser(){
        cart=new Cart(this);
    }
    NormalUser(String Username,String Password,String E_mail,String PhoneNumber,String Gender,String Address,int Type){
    	this.Username=Username;
        this.Password=Password;
        this.E_mail=E_mail;
        this.PhoneNumber=PhoneNumber;
        this.Gender=Gender;
        this.Address=Address;
        this.Type=Type;
        cart=new Cart(this);
    }

    public void AddToCart(Product product) {
        cart.AddToCart(product);
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart value) {
        cart=value;
    }
}