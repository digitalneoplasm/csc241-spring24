package csc241.testers;

import csc241.exercises.Account;

public class AccountTester {
    public static void main(String[] args) {
        System.out.println("How many accounts? " + Account.getCount());

        Account checkingAccount = new Account();
        System.out.println("How many accounts? " + Account.getCount());
        Account savingsAccount = new Account();
        System.out.println("How many accounts? " + Account.getCount());

        System.out.println("Checking Acct # " + checkingAccount.getAccountNumber());
    }
}
