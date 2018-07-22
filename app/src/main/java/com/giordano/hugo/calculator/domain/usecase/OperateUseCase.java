package com.giordano.hugo.calculator.domain.usecase;

public interface OperateUseCase {
    Double plus(Double a, Double b);
    Double subtract(Double a, Double b);
    Double divide(Double a, Double b);
    Double multiply(Double a, Double b);
}
