package model;

import bll.LogicManager;
import entities.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class Model {

    private LogicManager logicManager;
    private ObservableList<Book> books = FXCollections.observableArrayList();

    public  Model(){ logicManager = new LogicManager();}

    public ObservableList<Book> getAllBooks() throws SQLException {
        List<Book> b = logicManager.getAllBooks();
        return books = FXCollections.observableArrayList(b);
    }
    public void createNewBook(Book book) throws SQLException {
        logicManager.createNewBook(book);
        books.add(book);
    }


    public void deleteBook(Book book) throws SQLException {
        logicManager.deleteBook(book.getId());
        books.remove(book);
    }

    public void search(String query) throws SQLException {
        books.clear();
        books.addAll(logicManager.searchBooks(query));
    }

}
