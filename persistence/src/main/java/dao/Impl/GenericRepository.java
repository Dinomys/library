package dao.Impl;

import config.HibernateConfig;
import config.HibernateJavaConfig;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityTransaction;

public abstract class GenericRepository<T, K> {

   /* protected final SessionFactory sessionFactory;
    protected final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected GenericRepository() {
        HibernateConfig config = new HibernateJavaConfig();
        this.sessionFactory = config.getSessionFactory();
    }

    public void create(T entity) {
        Transaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public T read(K id) {
        return em.find(entityClass, id);
    }


    public void update(T entity) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void remove(T entity) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void removeById(K id) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            T entityToRemove = read(id);
            em.remove(entityToRemove);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }*/
}
