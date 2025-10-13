package com.TransactionIsolationTest;


import com.TransactionIsolationTest.application.TransactionIsolationService;

public class Main {
    public static void main(String[] args) {
        TransactionIsolationService runner = new TransactionIsolationService();
        runner.run();
    }
}
