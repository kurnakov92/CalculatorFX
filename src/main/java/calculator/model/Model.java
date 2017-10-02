package calculator.model;

import calculator.conrollers.AlertDialogController;

public class Model implements MathOperations{

    AlertDialogController alertDialogController = new AlertDialogController();

    private double dividend; //Делимое
    private double divider; //Делитель

    public void setDividend(double dividend) {
        this.dividend = dividend;
    }

    public void setDivider(double divider) {
        this.divider = divider;
    }


    @Override
    public double division() {

        double result = -2;
        if (divider == 0){
            alertDialogController.alert("Ошибка!", "Ошибка деления", "Делить на 0 нельзя!");
            result = -1;
        } else {
            result = dividend/divider;
        }
        return result;
    }
}
