package br.project.rest_spring_boot.service;

public interface MathService {
    Double sum(String numberOne,  String numberTwo);
    Double subtraction(String numberOne, String numberTwo);
    Double multiplication(String numberOne, String numberTwo);
    Double division(String numberOne, String numberTwo);
    Double mean(String numberOne, String numberTwo);
    Double squareRoot(String number);
}
