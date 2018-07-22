package com.giordano.hugo.calculator.presentation.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.giordano.hugo.calculator.CalculatorApplication;
import com.giordano.hugo.calculator.R;
import com.giordano.hugo.calculator.common.BaseActivity;
import com.giordano.hugo.calculator.di.qualifier.NumbersQualifier;
import com.giordano.hugo.calculator.di.qualifier.OperatorsQualifier;

import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Inject
    String testo;

    @Inject
    MainViewModel mainViewModel;

    @Inject
    @NumbersQualifier
    Set<String> numSet;

    @Inject
    @OperatorsQualifier
    Set<String> opSet;

    @BindView(R.id.operation)
    TextView operationTextView;

    @BindView(R.id.operation_input)
    TextView operationInputTextView;

    @OnClick(R.id.cancel)
    public void onCancelButtonClick() {
        mainViewModel.deleteAllOperationItem();
    }

    @OnClick(R.id.backspace)
    public void onBackSpaceClick() {
        mainViewModel.deleteLastOperationItem();
    }

    @OnClick({R.id.divide,
              R.id.seven,  R.id.eight,   R.id.nine,    R.id.multiply,
              R.id.four,   R.id.five,    R.id.six,     R.id.subtract,
              R.id.one,    R.id.two,     R.id.three,   R.id.plus,
              R.id.zero,   R.id.decimal})
    public void onNumberAndOperatorButtonClick(Button button) {
        mainViewModel.addOperationItem(button.getText());
    }

    @OnClick(R.id.equal)
    public void onEqualButtonClick() {
        Toast.makeText(this,"Operating! " + testo, Toast.LENGTH_SHORT).show();
        mainViewModel.operate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CalculatorApplication)getApplication()).getAppComponent()
                .mainComponent().activity(this).build().inject(this);

        mainViewModel.getOperationInput().observe(this,
                operationInput -> operationInputTextView.setText(operationInput));

        mainViewModel.getOperationResult().observe(this,
                operationResult -> operationTextView.setText(operationResult));
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }
}
