package bll;

import dal.dao.BookDAO;
import dal.dao.CategoryDAO;
import entities.Book;

import java.sql.SQLException;
import java.util.List;

public class LogicManager {

    BookDAO bookDAO;

    public LogicManager() {
        bookDAO = new BookDAO();
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookDAO.getAllBooks();
    }


    public void createNewBook(Book book) throws SQLException {
         bookDAO.createNewBook(book);
    }

    public void deleteBook(int id) throws SQLException {
        bookDAO.deleteBook(id);
    }

}






