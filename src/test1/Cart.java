package test1;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static int CartCount = 0;
    private final int CartID;
    private double Total = 0;
    private List <Product> products = new ArrayList<Product>();

    public Cart() {
        CartCount ++;
        CartID = CartCount;
        Product product = new Product();
        addProduct(product);
        Total = CalculateTotal();
    }

    public Cart(List<Product> products) {
        CartCount ++;
        CartID = CartCount;
        this.products = products;
        Total = CalculateTotal();
    }

    public int getCartID() {
        return CartID;
    }

    public double getTotal() {
        return Total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
        System.out.println("Successfully added to your cart");
    }

    public void removeProduct(Product product){
        products.remove(product.getProductID());
        System.out.println("Successfully removed from your cart");
    }

    public double CalculateTotal(){
        System.out.println("calculating total price...");
        for (Product p : products)
            Total += p.getPrice();
        return Total;
    }
}
