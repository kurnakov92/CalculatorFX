package calculator.validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для валидации вводимых в поля калькулятора данных.
 */
public class Validator {

    public boolean isNumeric(String value){

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();

    }

    public boolean isAcceptableLength(String value){
        boolean result = false;

        if (value.length()>10){
            result = false;
        } else {
            result = true;
        }
        return result;
    }

}
