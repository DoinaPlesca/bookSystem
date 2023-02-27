package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditBookController {
    @FXML
    private TextField txfTitle,
                     txfAuthor,
                     txfYear;
    @FXML
    private ChoiceBox choiceBoxCategory;
    @FXML
    private Button btnEdit,
                   btnClose;


    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
