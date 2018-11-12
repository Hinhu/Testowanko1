/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class UpdateDAO {
    
    public UpdateDAO() {
    
    }
    
    public void update(int bikeId, Bike newBike) {
        
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Bike.class)
                                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
                
        try{
            Bike bikeToUpdate = (Bike) session.get(Bike.class, bikeId);
            session.beginTransaction();
            bikeToUpdate.update(newBike);
            session.update(bikeToUpdate);
            session.getTransaction().commit(); 
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
             factory.close();
        }
    }
}
