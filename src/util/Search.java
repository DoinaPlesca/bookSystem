package util;

import entities.Book;

import java.util.ArrayList;
import java.util.List;

public class Search {


    public static List<Book> filteringBooks(List<Book> listToSearch, String query) {
        List<Book> filtered = new ArrayList<>();
        for (Book book : listToSearch) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()))
            {
                filtered.add(book);
            }
        }
        return filtered;
    }
}
