package dao.Impl;

import config.HibernateConfig;
import config.HibernateJavaConfig;
import dao.IBorrowerDao;
import model.Borrower;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BorrowerDao implements IBorrowerDao {

    private Session session;

    public BorrowerDao() {
        this.session = HibernateJavaConfig.getSession();
    }

    @Override
    public boolean insertBorrower(Borrower borrower) {
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            session.save(borrower);
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
    public boolean removeBorrower(Borrower borrower) {
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            session.delete(borrower);
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
    public Borrower showBorrowerById(long id) {
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();
            Borrower borrower = session.load(Borrower.class, id);
            transaction.commit();
            return borrower;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Borrower> listBorrowers() {
        List<Borrower> borrowerList = new ArrayList<>();
        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Borrower.class);
            Root<Borrower> root = criteriaQuery.from(Borrower.class);
            Query<Borrower> query = session.createQuery(criteriaQuery);
            borrowerList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return borrowerList;
    }
}