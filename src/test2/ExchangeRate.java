package test2;

public class ExchangeRate {
    private String id;
    private String name;
    private double rate;

    public ExchangeRate(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
