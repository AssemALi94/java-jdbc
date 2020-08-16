package com.jdbc.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Utility {

    public static void printStatement(ResultSet res) {
        try {
            while (res.next()) {
                System.out.println(res.getString("id") + res.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
