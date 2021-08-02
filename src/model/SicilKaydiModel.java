/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.SicilKaydi;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nurcan
 */
public class SicilKaydiModel {

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

    public void insert(SicilKaydi s) {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into kullanici_sicil_tablasu(ad,soyad,tc) values ('"
                   
                    + s.getAd() + "','" 
                    + s.getSoyad() + "','" 
                    + s.getTc() + 
                     "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<SicilKaydi> getList()
    {
        List<SicilKaydi> cList = new ArrayList<>();
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs =st.executeQuery("select * from kullanici_sicil_tablosu");
            
            while(rs.next())
            {
                SicilKaydi tmp = new SicilKaydi( 
                        rs.getString("adi"),
                        rs.getString("soyadi"),
                        rs.getString("tc")
                        );
                cList.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cList;
    }
}
