package dao;

import config.HibernateConfig;
import config.HibernateJavaConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityTransaction;
import java.lang.reflect.ParameterizedType;

public abstract class GenericRepository<T, K> {

    protected final SessionFactory sessionFactory;
    protected final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected GenericRepository() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        HibernateConfig config = new HibernateJavaConfig();
        this.sessionFactory = config.getSessionFactory();
    }

    public void create(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public T read(K id) {
        Session session = sessionFactory.openSession();
        return session.find(entityClass, id);
    }

    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void remove(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void removeById(K id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession() {
            transaction = session.getTransaction();
            transaction.begin();
            T entityToRemove = read(id);
            session.remove(entityToRemove);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
