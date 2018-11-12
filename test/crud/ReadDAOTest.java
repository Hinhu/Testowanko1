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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ReadDAOTest {
    
    private SessionFactory factory;
    private Session session;
    
    public ReadDAOTest() {
        
    }
    
    @Before
    public void setUp() {
        factory = new Configuration()
                  .configure("hibernate.cfg.xml")
                  .addAnnotatedClass(Rower.class)
                  .buildSessionFactory();
        
        session = factory.getCurrentSession();
    }
    
    @After
    public void tearDown() {
        factory.close();
    }

    /**
     * Test of read method, of class ReadDAO.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        Rower bikeToCreate = new Rower("readNazwa", "readMarka", "readRodzaj", 500);;
        session.beginTransaction();
        session.save(bikeToCreate);
        session.getTransaction().commit(); 
        ReadDAO instance = new ReadDAO();
        Rower retrivedBike = instance.read(bikeToCreate.getId());
        assertEquals(bikeToCreate.toString(), retrivedBike.toString());
    }
    
}
