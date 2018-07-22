package com.giordano.hugo.calculator.presentation.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.giordano.hugo.calculator.util.StringUtil;

import java.util.Objects;

public class MainViewModel extends ViewModel {

    private MutableLiveData<StringBuilder> operationInput;
    private MutableLiveData<StringBuilder> operationResult;

    public MainViewModel() {
        operationInput = new MutableLiveData<>();
        operationResult = new MutableLiveData<>();
        operationInput.setValue(new StringBuilder());
        operationResult.setValue(new StringBuilder());
    }

    public LiveData<StringBuilder> getOperationInput() {
        return operationInput;
    }

    public LiveData<StringBuilder> getOperationResult() {
        return operationResult;
    }

    public void addOperationItem(CharSequence operationItem) {
        if(StringUtil.isNotNullAndIsNotEmpty(operationItem)) {
            StringBuilder currentOperationInput = getCurrentOperationInput();
            currentOperationInput.append(operationItem);
            this.operationInput.setValue(currentOperationInput);
        }
    }

    public void deleteLastOperationItem() {
        StringBuilder currentOperationInput = getCurrentOperationInput();
        if(StringUtil.isNotEmpty(currentOperationInput)) {
            currentOperationInput.deleteCharAt(currentOperationInput.length() - 1);
        }
        operationInput.setValue(currentOperationInput);
    }

    public void deleteAllOperationItem() {
        StringBuilder currentOperationInput = getCurrentOperationInput();
        currentOperationInput.setLength(0);
        operationInput.setValue(currentOperationInput);
    }

    public void operate() {

    }

    private StringBuilder getCurrentOperationInput() {
        return Objects.requireNonNull(this.operationInput.getValue());
    }
}
