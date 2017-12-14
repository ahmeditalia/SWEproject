package src;



public class CartController {
	private Cart UserCart;

	public CartController(NormalUser user) {
		UserCart = new Cart(user);
	}

	public float EmptyCart() {
		return (UserCart.EmptyCart());
	}

	public Cart getUserCart() {
		return UserCart;
	}

	public void setUserCart(Cart value) {
		UserCart = value;
	}
}