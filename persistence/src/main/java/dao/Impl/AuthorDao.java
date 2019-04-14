package dao.Impl;

import config.HibernateConfig;
import config.HibernateJavaConfig;
import dao.IAuthorDao;
import model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao<T> implements IAuthorDao {

    private final SessionFactory sessionFactory;

    public AuthorDao() {
        HibernateConfig config = new HibernateJavaConfig();
        this.sessionFactory = config.getSessionFactory();
    }

    @Override
    public boolean insertAuthor(Author author) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.save(author);
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
    public Author showAuthorById(long id) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            Author author = session.load(Author.class, id);
            transaction.commit();
            return author;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Author> listAuthors() {
        List<Author> authorList = new ArrayList<Author>();
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Author.class);
            Root<Author> root = criteriaQuery.from(Author.class);
            Query<Author> query = session.createQuery(criteriaQuery);
            authorList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorList;
    }
}
