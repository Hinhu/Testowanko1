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
 * @author Maciek
 */
public class DeleteDAOTest {

    private SessionFactory factory;
    private Session session;

    public DeleteDAOTest() {

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
    public void testDelete() {
        System.out.println("delete");
        
        Bike bikeToDelete = new Bike("deleteNazwa", "deleteMarka", "deleteRodzaj", 60);
        session.beginTransaction();
        session.save(bikeToDelete);
        session.getTransaction().commit();
        System.out.println("Created bike which will be deleted; id="+bikeToDelete.getId());
        
        DeleteDAO instance = new DeleteDAO();
        instance.delete(bikeToDelete.getId());
        System.out.println("Bike deleted");
        
        session = factory.getCurrentSession();
        session.beginTransaction();
        Bike retrivedBike = (Bike) session.get(Bike.class, bikeToDelete.getId());
        session.getTransaction().commit();
        System.out.println("Search of deleted bike results with "+retrivedBike);
        assertEquals(null, retrivedBike);
    }

}
