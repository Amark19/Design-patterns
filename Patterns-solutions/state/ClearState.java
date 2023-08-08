package net.media.training.designpattern.state;


public class ClearState implements CalculatorState{
    private Calculator calculator;

    public ClearState(Calculator calculator) {
        this.calculator = calculator;
    }

    public void input(Character c){
        if(calculator.isClear()){
            calculator.setLastChar(null);
            calculator.clearState();
        }
    }
}
