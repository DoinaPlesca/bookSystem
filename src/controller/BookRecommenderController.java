package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookRecommenderController implements Initializable {
    @FXML
    private TableView tableViewCategory;
    @FXML
    private TableColumn columnCategory;
    @FXML
    private TableView tableViewBooks;
    @FXML
    private TableColumn columnTitle,
            columnAuthor,
            columnYear,
            columnRating,
            columnNote;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnAddBook,
            btnEditBook,
            btnDeleteBook;
    @FXML
    private ImageView imageView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addNewBook(ActionEvent actionEvent) throws IOException {
        displayAddNewBookPopup();

    }

    public void editBook(ActionEvent actionEvent) throws IOException {
        displayEditBookPopup();
    }


    public void deleteBook(ActionEvent actionEvent) {
    }


    public void displayAddNewBookPopup() throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/AddNewBook.fxml"));

        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Add New Book");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }
    public void displayEditBookPopup() throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/EditBook.fxml"));

        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Edit Book");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }
}
