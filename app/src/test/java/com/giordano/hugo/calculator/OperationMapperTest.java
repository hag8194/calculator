package com.giordano.hugo.calculator;

import com.giordano.hugo.calculator.domain.mapper.OperationMapper;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OperationMapperTest {
    private OperationMapper operationMapper;

    public OperationMapperTest() {
        this.operationMapper = new OperationMapper();
    }

    @Test
    public void getOperationsTest() {
        String mockOperationInput = "2+2+2+5";
        Map<OperationMapper.Operators, List<Double>> expectedMap = new EnumMap<>(OperationMapper.Operators.class);
        expectedMap.put(OperationMapper.Operators.ADDITION, Arrays.asList(2.0, 2.0, 2.0, 5.0));

        assertThat(operationMapper.getOperations(mockOperationInput), is(expectedMap));
        assertThat(operationMapper.getOperations(mockOperationInput).size(), is(1));
    }
}
