package controller;

import entities.Book;
import entities.Category;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import java.util.List;
import java.util.ResourceBundle;

import model.ModelCategory;
import util.Search;

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
    private ModelCategory modelCategory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new Model();
        modelCategory = new ModelCategory();
        showBooksTable();
        try {
            modelCategory.getAllCategories();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getAllCategoriesTable();

        txtSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    model.search(newValue);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

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

    public void onCreateCat(ActionEvent actionEvent) throws IOException {
        displayCreateCat();
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

    public void onDeleteCat(ActionEvent actionEvent) {
        Category selectedCat = (Category) tableViewCategory.getSelectionModel().getSelectedItem();
        try {
            modelCategory.deleteCategory(selectedCat);
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

    public void getAllCategoriesTable(){
        columnCategory.setCellValueFactory(new PropertyValueFactory<Category, String>("categoryName"));
        try{
            tableViewCategory.setItems(modelCategory.getAllCategories());
            tableViewCategory.getSelectionModel().select(0);
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
    public void displayCreateCat() throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/CreateCat.fxml"));

        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Create cat");
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
