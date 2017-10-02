package calculator.conrollers;

import calculator.model.Model;
import calculator.validators.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    private Model model = new Model();
    private AlertDialogController alertDialogController = new AlertDialogController();

    private Validator validator = new Validator();

    @FXML
    private Text outputResult;

    @FXML
    private TextField dividendTextField;

    @FXML
    private TextField dividerTextField;

    @FXML
    public void clearAll() {

        outputResult.setText("");
        dividendTextField.clear();
        dividerTextField.clear();
    }

    public void clearField(String field) {
        if ("dividend".equals(field)) {
            dividendTextField.clear();
            outputResult.setText("");
        } else if ("divider".equals(field)) {
            dividerTextField.clear();
            outputResult.setText("");
        }
    }

    /**
     * Метод, проверяющий есть ли пустые поля
     *
     * @return true(если есть хотя бы одно пустое поле) и  false( если пустых полей нет)
     */
    public boolean isFieldsClear() {
        boolean result = false;
        if ("".equals(dividendTextField.getText())) {
            result = true;
        } else if ("".equals(dividerTextField.getText())) {
            result = true;
        } else result = false;

        return result;
    }

    public boolean checkInputData(String value){
        boolean result = false;
        if (!validator.isAcceptableLength(value)) {
            alertDialogController.alert("Ошибка!", "Ошибка длины вводимого значения!",
                    "Введите число не длинее 10 символов!");
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    @FXML
    public void calculate() {
        if (!isFieldsClear()) {

            //Считываем в строковые переменные значения из TextField-ов
            String strDividend = (String) dividendTextField.getText();
            if (!checkInputData(strDividend)){
                clearField("dividend");
                outputResult.setText("");
                return;
            }

            String strDivider = (String) dividerTextField.getText();
            if (!checkInputData(strDivider)){
                clearField("divider");
                outputResult.setText("");
                return;
            }

            /**
             * если значение числовое - сетим значение в делимое в класс Модель
             * иначе выводим сообщение что значение не является числом и очищаем поле ввода
             */
            if (validator.isNumeric(strDividend)) {
                model.setDividend(Double.parseDouble(strDividend));
            } else {
                alertDialogController.alert("Ошибка!", "Ошибка делимого.",
                                            "Делимое не является числом!");
                clearField("dividend");
            }

            if (validator.isNumeric(strDivider)) {
                model.setDivider(Double.parseDouble(strDivider));
            } else {
                alertDialogController.alert("Ошибка!", "Ошибка делителя.",
                                            "Делитель не является числом!");
                clearField("divider");
                outputResult.setText("");
            }


            double result = model.division();
            if (result != -1) {
                outputResult.setText(String.valueOf(result));
                System.out.println(result);
            }

            /**
             * Этот костыль служит для того, чтобы при вводе в поле делителя строкового значения,
             * после которого выводится сообщение об ошибке, не выводилось еще одно сообщение об ошибке
             * деления на ноль.
             */
            model.setDivider(1);


        }


    }


}
