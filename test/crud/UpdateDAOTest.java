package crud;

import entity.Bike;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UpdateDAOTest {
    private SessionFactory sessionFactory;
    private Session session;
    
    public UpdateDAOTest(){}

    @Before
    public void setUp() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Bike.class).buildSessionFactory();
        session = sessionFactory.openSession();

    }

    @After
    public void tearDown() {
        session.close();
        sessionFactory.close();
    }

    // modyfikacja prawidłowgo istniejącego obiektu
    
    @Test
    public void updateCorrectBike() {
        //System.out.println("### TEST CORRECT BIKE");
        final double UPDATED_PRICE = 420;
        Transaction transaction = session.beginTransaction();
        Bike bike = new Bike("testowaNazwa1", "testowaMarka1", "testowyRodzaj1", 120.99);
        session.save(bike);
        transaction.commit();
        
        int bikeId = bike.getId();
        //System.out.println("BikeId: " + bikeId);
        bike.setPrice(UPDATED_PRICE);

        UpdateDAO instance = new UpdateDAO();
        instance.update(bikeId, bike);
        
        Transaction transaction1 = session.beginTransaction();
        Bike updatedBike = (Bike) session.get(Bike.class, bikeId);
        transaction1.commit();
        
        assertEquals(bikeId, updatedBike.getId());
        assertEquals(UPDATED_PRICE, updatedBike.getPrice(), 0.0000000001);
    }
    
    @Test(expected = NullPointerException.class)
    public void updateBikeNegativeId(){
        //System.out.println("### TEST NEGATIVE ID");
        final double UPDATED_PRICE = 420;
        Transaction transaction = session.beginTransaction();
        Bike bike = new Bike("testowaNazwa2", "testowaMarka2", "testowyRodzaj2", 120.99);
        session.save(bike);
        transaction.commit();
        
        int bikeId = -3;
        //System.out.println("BikeId: " + bikeId);
        bike.setPrice(UPDATED_PRICE);
        
        UpdateDAO instance = new UpdateDAO();
        instance.update(bikeId, bike);
    }
    
    @Test(expected = NullPointerException.class)
    public void updateNotExistingBike(){
        //System.out.println("### TEST NEGATIVE ID");
        final double UPDATED_PRICE = 420;
        Transaction transaction = session.beginTransaction();
        Bike bike = new Bike("testowaNazwa3", "testowaMarka3", "testowyRodzaj3", 120.99);
        session.save(bike);
        transaction.commit();
        
        int bikeId = Integer.MAX_VALUE;
        //System.out.println("BikeId: " + bikeId);
        bike.setPrice(UPDATED_PRICE);
        
        UpdateDAO instance = new UpdateDAO();
        instance.update(bikeId, bike);
    }
    
    @Test
    public void updateBikeWithNullValues(){
        
        Bike bike = new Bike("testowaNazwa4", "testowaMarka4", "testowyRodzaj4", 120.99);
        CreateDAO cr = new CreateDAO();
        cr.create(bike);
        
        int bikeId = bike.getId();
        bike.update(new Bike(null, null, null, 0));
        
        UpdateDAO up = new UpdateDAO();
        up.update(bikeId, bike); 

        ReadDAO rd = new ReadDAO();
        Bike updatedBike = rd.read(bikeId);
        
        assertNull(updatedBike.getBrand());
        assertNull(updatedBike.getName());
        assertNull(updatedBike.getType());        
    }
    
    @Test
    public void updateBikeWithStringTooLong(){
        
        Bike bike = new Bike("testowaNazwa5", "testowaMarka5", "testowyRodzaj5", 120.99);
        CreateDAO cr = new CreateDAO();
        cr.create(bike);
        
        int bikeId = bike.getId();
        bike.setName("bardzodluganazwadefinitywniezadlugabyjazapisacwnaszejbaziedanych");
        
        UpdateDAO up = new UpdateDAO();
        up.update(bikeId, bike);
        
        ReadDAO rd = new ReadDAO();
        Bike updatedBike = rd.read(bikeId);
        
        assertEquals("testowaNazwa5", updatedBike.getName());
        
    }
}