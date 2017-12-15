public class NormalUser extends User {
    private Cart cart;
    NormalUser(){
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