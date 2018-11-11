/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowanko1;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Krzysiek
 */

@Entity
@Table(name = "rowery")
public class Bike{
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rower_id")
    private int id;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "marka")
    private String brand;

    @Column(name = "rodzaj")
    private String type;

    @Column(name = "cena")
    private double price;

    public Bike(){

    }

    public Bike(String name, String brand, String type, double price) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    public void update(Bike bike){
        this.name = bike.getName();
        this.brand = bike.getBrand();
        this.type = bike.getType();
        this.price = bike.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Rower{" + "id=" + id + ", nazwa=" + name + ", marka=" + brand + ", rodzaj=" + type + ", cena=" + price + '}';
    }
}
