package com.giordano.hugo.calculator.domain.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class OperationMapper {

    private static final List<String> operatorSymbol = Arrays.asList("+", "-", "x", "÷");
    public enum Operators {
        ADDITION, SUBTRACTION, DIVISION, MULTIPLICATION
    }

    public Map<Operators, List<Double>> getOperations(String operationInput) {
        Map<Operators, List<Double>> operations = new EnumMap<>(Operators.class);

        if(operationInput.contains("+"))
            operations.put(Operators.ADDITION, stringNumbersToDouble(operationInput.split("\\+")));

        return operations;
    }

    private List<Double> stringNumbersToDouble(String[] numbersString) {
        List<Double> numbersList = new ArrayList<>();

        for(String number : numbersString)
            numbersList.add(Double.valueOf(number));

        return numbersList;
    }
}
