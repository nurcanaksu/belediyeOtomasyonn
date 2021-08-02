/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.PersonelSicilKaydi;
import entity.SicilKaydi;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nurcan
 */
public class PersonelSicilModel {

    private DBConnection db;

    public DBConnection getDb() {
        if (db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public void setDb(DBConnection db) {
        this.db = db;
    }

    public void insert(PersonelSicilKaydi s) {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into kullanici_sicil_tablasu(id,ad,soyad,tc,unvan, adres) values ('"
                    + s.getId() + "','"
                    + s.getAd() + "','"
                    + s.getSoyad() + "','"
                    + s.getTc() + "','"
                    + s.getUnvan() + "','"
                    + s.getAdres() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<PersonelSicilKaydi> getList() {
        List<PersonelSicilKaydi> cList = new ArrayList<>();
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici_sicil_tablosu");

            while (rs.next()) {
                PersonelSicilKaydi tmp = new PersonelSicilKaydi(rs.getInt("id"),
                        rs.getString("adi"),
                        rs.getString("soyadi"),
                        rs.getString("tc"),
                        rs.getString("unvan"),
                        rs.getString("adres"));
                cList.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cList;
    }

}
