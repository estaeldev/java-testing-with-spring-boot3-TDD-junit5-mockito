package br.project.rest_spring_boot.service.impl;

import org.springframework.stereotype.Service;

import br.project.rest_spring_boot.service.MathService;
import br.project.rest_spring_boot.util.MathOperations;

@Service
public class MathServiceImpl implements MathService {

    private final MathOperations mathOperations;

    public MathServiceImpl(MathOperations mathOperations) {
        this.mathOperations = mathOperations;
    }

    @Override
    public Double sum(String numberOne, String numberTwo) {
        return this.mathOperations.sum(numberOne, numberTwo);
    }

    @Override
    public Double subtraction(String numberOne, String numberTwo) {
        return this.mathOperations.subtraction(numberOne, numberTwo);
    }

    @Override
    public Double multiplication(String numberOne, String numberTwo) {
        return this.mathOperations.multiplication(numberOne, numberTwo);
    }

    @Override
    public Double division(String numberOne, String numberTwo) {
        return this.mathOperations.division(numberOne, numberTwo);
    }

    @Override
    public Double mean(String numberOne, String numberTwo) {
        return this.mathOperations.mean(numberOne, numberTwo);
    }

    @Override
    public Double squareRoot(String number) {
        return this.mathOperations.squareRoot(number);
    }
   
}
