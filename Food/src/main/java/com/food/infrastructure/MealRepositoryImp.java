package com.food.infrastructure;

import com.food.domain.entity.Meal;
import com.food.domain.repository.MealRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MealRepositoryImp implements MealRepository {
    private SessionFactory sf;

    public MealRepositoryImp(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public boolean saveMeal(Meal meal) {
        Transaction tx = null;
        try(Session session = sf.openSession()){
            tx = session.beginTransaction();
            session.persist(meal);
            tx.commit();
            return true;
        }catch (HibernateException e){
            e.printStackTrace();
            tx.rollback();
        }

        return false;
    }

    @Override
    public List<Meal> findAll() {
        try(Session session = sf.openSession()){
            return session.createQuery("FROM Meal", Meal.class).getResultList();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return null;
    }
}
