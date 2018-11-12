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
public class CreateDAOTest {
    
    private SessionFactory factory;
    private Session session;
    
    public CreateDAOTest() {
        
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
     * Test of create method, of class CreateDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Rower bikeToCreate = new Rower("createNazwa", "createMarka", "createRodzaj", 60);
        CreateDAO instance = new CreateDAO();
        instance.create(bikeToCreate);
        session.beginTransaction();
        Rower retrivedBike = (Rower) session.get(Rower.class, bikeToCreate.getId());
        session.getTransaction().commit();
        assertEquals(bikeToCreate.toString(), retrivedBike.toString());
    }
    
}
