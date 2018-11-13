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
import org.hibernate.exception.DataException;
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
                  .addAnnotatedClass(Bike.class)
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
    public void testCorrectCreate() {
        Bike bikeToCreate = new Bike("createNazwa", "createMarka", "createRodzaj", 60);
        CreateDAO instance = new CreateDAO();
        instance.create(bikeToCreate);
        session.beginTransaction();
        Bike retrivedBike = (Bike) session.get(Bike.class, bikeToCreate.getId());
        session.getTransaction().commit();
        assertEquals(bikeToCreate.toString(), retrivedBike.toString());
    }
    
    @Test
    public void testCreateBikeNullValues(){
        Bike bikeToCreate = new Bike(null, null, null, 60);
        CreateDAO instance = new CreateDAO();
        instance.create(bikeToCreate);
        session.beginTransaction();
        Bike retrivedBike = (Bike) session.get(Bike.class, bikeToCreate.getId());
        session.getTransaction().commit();
        assertNull(retrivedBike.getBrand());
        assertNull(retrivedBike.getName());
        assertNull(retrivedBike.getType());
    }
    
    @Test(expected = DataException.class)
    public void testCreateBikeWithStringTooLong(){
        Bike bikeToCreate = new Bike("bardzodluganazwadefinitywniezadlugabyjazapisacwnaszejbaziedanych", "createMarka", "createRodzaj", 60);
        CreateDAO instance = new CreateDAO();
        instance.create(bikeToCreate);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNullBike(){
        Bike bikeToCreate = null;
        CreateDAO instance = new CreateDAO();
        instance.create(bikeToCreate);
    }
    
}
