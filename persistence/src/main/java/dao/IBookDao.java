package dao;

import model.Book;

import java.util.List;

public interface IBookDao<T> {

    boolean insertBook(Book book);

    void editBook(Book book);

    boolean removeBook(Book book);

    Book showBookById(long id);

    List<Book> listBooks();
}
