package com.example;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello from Java Microservice!");
        while (true) {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
