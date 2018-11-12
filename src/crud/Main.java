package crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import entity.Bike;

import java.util.List;

public class Main {

    public static void main(String args[]){
        CRUD crud = new CRUD();
        List<Bike> bikeList = crud.getAllBikes();
        System.out.println(bikeList);
    }

}
