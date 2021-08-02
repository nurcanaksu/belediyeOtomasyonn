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
public class SicilKaydi {

    private int kullaniciid;
    private String ad;
    private String soyad;
    private String tc;
    private String tel;
    private String unvan;

    public SicilKaydi(int kullaniciid, String ad, String soyad, String tc, String tel, String unvan) {
        this.kullaniciid = kullaniciid;
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
        this.tel = tel;
        this.unvan = unvan;
    }

    public SicilKaydi(int kullaniciid, String ad, String soyad, String tc) {
        this.kullaniciid = kullaniciid;
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
    }

    public SicilKaydi(String ad, String soyad, String tc) {
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
        return "SicilKaydi{" + "ad=" + ad + ", soyad=" + soyad + ", tc=" + tc + '}';
    }

}
