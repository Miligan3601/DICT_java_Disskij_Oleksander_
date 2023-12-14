import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the loan principal:");
        double principal = Double.parseDouble(scanner.nextLine());

        System.out.println("What do you want to calculate?");
        System.out.println("type 'm' – for number of monthly payments,");
        System.out.println("type 'p' – for the monthly payment:");
        String calculationType = scanner.nextLine();

        double payment;
        double periods;

        if (calculationType.equals("m")) {
            System.out.println("Enter the monthly payment:");
            payment = Double.parseDouble(scanner.nextLine());
            periods = Math.ceil(principal / payment);
            System.out.println("It will take " + (int) periods + " months to repay the loan");
        } else if (calculationType.equals("p")) {
            System.out.println("Enter the number of months:");
            periods = Double.parseDouble(scanner.nextLine());
            payment = Math.ceil(principal / periods);
            double lastPayment = principal - (periods - 1) * payment;
            System.out.println("Your monthly payment = " + (int) payment +
                    " and the last payment = " + (int) lastPayment);
        }

        scanner.close();
    }
}

