public class ErrorState implements CalculatorState {
    private Calculator calculator;

    public ClearState(Calculator calculator) {
        this.calculator = calculator;
    }

    public void input(Character c){
        if(calculator.isError()){
            return;
        }
    }
}
