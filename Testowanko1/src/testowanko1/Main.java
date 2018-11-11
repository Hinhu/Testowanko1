package testowanko1;

import java.util.List;

public class Main {

    public static void main(String args[]){
        CRUD crud = new CRUD();
        List<Bike> bikeList = crud.getAllBikes();
        System.out.println(bikeList);
        Bike b = bikeList.get(0);
        b.setPrice(6969);
        crud.updateBike(b.getId(), b);
        System.out.println(crud.getAllBikes());
    }

}
