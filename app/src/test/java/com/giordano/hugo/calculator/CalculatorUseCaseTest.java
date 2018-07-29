package com.giordano.hugo.calculator;

import com.giordano.hugo.calculator.domain.usecase.CalculatorUseCase;
import com.giordano.hugo.calculator.domain.usecase.CalculatorUseCaseImpl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorUseCaseTest {
    private CalculatorUseCase calculatorUseCase;

    public CalculatorUseCaseTest() {
        this.calculatorUseCase = new CalculatorUseCaseImpl();
    }

    @Test
    public void operateTenNumbersAndResultIsTheExpected() {
        assertThat(calculatorUseCase.calculate("2+2+2+2+2+2+2+2+2+2"), is("20.0"));
        assertThat(calculatorUseCase.calculate("4+5"), is("9.0"));
    }

    @Test
    public void sumDecimalNumbersAndResultIsTheExpected() {
        assertThat(calculatorUseCase.calculate("15.5+7+2.5"), is("25.0"));
        assertThat(calculatorUseCase.calculate("15.5+7"), is("22.5"));
    }

    @Test
    public void subtractNumbersAndResultIsTheExpected() {
        assertThat(calculatorUseCase.calculate("2-1"), is("1.0"));
    }

    @Test
    public void multiplyNumbersAndResultIsTheExpected() {
        assertThat(calculatorUseCase.calculate("2x2"), is("4.0"));
        assertThat(calculatorUseCase.calculate("2.0x2.0"), is("4.0"));
    }

    @Test
    public void divideNumbersAndResultIsTheExpected() {
        assertThat(calculatorUseCase.calculate("4÷2"), is("2.0"));
    }
}
