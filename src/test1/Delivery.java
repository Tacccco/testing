package test1;

public class Delivery {
    private static int deliveryCount = 0;
    private int DeliveryID;
    private Employee employee;
    private Customer customer;
    private Cart cart;
    public String state;

    public Delivery() {
        deliveryCount ++;
        DeliveryID = deliveryCount;
        employee = new Employee();
        customer = new Customer();
        cart = new Cart();
        setState("not delivered");
    }

    public Delivery(Employee employee, Customer customer, Cart cart) {
        deliveryCount ++;
        DeliveryID = deliveryCount;
        this.employee = employee;
        this.customer = customer;
        this.cart = cart;
        setState("not delivered");
    }

    public int getDeliveryID() {
        return DeliveryID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart getCart() {
        return cart;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
