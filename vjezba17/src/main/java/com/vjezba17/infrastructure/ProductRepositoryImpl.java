package com.vjezba17.infrastructure;

import com.vjezba17.domain.entity.Product;
import com.vjezba17.domain.entity.TransactionIsolationLevel;
import com.vjezba17.domain.repository.ProductRepository;
import com.vjezba17.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ProductRepositoryImpl implements ProductRepository {
    SessionFactory sf;

    public ProductRepositoryImpl() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public Product addOrUpdate(Product product, TransactionIsolationLevel til) {
        Product rv = null;
        Transaction tx = null;
        try (Session session = sf.openSession()) {
            session.doWork(connection -> {
                connection.setTransactionIsolation(til.getLevel());
            });
            tx = session.beginTransaction();
            rv = session.merge(product);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return rv;
    }

    @Override
    public Product findById(long id) {
        Product rv = null;
        Transaction tx = null;
        try(Session session = this.sf.openSession()){
            tx= session.beginTransaction();
            rv = session.find(Product.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
        return rv;
    }
}
