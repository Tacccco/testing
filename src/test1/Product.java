package test1;

import java.util.Date;

public class Product {
    private static int productCount = 0;
    private final int ProductID;
    private String PName;
    private String PDescription;
    private double Price;
    private int PAmount;
    private final Date EXPDate;

    public Product() {
        productCount++;
        this.ProductID = productCount;
        this.PName = "Default test1.Product";
        this.PDescription = "Default product description";
        this.Price = 10.3;
        this.PAmount = 20;
        this.EXPDate = new Date();
    }

    public Product(String PName, String PDescription, double price, int PAmount, Date EXPDate) {
        productCount++;
        ProductID = productCount;
        this.PName = PName;
        this.PDescription = PDescription;
        Price = price;
        this.PAmount = PAmount;
        this.EXPDate = EXPDate;
    }

    public static int getProductCount() {
        return productCount;
    }

    public int getProductID() {
        return ProductID;
    }

    public String getPName() {
        return PName;
    }

    public String getPDescription() {
        return PDescription;
    }

    public double getPrice() {
        return Price;
    }

    public int getPAmount() {
        return PAmount;
    }

    public Date getEXPDate() {
        return EXPDate;
    }
}
