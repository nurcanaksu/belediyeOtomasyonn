/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.IstekTipleri;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nurcan
 */
public class IstekTipleriModel {

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

    public void insert(IstekTipleri istek) {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into istek_tipleri(istek_adi) values (" + istek.getIstek_tipi() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<IstekTipleri> getList() {
        List<IstekTipleri> cList = new ArrayList<>();

        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istek_tipleri");
            while (rs.next()) {
                IstekTipleri tmp = new IstekTipleri(rs.getString("istek_tipi"));
                cList.add(tmp);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return cList;
    }

}
