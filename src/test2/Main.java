package test2;

public class Main {
    public static void main(String args[]) {

        ExchangeRate exchangeRate1 = new ExchangeRate("tugrug", 1);
        ExchangeRate exchangeRate2 = new ExchangeRate("dollar", 2848.49);
        ExchangeRate exchangeRate3 = new ExchangeRate("euro", 3311.08);

        RateCalculator rateCalculator = new RateCalculator(exchangeRate3, exchangeRate2, 3);
        rateCalculator.printResult();

        rateCalculator.setAmount(2);

    }
}
