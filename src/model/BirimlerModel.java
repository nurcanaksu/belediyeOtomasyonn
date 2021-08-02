/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Birimler;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nurcan
 */
public class BirimlerModel {
    
    private DBConnection db;
    
    public DBConnection getDb() {
        
        if (db == null) {
            this.db = new DBConnection();
        }
        return db;
    }
    
    public void setDb(DBConnection connection) {
        this.db = connection;
    }
    
    public void insert(Birimler i) {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into birimler(birim_adi) values (" + i.getBirim_adi() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Birimler> getList() {
        List<Birimler> cList = new ArrayList<>();
        
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from birimler");
            while (rs.next()) {
                Birimler tmp = new Birimler(rs.getString("birim_adi"));
                cList.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return cList;
    }
}
