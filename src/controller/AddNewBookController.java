package controller;

import entities.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Model;

import java.io.File;
import java.sql.SQLException;

public class AddNewBookController {
    @FXML
    private AnchorPane anchorAddBook;
    @FXML
    private TextField txfTitle,
                      txfFileLocation,
                      txfAuthor,
                      txfYear,
                      txfCategory;

    @FXML
    private Button btnChooseFile,
                   btnAddNewBook,
                   btnClose;
    private String notes;
    private String publisher;
    private File file;
    private String path;
    private int id;

    private Model model;


    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void addPressed(ActionEvent actionEvent) {
        try{
            model.createNewBook(new Book(
                    id,
                    txfTitle.getText(),
                    Integer.parseInt(txfYear.getText()),
                    txfAuthor.getText(),
                    notes,
                    publisher,
                    txfCategory.getText()
            ));
            closeWindow();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void chooseFilePressed(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("docx","*.docx"));
        file = fileChooser.showOpenDialog(null);
        path = file.toURI().toString();

        if (path != null) {
            txfFileLocation.setText(file.getPath());
            txfTitle.setText(file.getName());

        }
    }
    private void closeWindow() {
        Stage stage = (Stage) anchorAddBook.getScene().getWindow();
        stage.close();
    }
}

