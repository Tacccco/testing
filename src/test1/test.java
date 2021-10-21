package test1;

public class test {
    public static void main(String args[]){
        Payment payment = new Payment();
        payment.getCustomer().pay(payment);
        Printer printer = new Printer();
        printer.PrintCustomerData(payment.getCustomer());
    }
}