package br.project.rest_spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.project.rest_spring_boot.service.MathService;

@RestController
public class MathController {

    private final MathService mathService;
    
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable final String numberOne, @PathVariable final String numberTwo) {
       return this.mathService.sum(numberOne, numberTwo);
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable final String numberOne, @PathVariable final String numberTwo) {
        return this.mathService.subtraction(numberOne, numberTwo);
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable final String numberOne, @PathVariable final String numberTwo) {
        return this.mathService.multiplication(numberOne, numberTwo);
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable final String numberOne, @PathVariable final String numberTwo) {
        return this.mathService.division(numberOne, numberTwo);
    }

    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable final String numberOne, @PathVariable final String numberTwo) {
        return this.mathService.mean(numberOne, numberTwo);
    }

    @GetMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable final String number) {
        return this.mathService.squareRoot(number);
    }

}
