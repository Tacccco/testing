package test2;

import java.util.Scanner;

public class test {

    ExchangeRate exchangeRate1;
    ExchangeRate exchangeRate2;

    private double a;

    Scanner sc= new Scanner(System.in);

    test() {
        exchangeRate1 = exchangaRateScannert();
        exchangeRate2 = exchangaRateScannert();
    }

    public void run(){
        enterAmount();
        if (a <= 0){
            System.out.println("invalid amount");
            run();
        } else {
            RateCalculator rateCalculator = new RateCalculator(exchangeRate1, exchangeRate2, a);
            rateCalculator.printResult();
        }
    }

    private ExchangeRate exchangaRateScannert(){
        String t = "";
        double v = 0.0;

        while (t == ""){
            System.out.println("enter name: ");
            t = sc.nextLine();
            if(t == ""){
                System.out.println("---invalid name---");
            }
        }

        System.out.println("value: ");
        while (v == 0){
            v = Double.parseDouble(sc.nextLine());
            if (v == 0){
                System.out.println("---invalid value---");
            }
        }

        return new ExchangeRate(t, v);
    }

    private void enterAmount(){
        System.out.println("Amount: ");
        a = Double.parseDouble(sc.nextLine());
    }
}
