package calculator.conrollers;

import javafx.scene.control.Alert;

public class AlertDialogController {

    /**
     * Выбрасывает окно с сообщением об ошибке
     * @param title название
     * @param header заголовок (указывает тип ошибки)
     * @param alertText текст ошибки
     */
    public void alert(String title, String header,  String alertText){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(alertText);

        alert.showAndWait();

    }

}
