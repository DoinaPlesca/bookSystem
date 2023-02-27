package bll;

import dal.dao.BookDAO;
import entities.Book;

import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<Book> searchBooks(String query) throws SQLException {
        List<Book> books = bookDAO.getAllBooks();
        List<Book> filtered = new ArrayList<>();

        for(Book b : books) {
            if((""+b.getAuthor()).toLowerCase().contains(query) || b.getTitle().toLowerCase().contains(query.toLowerCase())){
                filtered.add(b);
            }
        }
        return filtered;
    }

}






