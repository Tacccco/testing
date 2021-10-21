package test1;

public class Payment {
    private static int count = 0;
    private int PaymentID;
    private Cart cart;
    private Customer customer;
    private String status;

    public Payment() {
        count ++;
        PaymentID = count;
        cart = new Cart();
        customer = new Customer();
        status = "not paid";
    }

    public Payment(Cart cart, Customer customer) {
        count ++;
        PaymentID = count;
        this.cart = cart;
        this.customer = customer;
        status = "not paid";
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public Cart getCart() {
        return cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
