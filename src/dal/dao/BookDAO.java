package dal.dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.database.DatabaseConnector;
import entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private PreparedStatement preparedStatement;
    private DatabaseConnector databaseConnector;

    public BookDAO(){databaseConnector = new DatabaseConnector();

    }

    public List <Book> getAllBooks() throws SQLException {
        List<Book> books;

        String sql = "SELECT * FROM BooksT";
        preparedStatement = databaseConnector.getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        books = fillBooks(resultSet);

        return books;
    }

    private List<Book> fillBooks(ResultSet resultSet) throws SQLException {
        List<Book> books = new ArrayList<>();

        while (resultSet.next()) {
            books.add(new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getInt("year"),
                    resultSet.getString("author"),
                    resultSet.getString("notes"),
                    resultSet.getString("publisher"),
                    resultSet.getString("category")
            ));
        }
        return books;
    }

    public void createNewBook(Book book) throws SQLException {
        String sql = "INSERT INTO BooksT ( title, year, author, notes, publisher,category) VALUES (?,?,?,?,?,?)";

        preparedStatement = databaseConnector.getConnection().prepareStatement(sql);


        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setInt(2, book.getYear());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setString(4, book.getNotes());
        preparedStatement.setString(5, book.getPublisher());
        preparedStatement.setString(6, book.getCategory());

        preparedStatement.execute();
 }


    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM BooksT WHERE id= ?";

        Connection conn = databaseConnector.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();
    }
}



