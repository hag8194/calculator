package com.giordano.hugo.calculator.domain.usecase;

import java.util.Objects;

public class OperateUseCaseImpl implements OperateUseCase {
    @Override
    public Double plus(Double a, Double b) {
        checkParameters(a, b);
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        checkParameters(a, b);
        return a - b;
    }

    @Override
    public Double divide(Double a, Double b) {
        checkParameters(a, b);
        return a / b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        checkParameters(a, b);
        return a * b;
    }

    private void checkParameters(Double a, Double b){
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);
    }
}
