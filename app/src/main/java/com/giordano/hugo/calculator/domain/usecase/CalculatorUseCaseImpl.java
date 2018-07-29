package com.giordano.hugo.calculator.domain.usecase;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CalculatorUseCaseImpl implements CalculatorUseCase {
    private final String operationPattern = "\\d+\\.?\\d*%s\\d+\\.?\\d*";
    private final List<String[]> operatorSymbolPrecedenceList =
            Arrays.asList(new String[]{"x", "÷"}, new String[]{"+", "-"});

    @Override
    public String calculate(String operationInput) {
        Objects.requireNonNull(operationInput);
        while(hasOperator(operationInput)) {
            for(String[] operatorSymbolPrecedence : operatorSymbolPrecedenceList) {
                Integer operatorIndex = getIndexOfOperatorOfFirstOperation(operationInput, operatorSymbolPrecedence);
                if(operatorIndex > operationInput.length()) continue;
                operationInput = replaceFirstOperationWithResult(operationInput, operatorIndex);
            }
        }
        return operationInput;
    }

    private String replaceFirstOperationWithResult(String operationInput, Integer operatorIndex) {
        String operator = String.valueOf(operationInput.charAt(operatorIndex));
        String operation = extractOperation(operationInput, operator);
        String operationResult = operate(operator, operation);
        return operationInput.replace(operation, operationResult);
    }

    private boolean hasOperator(String operationInput) {
        for(String[] operatorSymbolPrecedence : operatorSymbolPrecedenceList)
            for(String operatorSymbol : operatorSymbolPrecedence)
                if(operationInput.contains(operatorSymbol))
                    return true;
        return false;
    }

    private String operate(String operator, String operation) {
        Double result = 0.0;
        for(String number : getNumbersToOperate(operator, operation))
            switch (operator) {
                case "+":
                    result += Double.valueOf(number);
                    break;
                case "-":
                    result = Double.valueOf(number) - result;
                    break;
                case "x":
                    result *= Double.valueOf(number);
                    break;
                case "÷":
                    result /= Double.valueOf(number);
                    break;
            }
        return result.toString();
    }

    private String[] getNumbersToOperate(String operator, String operation) {
        switch (operator) {
            case "+":
                return operation.split("\\+");
            case "-":
            case "x":
            case "÷":
            default:
                return operation.split(operator);
        }
    }

    private Integer getIndexOfOperatorOfFirstOperation(String operationInput, String [] operatorPrecedence) {
        Integer min = 999999999;
        for(String symbol : operatorPrecedence) {
            Integer index = operationInput.indexOf(symbol);
            if(index != -1 && min > index)
                min = index;
        }
        return min;
    }

    private String extractOperation(String operationInput, String operator) {
        final Matcher matcher = createMatcher(operationInput, operator.equals("+") ? "\\+" : operator);
        if(matcher.find())
            return matcher.group(0);
        return "";
    }

    private Matcher createMatcher(String operationInput, String operator) {
        final Pattern pattern = Pattern.compile(String.format(operationPattern, operator), Pattern.MULTILINE);
        return pattern.matcher(operationInput);
    }
}
