package controller;


import entities.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Model;
import model.ModelCategory;

import javax.swing.*;
import java.sql.SQLException;


public class CreateCatController {
    @FXML
    private TextField txfCategory;
    @FXML
    private Button btnOk,
            btnClose;

    private ModelCategory modelCategory = new ModelCategory();

    public void setModel(ModelCategory modelCategory) {
        this.modelCategory = modelCategory;
    }

    public void okSelection(ActionEvent actionEvent) throws SQLException {

        modelCategory.createNewCategory(new Category(txfCategory.getText().toString()));
        Stage stage = (Stage) btnOk.getScene().getWindow();
        stage.close();

    }


    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
