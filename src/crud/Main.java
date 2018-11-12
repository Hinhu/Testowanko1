package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import entity.Bike;

import java.util.List;

public class Main {

    public static void main(String args[]){
        //CRUD crud = new CRUD();
        /*List<Bike> bikeList = crud.getAllBikes();
        System.out.println(bikeList);
        Bike b = bikeList.get(0);
        b.setPrice(6969);
        crud.updateBike(b.getId(), b);
        System.out.println(crud.getAllBikes());*/



        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bike.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction transaction;
        try {
            System.out.println("Adding new bike");
            Bike bike = new Bike("bikename", "bikebrand", "miejski", 80);
            transaction = session.beginTransaction();
            session.save(bike);
            transaction.commit();
            System.out.println("Bike added with id: " + bike.getId());

        }
        finally {
            session.close();
            factory.close();
        }
    }

}
