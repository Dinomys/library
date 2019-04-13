package config;

import dao.IBookDao;
import dao.Impl.BookDao;
import model.Book;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        HibernateConfig config = new HibernateJavaConfig();
        SessionFactory sessionFactory = config.getSessionFactory();

        IBookDao bookDao = new BookDao();

        Book book = new Book();
        bookDao.insertBook(book);

        List<Book> books = bookDao.listBooks();
        System.out.println(books);

        bookDao.showBookById(1);

        config.shutdown();
    }
}
