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
public class Kullanicilar {

    private int kullanici_id;
    private String kullanici_adi;
    private String sifre;

    public Kullanicilar(int kullanici_id, String kullanici_adi, String sifre) {
        this.kullanici_id = kullanici_id;
        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;
    }

    public Kullanicilar(String kullanici_adi, String sifre) {
        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public String toString() {
        return "Kullanicilar{" + "kullanici_adi=" + kullanici_adi + ", sifre=" + sifre + '}';
    }

}
