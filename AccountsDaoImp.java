package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountsDaoImp implements AccountsDao {
    private Connection con = null;

    public AccountsDaoImp() {
        ConnectionManager connectionManager = new ConnectionManager();
        con = connectionManager.initializeConnection();

        try (Statement statement = con.createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS account( " +
                    "number TEXT NOT NULL, " +
                    "pin TEXT NOT NULL, " +
                    "balance INTEGER DEFAULT 0" +
                    ");");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAccount(String cardNumber, String pin) {
        try (Statement statement = con.createStatement()) {

            statement.executeUpdate("INSERT INTO account (number, pin) VALUES ('" +
                    cardNumber + "', '" + pin + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePin(String cardNumber, String pin, String newPin) {
        try (Statement statement = con.createStatement()) {
            ResultSet pinResultSet = statement.executeQuery("SELECT pin FROM account WHERE number = '" + cardNumber + "';");
            if (pin.equals(pinResultSet.getString("pin"))) {
                try (Statement statement2 = con.createStatement()) {
                    statement2.executeUpdate("UPDATE account SET pin = '" + newPin + "' WHERE number = '" + cardNumber + "';");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long checkBalance(String cardNumber, String pin) {
        try (Statement statement = con.createStatement()) {
            ResultSet pinResultSet = statement.executeQuery("SELECT pin FROM account WHERE number = '" + cardNumber + "';");
            if (pin.equals(pinResultSet.getString("pin"))) {
                try (Statement statement2 = con.createStatement()) {
                    ResultSet balance = statement2.executeQuery("SELECT balance FROM account WHERE number = '" + cardNumber + "';");
                    return (long) balance.getInt("balance");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean isLoggedIn(String cardNumber, String pin) {
        try (Statement statement = con.createStatement()) {
            ResultSet pinResultSet = statement.executeQuery("SELECT pin FROM account WHERE number = '" + cardNumber + "';");
            if (pin.equals(pinResultSet.getString("pin"))) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
