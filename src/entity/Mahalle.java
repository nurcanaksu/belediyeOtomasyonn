/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author nurcan
 */
public class Mahalle {

    private int id;
    private String mahalle_adi;

    public Mahalle(int id, String mahalle_adi) {
        this.id = id;
        this.mahalle_adi = mahalle_adi;
    }

    public Mahalle(String mahalle_adi) {
        this.mahalle_adi = mahalle_adi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMahalle_adi() {
        return mahalle_adi;
    }

    public void setMahalle_adi(String mahalle_adi) {
        this.mahalle_adi = mahalle_adi;
    }

    @Override
    public String toString() {
        return "Mahalle{" + "mahalle_adi=" + mahalle_adi + '}';
    }

    
}
