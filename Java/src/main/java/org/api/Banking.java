package org.api;

public class Banking {


    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create accounts
        bank.createAccount("123", 500.0);
        bank.createAccount("456", 1000.0);

        // Check balances
        System.out.println("Balance of account 123: " + bank.checkBalance("123"));
        System.out.println("Balance of account 456: " + bank.checkBalance("456"));

        // Transfer amount
        bank.transfer("123", "456", 200.0);
        System.out.println("Balance of account 123 after transfer: " + bank.checkBalance("123"));
        System.out.println("Balance of account 456 after transfer: " + bank.checkBalance("456"));

        // Pay bill
        bank.payBill("456", 300.0);
        System.out.println("Scheduled bill payment from account 456.");

        // Wait for 24 hours to see the bill payment reflected (for demonstration purposes, this will not actually wait 24 hours in real-time)
    }
}
