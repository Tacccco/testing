package test1;

public class Printer {
    public void PrintCustomerData(Customer customer){
        System.out.println("        test1.Customer         ");
        System.out.println("-------------------------");
        System.out.println("ID: " + customer.getCustomerID());
        System.out.println("Name: " + customer.getCName());
        System.out.println("Address: " + customer.getCAddress());
        System.out.println("Phone: " + customer.getCPhoneNumber());
        System.out.println("-------------------------");
    }
}
