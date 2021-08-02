/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Asama;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nurcan
 */
public class AsamaModel {

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

    public void insert(Asama a)
    {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into yapimasamalari(asama_adi) values (" + a.getAsama_adi() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Asama> getList() {
        List<Asama> cList = new ArrayList<>();
        
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from yapimasamalari");
            while (rs.next()) {
                Asama tmp = new Asama(rs.getString("asama_adi"));
                cList.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return cList;
    }
    }
    

