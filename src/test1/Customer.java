package test1;

public class Customer {
    private static int id = 0;
    private final int CustomerID;
    private final String CName;
    private String CAddress;
    private String CPhoneNumber;

    public String getCAddress() {
        return CAddress;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public String getCName() {
        return CName;
    }

    public String getCPhoneNumber() {
        return CPhoneNumber;
    }

    public void setCAddress(String CAddress) {
        this.CAddress = CAddress;
    }

    public Customer() {
        this.CName = "Default test1.Customer";
        this.CAddress = "Default address";
        this.CPhoneNumber = "000";
        this.CustomerID = id;
        id++;
    }

    public Customer(String CName, String CAddress, String CPhoneNumber) {
        this.CName = CName;
        this.CAddress = CAddress;
        this.CPhoneNumber = CPhoneNumber;
        this.CustomerID = id;
        id++;
    }

    public boolean pay(Payment payment){
        System.out.println(payment.getCart().getTotal());
        System.out.println("paying...");
        payment.setStatus("paid");
        System.out.println(payment.getStatus());
        return (true);
    }

    public void contact(){
        System.out.println("please wait for a moment...");
    }

}
