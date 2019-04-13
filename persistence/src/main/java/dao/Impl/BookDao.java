package dao.Impl;

import config.HibernateConfig;
import config.HibernateJavaConfig;
import dao.IBookDao;
import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookDao<T> implements IBookDao {

    private final SessionFactory sessionFactory;

    public BookDao() {
        HibernateConfig config = new HibernateJavaConfig();
        this.sessionFactory = config.getSessionFactory();
    }

    @Override
    public boolean insertBook(Book book) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            return true;

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Book editBook(List objects) {
        return null;
    }

    @Override
    public boolean removeBook(Book book) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()){

            transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
            return true;

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public Book showBookById(long id) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            Book book = session.load(Book.class, id);
            transaction.commit();
            return book;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Book> listBooks() {
        List<Book> bookList = new ArrayList<Book>();
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Book.class);
            Root<Book> root = criteriaQuery.from(Book.class);
            Query<Book> query = session.createQuery(criteriaQuery);
            bookList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
    }
}
