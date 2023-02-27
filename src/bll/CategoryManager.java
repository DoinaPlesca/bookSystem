package bll;

import dal.dao.BookDAO;
import dal.dao.CategoryDAO;
import entities.Book;
import entities.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryManager {

    CategoryDAO categoryDAO;

    public CategoryManager() {
        categoryDAO = new CategoryDAO();
    }

    public List<Category> getAllCategories() throws SQLException {
        return categoryDAO.getAllCategories();
    }


    public void createNewCategory(Category category) throws SQLException {
        categoryDAO.createNewCategory(category);
    }

    public void deleteCategory(int id) throws SQLException {
        categoryDAO.deleteCategory(id);
    }
}
