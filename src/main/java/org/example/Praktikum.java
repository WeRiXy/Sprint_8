package org.example;

public class Praktikum {
    public static void main(String[] args) {
        String name = "Тимоти Шаламе";
        Account account = new Account(name);
        Boolean isValidName = account.checkNameToEmboss();

        System.out.println(name.length());
        System.out.println(isValidName);
    }
}