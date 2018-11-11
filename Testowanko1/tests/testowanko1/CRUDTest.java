package testowanko1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.security.x509.IPAddressName;

import static org.junit.jupiter.api.Assertions.*;

class CRUDTest {
    private SessionFactory sessionFactory;
    private Session session;

    @BeforeEach
    void setUp() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Bike.class).buildSessionFactory();
        session = sessionFactory.openSession();

    }

    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }

    @Test
    void updateBike() {
        final double UPDATED_PRICE = 420;
        Transaction transaction = session.beginTransaction();

        Bike bike = new Bike("testowaNazwa", "testowaMarka", "testowyRodzaj", 120);
        session.save(bike);
        transaction.commit();
        int bikeId = bike.getId();
        System.out.println("BikeId: " + bikeId);

        bike.setPrice(UPDATED_PRICE);

        CRUD crud = new CRUD();
        crud.updateBike(bikeId, bike);
        Transaction transaction1 = session.beginTransaction();
        Bike updatedBike = session.get(Bike.class, bikeId);
        transaction1.commit();
        assertEquals(UPDATED_PRICE, updatedBike.getPrice());

    }
}