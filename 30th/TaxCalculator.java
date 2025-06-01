import java.util.*;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Age: ");
        int age = sc.nextInt();

        System.out.println("Enter your Annual Salary: ");
        double salary = sc.nextDouble();

        System.out.println("Investments in Tax-Saving Instruments: ");
        double investments = Math.min(sc.nextDouble(), 150000);

        System.out.println("Health Insurance Premium Paid: ");
        double healthInsurance = sc.nextDouble();
        double maxHealthDeduction = (age >= 60) ? 50000 : 25000;
        healthInsurance = Math.min(healthInsurance, maxHealthDeduction);

        System.out.println("Home Loan Interest Paid: ");
        double homeLoanInterest = Math.min(sc.nextDouble(), 200000);

        double totalDeductions = investments + healthInsurance + homeLoanInterest;
        double taxableIncome = Math.max(salary - totalDeductions, 0);

        double tax = 0;

        if (age < 60) {
            if (taxableIncome <= 250000) tax = 0;
            else if (taxableIncome <= 500000) tax = (taxableIncome - 250000) * 0.05;
            else if (taxableIncome <= 1000000) tax = 12500 + (taxableIncome - 500000) * 0.20;
            else tax = 112500 + (taxableIncome - 1000000) * 0.30;
        } else if (age < 80) {
            if (taxableIncome <= 300000) tax = 0;
            else if (taxableIncome <= 500000) tax = (taxableIncome - 300000) * 0.05;
            else if (taxableIncome <= 1000000) tax = 10000 + (taxableIncome - 500000) * 0.20;
            else tax = 110000 + (taxableIncome - 1000000) * 0.30;
        } else {
            if (taxableIncome <= 500000) tax = 0;
            else if (taxableIncome <= 1000000) tax = (taxableIncome - 500000) * 0.20;
            else tax = 100000 + (taxableIncome - 1000000) * 0.30;
        }

        System.out.printf("Total Tax Payable: ₹%.2f\n", tax);

        sc.close();
    }
}
