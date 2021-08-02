/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.IstekListesi;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nurcan
 */
public class IstekListesiModel {

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

    public void insert(IstekListesi s) {
        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into istek_listesi(istek_tipi_id,birimi_id,mahalle_id,aciklama,date, asama_id) values ('"
                    + s.getIstek_tipi_id() + "','"
                    + s.getBirimi_id() + "','"
                    + s.getMahalle_id() + "','"
                    + s.getAciklama() + "','"
                    + s.getDate() + "','"
                    + s.getAsama_id() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<IstekListesi> getList() {
        List<IstekListesi> cList = new ArrayList<>();
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istekListesi");

            while (rs.next()) {
                IstekListesi tmp = new IstekListesi(
                        rs.getString("istek_tipi_id"),
                        rs.getString("birimi_id"),
                        rs.getString("mahalle_id"),
                        rs.getString("aciklama"),
                        rs.getDate("date"),
                        rs.getString("asama_id"));
                cList.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cList;
    }
}
