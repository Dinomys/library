package config;

import dao.IBookDao;
import dao.Impl.BookDao;
import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateJavaConfig.getSession();

        IBookDao bookDao = new BookDao();

        Book book = new Book();
        bookDao.insertBook(book);

        List<Book> books = bookDao.listBooks();
        System.out.println(books);

        bookDao.showBookById(1);

    }
}
