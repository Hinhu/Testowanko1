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
                  .addAnnotatedClass(Bike.class)
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
        Bike bikeToCreate = new Bike("readNazwa", "readMarka", "readRodzaj", 500);;
        session.beginTransaction();
        session.save(bikeToCreate);
        session.getTransaction().commit(); 
        ReadDAO instance = new ReadDAO();
        Bike retrivedBike = instance.read(bikeToCreate.getId());
        assertEquals(bikeToCreate.toString(), retrivedBike.toString());
    }
    
    @Test
    public void testReadNotExist() {
        ReadDAO instance = new ReadDAO();
        Bike retrivedBike = instance.read(-1);
        assertNull(retrivedBike);
    }
      
}
