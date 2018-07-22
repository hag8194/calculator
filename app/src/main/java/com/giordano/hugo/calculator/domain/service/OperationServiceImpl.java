package com.giordano.hugo.calculator.domain.service;

import com.giordano.hugo.calculator.domain.mapper.OperationMapper;
import com.giordano.hugo.calculator.domain.usecase.OperateUseCase;

public class OperationServiceImpl implements OperationService {

    private OperateUseCase operateUseCase;
    private OperationMapper operationMapper;

    public OperationServiceImpl(OperateUseCase operateUseCase, OperationMapper operationMapper) {
        this.operateUseCase = operateUseCase;
        this.operationMapper = operationMapper;
    }

    @Override
    public StringBuilder operate(StringBuilder operationInput) {
        return null;
    }
}
