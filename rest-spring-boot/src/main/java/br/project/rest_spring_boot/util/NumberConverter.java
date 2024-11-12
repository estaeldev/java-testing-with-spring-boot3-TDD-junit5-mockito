package br.project.rest_spring_boot.util;

import java.security.InvalidParameterException;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class NumberConverter {

    public Double fromStringToDouble(String number) {
        if(!isNumericValid(number)) {
            throw new InvalidParameterException("Parameter is not number valid");
        }
        return Double.valueOf(number.replace(",", "."));
    }

    private boolean isNumericValid(String strNumber) {
        if(Objects.isNull(strNumber)) {
            throw new IllegalArgumentException("Number is null");
        }
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?\\d*\\.?\\d+");
    }


}
