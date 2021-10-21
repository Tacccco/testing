package test1;

public class Employee {
    private static int EmpCount = 0;
    private int EmpID;
    private String EName;
    private String PhoneNumber;

    public Employee() {
        EmpCount ++;
        this.EmpID = EmpCount;
        this.EName = "Default test1.Employee name";
        this.PhoneNumber = "111";
    }

    public Employee(String EName, String phoneNumber) {
        EmpCount ++;
        this.EmpID = EmpCount;
        this.EName = EName;
        PhoneNumber = phoneNumber;
    }

    public int getEmpID() {
        return EmpID;
    }

    public String getEName() {
        return EName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void deliver(Delivery delivery){
        System.out.println("delivering...");

        delivery.setState("delivered");
        System.out.println("delivered");
    }
}
