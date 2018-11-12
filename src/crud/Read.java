/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import entity.Bike;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author User
 */
public class Read {
    public static void main(String [] args) {
        
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Bike.class)
                                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            session.beginTransaction();
            int id = 1;
            
            System.out.println("Retriving bike with id: " + id);
            Bike retrivedBike = (Bike) session.get(Bike.class, id);
            session.getTransaction().commit();
            System.out.println("Retrived bike: " + retrivedBike);
        }
        finally {
            factory.close();
        }
    }
}
