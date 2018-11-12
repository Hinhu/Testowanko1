/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Rower;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class Create {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Rower.class)
                                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            System.out.println("Adding new bike");
            Rower rower = new Rower("bikename", "bikebrand", "miejski", 80);
            session.beginTransaction();
            session.save(rower);
            session.getTransaction().commit(); 
            System.out.println("Bike added with id: " + rower.getId());
            
        }
        finally {
            factory.close();
        }
        
        
        
    }
}
