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
 * @author Maciek
 */
public class Delete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Bike.class)
                                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            System.out.println("Deleting first bike");
            Bike bike = new Bike();
            bike.setId(1);
            session.beginTransaction();
            session.delete(bike);
            session.getTransaction().commit(); 
            System.out.println("First bike deleted");
            
        }
        finally {
            factory.close();
        }
        
        
        
    }
}
