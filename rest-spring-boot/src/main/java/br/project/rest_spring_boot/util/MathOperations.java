package br.project.rest_spring_boot.util;

import org.springframework.stereotype.Component;

@Component
public class MathOperations  {

    private final NumberConverter numberConverter;
    
    public MathOperations(NumberConverter numberConverter) {
        this.numberConverter = numberConverter;
    }

    public Double sum(String numberOne, String numberTwo) {
        Double numberOneDouble = this.numberConverter.fromStringToDouble(numberOne);
        Double numberTwoDouble = this.numberConverter.fromStringToDouble(numberTwo);
        return numberOneDouble + numberTwoDouble;
    }
    
    public Double subtraction(String numberOne, String numberTwo) {
        Double numberOneDouble = this.numberConverter.fromStringToDouble(numberOne);
        Double numberTwoDouble = this.numberConverter.fromStringToDouble(numberTwo);
        return numberOneDouble - numberTwoDouble;
    }
    
    public Double multiplication(String numberOne, String numberTwo) {
        Double numberOneDouble = this.numberConverter.fromStringToDouble(numberOne);
        Double numberTwoDouble = this.numberConverter.fromStringToDouble(numberTwo);
        return numberOneDouble * numberTwoDouble;
    }
    
    public Double division(String numberOne, String numberTwo) {
        Double numberOneDouble = this.numberConverter.fromStringToDouble(numberOne);
        Double numberTwoDouble = this.numberConverter.fromStringToDouble(numberTwo);
        return numberOneDouble / numberTwoDouble;
    }

    public Double mean(String numberOne, String numberTwo) {
        Double numberOneDouble = this.numberConverter.fromStringToDouble(numberOne);
        Double numberTwoDouble = this.numberConverter.fromStringToDouble(numberTwo);
        return (numberOneDouble + numberTwoDouble) / 2;
    }
    
    public Double squareRoot(String number) {
        Double numberDouble = this.numberConverter.fromStringToDouble(number);
        return Math.sqrt(numberDouble);
    }

    
}
