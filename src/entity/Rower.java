/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="rowery")
public class Rower {
    
    @Id
    @GeneratedValue
    @Column(name="rower_id")
    private int id;
    
    @Column(name="nazwa")
    private String nazwa;
    
    @Column(name="marka")
    private String marka;
    
    @Column(name="rodzaj")
    private String rodzaj;
    
    @Column(name="cena")
    private int cena;
    
    public Rower(){
        
    }

    public Rower(String nazwa, String marka, String rodzaj, int cena) {
        this.nazwa = nazwa;
        this.marka = marka;
        this.rodzaj = rodzaj;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getMarka() {
        return marka;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public int getCena() {
        return cena;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Rower{" + "id=" + id + ", nazwa=" + nazwa + ", marka=" + marka + ", rodzaj=" + rodzaj + ", cena=" + cena + '}';
    }
    
    
    
}
