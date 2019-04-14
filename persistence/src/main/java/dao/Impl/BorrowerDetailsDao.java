package dao.Impl;

import config.HibernateConfig;
import config.HibernateJavaConfig;
import dao.IBorrowerDetailsDao;
import model.BorrowerDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BorrowerDetailsDao implements IBorrowerDetailsDao {

    private final SessionFactory sessionFactory;

    public BorrowerDetailsDao() {
        HibernateConfig config = new HibernateJavaConfig();
        this.sessionFactory = config.getSessionFactory();
    }

    @Override
    public boolean insertBorrowerDetails(BorrowerDetails borrowerDetails) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.save(borrowerDetails);
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
    public List<BorrowerDetails> listBorrowerDetails() {
        List<BorrowerDetails> bookList = new ArrayList<BorrowerDetails>();
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(BorrowerDetails.class);
            Root<BorrowerDetails> root = criteriaQuery.from(BorrowerDetails.class);
            Query<BorrowerDetails> query = session.createQuery(criteriaQuery);
            bookList = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookList;
    }
}