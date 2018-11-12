package crud;

import entity.Bike;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author User
 */
public class Update {
    public static void main(String [] args) {
        
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Bike.class)
                                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
       Transaction transaction;

        try{
            transaction = session.beginTransaction();
            Bike bikeToUpdate = (Bike) session.get(Bike.class, 1);
            bikeToUpdate.update(new Bike("bikename", "bikebrand", "górski", 777.0));
            session.update(bikeToUpdate);
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}