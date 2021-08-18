package com.company;

import org.sqlite.SQLiteDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public ConnectionManager() {
        this.initializeConnection();
    }

    private String url = "jdbc:sqlite:db.s3db";
    private Connection con = null;

    Connection initializeConnection() {
            SQLiteDataSource dataSource = new SQLiteDataSource();
            dataSource.setUrl(url);

            try {
            con = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return con;
        //}
    }


}
