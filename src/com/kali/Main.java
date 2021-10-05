package com.kali;

public class Main {
    public static void main(String[] args) {
        AppWindow app = new AppWindow();
        Customer customer1 = new Customer(3,3);
//        Customer customer2 = new Customer(1,3);
        app.process(app,customer1);
//        app.process(app,customer2);
    }
}
