package testowanko1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class CRUD {
    private SessionFactory sessionFactory;
    public CRUD(){
        try{
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Bike.class).buildSessionFactory();
        } catch (Throwable e){
            e.printStackTrace();
        }
    }

    // read do testowania połączenia Hibernate z bazą
    @SuppressWarnings("unchecked")
    public List<Bike> getAllBikes(){
        Session session = sessionFactory.openSession();
        Transaction transaction;
        List<Bike> bikes = null;
        try{
            transaction = session.beginTransaction();
            bikes = session.createQuery("FROM testowanko1.Bike").list();
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bikes;
    }

    public void updateBike(int bikeId, Bike newBike){
        Session session = sessionFactory.openSession();
        Transaction transaction;

        try{
            transaction = session.beginTransaction();
            Bike bikeToUpdate = session.get(Bike.class, bikeId);
            bikeToUpdate.update(newBike);
            session.update(bikeToUpdate);
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
