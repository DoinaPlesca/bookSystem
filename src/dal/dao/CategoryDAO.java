package dal.dao;

import dal.database.DatabaseConnector;
import entities.Category;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private PreparedStatement preparedStatement;
    private DatabaseConnector databaseConnector;

    public CategoryDAO(){databaseConnector = new DatabaseConnector();}

    public List <Category> getAllCategories() throws SQLException {
        List<Category> Category;

        String sql = "SELECT * FROM BooksT";
        preparedStatement = databaseConnector.getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Category = fillCategory(resultSet);

        return Category;
    }

    private List<Category> fillCategory(ResultSet resultSet) throws SQLException {
        List<Category> categories = new ArrayList<>();

        while (resultSet.next()) {
            categories.add(new Category(
                    resultSet.getInt("id"),
                    resultSet.getString("Category")
            ));
        }
        return categories;
    }
    public void createNewCategory(Category category) throws SQLException {
        String sql = "INSERT INTO Categories ( Category) VALUES (?)";

        preparedStatement = databaseConnector.getConnection().prepareStatement(sql);


        preparedStatement.setString(1, category.getCategoryName());

        preparedStatement.execute();
    }

    public void deleteCategory(int id) throws SQLException {
        String sql = "DELETE FROM Categories WHERE id= ?";

        Connection conn = databaseConnector.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();
    }
}
