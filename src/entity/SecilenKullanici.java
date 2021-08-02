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
public class SecilenKullanici {

    private int kullaniciid;
    private String ad;
    private String soyad;
    private String tc;

    public SecilenKullanici() {
    }

    public SecilenKullanici(int kullaniciid, String ad, String soyad, String tc) {
        this.kullaniciid = kullaniciid;
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
    }

    public SecilenKullanici(String ad, String soyad, String tc) {
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
    }

    public int getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(int kullaniciid) {
        this.kullaniciid = kullaniciid;
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

    @Override
    public String toString() {
        return "SecilenKullanici{" + "kullaniciid=" + kullaniciid + ", ad=" + ad + ", soyad=" + soyad + ", tc=" + tc + '}';
    }

}
