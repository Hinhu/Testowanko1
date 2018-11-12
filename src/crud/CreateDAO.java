/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import entity.Rower;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author User
 */
public class CreateDAO {
    
    public CreateDAO() {
    
    }
    
    public void create(Rower bikeToCreate) {
        
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Rower.class)
                                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            System.out.println("Adding new bike");
            Rower rower = bikeToCreate;
            session.beginTransaction();
            session.save(rower);
            session.getTransaction().commit(); 
            System.out.println("Bike added");
        }
        finally {
            factory.close();
        }
        
        
    }
}
