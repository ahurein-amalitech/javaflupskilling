package solution;


import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Building A Mortgage Calculator
 * Requirement Specs:
 * 1. Principal:100000
 * 2.Annual Interest Rates:4.2
 * 3. Period(Years):30
 * 4. Mortgage:$?
 * 5.
 */

public class MortgageCalculator {
    public static void main(String...args){

        final byte MONTHS_IN_YEAR=12;
        final byte PERCENT=100;
        int principal = 0;

        principal = getPrincipalAmount();

        float annualInterestRate= getInterestRate();

        float monthlyInterest=annualInterestRate/PERCENT/MONTHS_IN_YEAR;

        int years = getPeriodInYears();
        int numberOfPayments = years*MONTHS_IN_YEAR;

        try {
            double mortgage=principal*(monthlyInterest*Math.pow(1+monthlyInterest,numberOfPayments))/(Math.pow(1+monthlyInterest,numberOfPayments)-1);
            String mortgageFormatted= NumberFormat.getCurrencyInstance().format(mortgage);
            System.out.println("Mortgage: " + mortgageFormatted);
        }catch(Exception ex){
            System.out.println("Encountered an error, try again!");
        }
    }

    public static int getPrincipalAmount(){
        int principal=0;
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("Principal: ");
            String tempPrincipal = scanner.nextLine();
            if(!isValidInteger(tempPrincipal)){
                System.out.println("Enter A Value Between 1000 and 1000000");
                continue;
            };
            principal = Integer.parseInt(tempPrincipal);
            if(!(principal>1000 && principal<=1_000_000)){
                System.out.println("Enter A Value Between 1000 and 1000000");
            }
        }while (!(principal>1000 && principal<=1_000_000));
        return principal;
    }

    public static float getInterestRate(){
        float rate = 0F;
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("Enter Annual Interest Rate: ");
            String tempRate = scanner.nextLine();
            if(!isValidFloat(tempRate)){
                System.out.println("Interest rate should be a positive integer or a float");
                continue;
            };
            rate = Float.parseFloat(tempRate);
            if(rate <= 0) System.out.println("Interest rate should be greater than 0");
        }while (rate <= 0);
        return rate;
    }

    public static int getPeriodInYears(){
        int years= -1;
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("Period(Years): ");
            String tempYears = scanner.nextLine();
            if(!isValidInteger(tempYears)){
                System.out.println("Enter a valid year");
                continue;
            };
            years = Integer.parseInt(tempYears);
            if(years <= 0)  System.out.println("Years should be greater than 0");
        }while (years <= 0);
        return years;
    }

    private static boolean isValidInteger(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }

    private static boolean isValidFloat(String value){
        try{
            var parsedValue = Float.parseFloat(value);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}
