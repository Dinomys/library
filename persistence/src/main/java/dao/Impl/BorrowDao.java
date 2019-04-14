package dao.Impl;

import config.HibernateConfig;
import config.HibernateJavaConfig;
import dao.IBorrowDao;
import model.Book;
import model.Borrow;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BorrowDao implements IBorrowDao {

    private final SessionFactory sessionFactory;

    public BorrowDao() {
        HibernateConfig config = new HibernateJavaConfig();
        this.sessionFactory = config.getSessionFactory();
    }

    @Override
    public boolean addBorrow(Borrow borrow) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.save(borrow);
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
    public Borrow showBorrowById(long id) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            Borrow borrow = session.load(Borrow.class, id);
            transaction.commit();
            return borrow;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Borrow> listBorrows() {
        List<Borrow> borrowList = new ArrayList<Borrow>();
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Book.class);
            Root<Borrow> root = criteriaQuery.from(Borrow.class);
            Query<Borrow> query = session.createQuery(criteriaQuery);
            borrowList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return borrowList;
    }
}