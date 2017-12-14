package src;

import java.util.*;
public class Cart {
    private NormalUser CartOwner;
    private ArrayList<Product> CartProducts;
    public Cart() {
        CartOwner=new NormalUser();
        CartProducts=new ArrayList<>();
    }
    public Cart(NormalUser user1) {
        CartOwner=user1;
        CartProducts=new ArrayList<>();
    }
    public void AddToCart(Product product) {
        CartProducts.add(product);
    }
    public void RemoveFromCart(Product product) {
        CartProducts.remove(product);
    }
    public float EmptyCart() {
        float balance=0;
        for(int i=0;i<CartProducts.size();i++){
            Product productTmp=CartProducts.get(i);
            balance+=productTmp.getPrice();
            Store storeTmp=productTmp.getStore();
            storeTmp.SellProduct(productTmp,CartOwner);
        }
        CartProducts.clear();
        CartOwner.setCart(this);
        return balance;
    }
    public NormalUser getCartOwner() {
        return CartOwner;
    }
    public void setCartOwner(NormalUser value) {
        CartOwner=value;
    }
    public List<Product> getCartProducts() {
        return CartProducts;
    }
    public void setCartProducts(ArrayList<Product> value) {
        CartProducts=value;
    }
}