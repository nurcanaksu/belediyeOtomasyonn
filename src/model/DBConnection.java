/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nurcan
 */
public class DBConnection {

    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/belediyeYonetimSistemi", "postgres", "123");
          

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
