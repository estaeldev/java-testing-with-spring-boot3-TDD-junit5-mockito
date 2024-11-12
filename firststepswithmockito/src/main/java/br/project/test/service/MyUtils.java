package br.project.test.service;

public class MyUtils {

    private MyUtils() {}

    public static String getWelcome(String username, boolean isCustomer) {
        return isCustomer ? ("Dear " + username) : ("Hello " + username);
    }

}
