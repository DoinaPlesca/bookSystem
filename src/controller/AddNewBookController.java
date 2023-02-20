package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewBookController {
    @FXML
    private TextField txfTitle,
                      txfAuthor,
                      txfYear;
    @FXML
    private Button btnChooseFile,
                   btnAddNewBook,
                   btnClose;

    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
