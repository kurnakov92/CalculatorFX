package calculator.conrollers;

import javafx.scene.control.Alert;

public class AlertDialogController {

    public void alert(String title, String header,  String alertText){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(alertText);

        alert.showAndWait();

    }

}
