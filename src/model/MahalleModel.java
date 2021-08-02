/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Mahalle;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nurcan
 */
public class MahalleModel {
    
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

    public void insert(Mahalle c) {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into mahalleler(mahalle_adi) values (" + c.getMahalle_adi() + "')" );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Mahalle> getList() {

        List<Mahalle> cList = new ArrayList<>();
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs =st.executeQuery("select * from mahalleler");
            
            while(rs.next())
            {
                Mahalle tmp = new Mahalle( rs.getString("mahalle_adi"));
                cList.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
 
        return cList;
        
    }
}
