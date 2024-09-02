/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.miniproject;

/**
 *
 * @author Hafeez
 */

import java.util.ArrayList;
import java.util.List;

class Account {
    private static int nextId = 101;
    private static Account[] accounts;

    static {
        
        accounts = new Account[]{
            new Account("Chot", "password1", 1000),
            new Account("Apiz", "password2", 500),
            new Account("Adel", "password3", 2000),
        };
    }

    static Account login(String id, String password) {
        for (Account account : accounts) {
            if (String.valueOf(account.getId()).equals(id) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    private int id;
    private String name;
    private String password;
    private double balance;
    private double loan;
    private List<String> transactionHistory;

    
    public Account(String name, String password, double initialBalance) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.password = password;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }
    
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setUsername(String newUsername) {
        this.name = newUsername;
    }

    public void deposit(double amount) {
        balance += amount;
        String transaction = "      Deposit:                    +" + amount     + "                    RM " + balance;
        addTransactionToHistory(transaction);
    }

    public void withdraw(double amount) {
        balance -= amount;
        String transaction = " Withdrawal:                    -" + amount     + "                     RM " + balance;
        addTransactionToHistory(transaction);
    }

    public void getLoan(double loanAmount) {
        loan += loanAmount;
        String transaction = "          Loan:                    +" + loanAmount + "                    RM " + balance;
        addTransactionToHistory(transaction);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    private void addTransactionToHistory(String transaction) {
        transactionHistory.add(transaction);
    }
}
