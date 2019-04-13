package dao;

import model.Author;
import model.Book;

import java.util.List;

public interface IAuthorDao {

    boolean insertAuthor(Author author);

    Author showBookById(long id);

    List<Author> listAuthors();
}
