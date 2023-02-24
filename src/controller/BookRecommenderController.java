package controller;

import entities.Book;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Model;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
            columnYear,
            columnAuthor,
            columnNotes,
            columnPublisher,
            columnBookCategory;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnAddBook,
            btnEditBook,
            btnDeleteBook;
    private boolean listsUpdated = false;
    private  Parent root;
    private Model model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new Model();
        showBooksTable();

    }

    public void addNewBook(ActionEvent actionEvent) throws IOException {
        listsUpdated = true;
        try{
            displayAddNewBookPopup();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void editBook(ActionEvent actionEvent) throws IOException {
        displayEditBookPopup();
    }


    public void deleteBook(ActionEvent actionEvent) {
      Book selectedBook = (Book) tableViewBooks.getSelectionModel().getSelectedItem();
        try {
            model.deleteBook(selectedBook);
            showBooksTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void showBooksTable()  {
        columnTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        columnYear.setCellValueFactory(new PropertyValueFactory<Book, Integer>("year"));
        columnAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        columnNotes.setCellValueFactory(new PropertyValueFactory<Book,String>("notes"));
        columnPublisher.setCellValueFactory(new PropertyValueFactory<Book,String>("publisher"));
        columnBookCategory.setCellValueFactory(new PropertyValueFactory<Book,String>("category"));

        try{
            tableViewBooks.setItems(model.getAllBooks());
            tableViewBooks.getSelectionModel().select(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void displayAddNewBookPopup() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/AddNewBook.fxml"));

        root = loader.load();

        AddNewBookController addNewBookController = loader.getController();
        addNewBookController.setModel(model);

        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Add Book");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();

        showBooksTable();
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
    public void updateTables(MouseEvent mouseEvent) {
        if (listsUpdated) {
            listsUpdated = false;
        }
    }

}