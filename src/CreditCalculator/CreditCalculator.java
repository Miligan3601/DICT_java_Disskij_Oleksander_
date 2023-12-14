import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        
        double principal = -1;
        int months = -1;
        double interest = -1;
        
        if(args.length < 4) {
            System.out.println("Incorrect parameters");
            return;
        }
        
        for(String arg : args) {
            String[] parts = arg.split("=");
            if (parts.length != 2) {
                System.out.println("Incorrect parameters");
                return; 
            }
            
            String param = parts[0];
            String value = parts[1];
            
            if (param.equals("--type")) {
                if (!value.equals("annuity") && !value.equals("diff")) {
                    System.out.println("Incorrect parameters");
                    return;
                }
            }
            else if (param.equals("--payment")) {
                if (value.equals("diff")) {
                    System.out.println("Incorrect parameters");
                    return;
                } 
            }
            else if (param.equals("--principal")) {
                principal = Double.parseDouble(value);
                if(principal < 0) {
                    System.out.println("Incorrect parameters");
                    return;
                }
            }
            else if (param.equals("--periods")) {
                months = Integer.parseInt(value);
                if(months < 0) {
                    System.out.println("Incorrect parameters"); 
                    return;
                }
            }
            else if (param.equals("--interest")) {
                interest = Double.parseDouble(value); 
            }
        }
        
        if(principal < 0 || months < 0 || interest < 0) {
            System.out.println("Incorrect parameters");
            return;
        }
        
        if(args[0].split("=")[1].equals("annuity")) {
            calculateAnnuity(principal, months, interest);
        }
        else { 
            calculateDifferentiated(principal, months, interest);
        }
    }
    
    public static void calculateAnnuity(double principal, int months, double interest) {
        
        double monthlyRate = interest / 1200; 
        double payment = principal * (monthlyRate + (monthlyRate / 
                ((Math.pow(1 + monthlyRate, months) - 1))));
                
        System.out.println("Your monthly payment = " + (int)payment + "!"); 
    }
    
    public static void calculateDifferentiated(double principal, int months, double interest) {
     
        double totalPaid = 0;
        for(int month = 1; month <= months; month++) {
            double monthlyRate = interest / 1200;
            double paid = (principal / months) + monthlyRate * (principal - 
                    (principal * (month - 1)) / months);
                     
            totalPaid += paid;           
            System.out.println("Month " + month + ": payment is " + (int)paid);    
        }
        
        double overpayment = totalPaid - principal;
        
        System.out.println("Overpayment = " + (int)overpayment);
    }
}

