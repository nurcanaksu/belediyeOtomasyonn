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
public class Birimler {

    private int birim_id;
    private String birim_adi;

    public Birimler(int birim_id, String birim_adi) {
        this.birim_id = birim_id;
        this.birim_adi = birim_adi;
    }

    public Birimler(String birim_adi) {
        this.birim_adi = birim_adi;
    }

    public int getBirim_id() {
        return birim_id;
    }

    public void setBirim_id(int birim_id) {
        this.birim_id = birim_id;
    }

    public String getBirim_adi() {
        return birim_adi;
    }

    public void setBirim_adi(String birim_adi) {
        this.birim_adi = birim_adi;
    }

 
}
