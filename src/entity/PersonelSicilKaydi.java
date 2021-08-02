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
public class PersonelSicilKaydi {
     private int id;
    private String ad;
    private String soyad;
    private String tc;
    private String unvan;
    private String adres;

    public PersonelSicilKaydi(int id, String ad, String soyad, String tc, String unvan, String adres) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
        this.unvan = unvan;
        this.adres = adres;
    }

    public PersonelSicilKaydi(String ad, String soyad, String tc, String unvan, String adres) {
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
        this.unvan = unvan;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "SicilKaydi{" + "id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", tc=" + tc + ", unvan=" + unvan + ", adres=" + adres + '}';
    }
}
