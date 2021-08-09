package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String LOGIN = "root";
    private static final String PASSWORD = "Hajimurad";
    private static final String URL = "jdbc:mysql://localhost:3306/task113db";
    private static Connection connection;

    public static Connection connect(){
        if(connection != null){
            return connection;
        }
        try{
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }
}
