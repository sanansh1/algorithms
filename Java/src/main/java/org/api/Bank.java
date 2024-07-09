package org.api;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Bank {
    private final HashMap<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public boolean createAccount(String accountNumber, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            return false;
        }
        Account newAccount = new Account(accountNumber, initialBalance);
        accounts.put(accountNumber, newAccount);
        return true;
    }

    public Double checkBalance(String accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return null;
    }

    public boolean transfer(String fromAccount, String toAccount, double amount) {
        Account from = accounts.get(fromAccount);
        Account to = accounts.get(toAccount);
        if (from != null && to != null && from.withdraw(amount)) {
            to.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean payBill(String fromAccount, double amount) {
        Account from = accounts.get(fromAccount);
        if (from != null) {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    from.withdraw(amount);
                    System.out.println("Bill of " + amount + " paid from account " + fromAccount);
                }
            };
            timer.schedule(task, 24 * 60 * 60 * 1000); // 24 hours in milliseconds
            return true;
        }
        return false;
    }
}
