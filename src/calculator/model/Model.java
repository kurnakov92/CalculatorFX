package calculator.model;

import calculator.conrollers.AlertDialogController;

public class Model implements MathOperations{

    AlertDialogController alertDialogController = new AlertDialogController();

    private double dividend;
    private double divider;

    public void setDividend(double dividend) {
        this.dividend = dividend;
    }

    public void setDivider(double divider) {
        this.divider = divider;
    }

    @Override
    public double division() {

        if (divider == 0){
            alertDialogController.alert("Ошибка!", "Ошибка деления", "Делить на 0 нельзя!");
            return -1;
        } else {
            return dividend/divider;
        }

    }
}
