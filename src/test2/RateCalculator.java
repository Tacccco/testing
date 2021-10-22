package test2;

public class RateCalculator {
    private ExchangeRate from;
    private ExchangeRate to;
    private double Amount;

    public double getResult() {
        return Result;
    }

    private double Result;

    public RateCalculator(ExchangeRate from, ExchangeRate to, double amount) {
        this.from = from;
        this.to = to;
        Amount = amount;
        Result = calculate();
    }

    public void setFrom(ExchangeRate from) {
        this.from = from;
    }

    public void setTo(ExchangeRate to) {
        this.to = to;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public void printResult(){
        System.out.println("------Result-----");
        System.out.println(from.getName() + ": " + Amount );
        System.out.println(to.getName() + ": " + Math.round(Result*100.0)/100.0 );
    }

    public double calculate() {
        Result = from.getRate()*Amount/to.getRate();
        return Result;
    }
}
