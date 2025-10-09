package com.product.infrastructure;

import com.product.application.HibernateUtil;
import com.product.domain.entity.Product;
import com.product.domain.repository.ProductRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductRepositoryImpl implements ProductRepository {
    private SessionFactory sf;

    public ProductRepositoryImpl() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public Product addOrUpdateProduct(Product product) {
        Transaction tx = null;
        Product result = null;
        try(Session session = sf.openSession()){
            tx = session.beginTransaction();
            result = session.merge(product);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void deleteProduct(Product product) {

        Transaction tx = null;
        try(Session session = sf.openSession()){
            tx = session.beginTransaction();
            Product pm = session.find(Product.class, product.getId());
            if(pm != null) {
                session.remove(pm);
            }
            tx.commit();
        }catch (HibernateException e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
