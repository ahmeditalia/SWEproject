package src;
public class CartController {
	private Cart UserCart;

	public CartController(Cart cart) {
		UserCart = cart;
	}

	public float EmptyCart(IDataBase dataBase) {
		return (UserCart.EmptyCart(dataBase));
	}

	public Cart getUserCart() {
		return UserCart;
	}

	public void setUserCart(Cart value) {
		UserCart = value;
	}
}