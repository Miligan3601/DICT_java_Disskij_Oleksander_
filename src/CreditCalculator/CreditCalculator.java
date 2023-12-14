import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("type 'n' for number of monthly payments,");
        System.out.println("type 'a' for annuity monthly payment amount,");
        System.out.println("type 'p' for loan principal:");
        String calculationType = scanner.nextLine();

        double principal = 0;
        double payment = 0;
        double periods = 0;
        double interest = 0;

        switch (calculationType) {
            case "n":
                System.out.println("Enter the loan principal:");
                principal = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the monthly payment:");
                payment = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the loan interest:");
                interest = Double.parseDouble(scanner.nextLine());

                double i = interest / (12 * 100);
                periods = Math.log(payment / (payment - i * principal)) / Math.log(1 + i);
                int years = (int) periods / 12;
                int months = (int) periods % 12;
                System.out.println("It will take " + years + " years and " + months + " months to repay this loan!");
                break;
            case "a":
                System.out.println("Enter the loan principal:");
                principal = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the number of periods:");
                periods = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the loan interest:");
                interest = Double.parseDouble(scanner.nextLine());

                i = interest / (12 * 100);
                payment = principal * (i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1);
                System.out.println("Your monthly payment = " + (int) payment + "!");
                break;
            case "p":
                System.out.println("Enter the annuity payment:");
                payment = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the number of periods:");
                periods = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the loan interest:");
                interest = Double.parseDouble(scanner.nextLine());

                i = interest / (12 * 100);
                principal = payment * (Math.pow(1 + i, periods) - 1) / (i * Math.pow(1 + i, periods));
                System.out.println("Your loan principal = " + (int) principal + "!");
                break;
            default:
                System.out.println("Invalid calculation type!");
                break;
        }

        scanner.close();
    }
}

