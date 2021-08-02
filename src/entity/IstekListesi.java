/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author nurcan
 */
public class IstekListesi {

    private int kullanici_id;
    private String istek_tipi_id;
    private String birimi_id;
    private String mahalle_id;
    private String aciklama;
    private Date tarih;
    private String asama_id;

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public int getGonderenid() {
        return gonderenid;
    }

    public void setGonderenid(int gonderenid) {
        this.gonderenid = gonderenid;
    }
    private int gonderenid;

    public IstekListesi(int kullanici_id, String istek_tipi_id, String birimi_id, String mahalle_id, String aciklama, Date tarih, String asama_id, int gonderenid) {
        this.kullanici_id = kullanici_id;
        this.istek_tipi_id = istek_tipi_id;
        this.birimi_id = birimi_id;
        this.mahalle_id = mahalle_id;
        this.aciklama = aciklama;
        this.tarih = tarih;
        this.asama_id = asama_id;
        this.gonderenid = gonderenid;
    }

    public IstekListesi(String istek_tipi_id, String birimi_id, String mahalle_id, String aciklama, Date date, String asama_id) {
        this.istek_tipi_id = istek_tipi_id;
        this.birimi_id = birimi_id;
        this.mahalle_id = mahalle_id;
        this.aciklama = aciklama;
        this.tarih = date;
        this.asama_id = asama_id;
    }

    public IstekListesi(int kullanici_id, String istek_tipi_id, String birimi_id, String mahalle_id, String aciklama, Date date, String asama_id) {
        this.kullanici_id = kullanici_id;
        this.istek_tipi_id = istek_tipi_id;
        this.birimi_id = birimi_id;
        this.mahalle_id = mahalle_id;
        this.aciklama = aciklama;
        this.tarih = date;
        this.asama_id = asama_id;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getIstek_tipi_id() {
        return istek_tipi_id;
    }

    public void setIstek_tipi_id(String istek_tipi_id) {
        this.istek_tipi_id = istek_tipi_id;
    }

    public String getBirimi_id() {
        return birimi_id;
    }

    public void setBirimi_id(String birimi_id) {
        this.birimi_id = birimi_id;
    }

    public String getMahalle_id() {
        return mahalle_id;
    }

    public void setMahalle_id(String mahalle_id) {
        this.mahalle_id = mahalle_id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getDate() {
        return tarih;
    }

    public void setDate(Date date) {
        this.tarih = date;
    }

    public String getAsama_id() {
        return asama_id;
    }

    public void setAsama_id(String asama_id) {
        this.asama_id = asama_id;
    }

    @Override
    public String toString() {
        return "IstekListesi{" + "istek_tipi_id=" + istek_tipi_id + ", birimi_id=" + birimi_id + ", mahalle_id=" + mahalle_id + ", aciklama=" + aciklama + ", date=" + tarih + ", asama_id=" + asama_id + '}';
    }

}
