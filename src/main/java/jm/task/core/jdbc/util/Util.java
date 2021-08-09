package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String LOGIN = "root";
    private static final String PASSWORD = "Hajimurad";
    private static final String URL = "jdbc:mysql://localhost:3306/task113db";

    public static Connection connect(){
        try{
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Соединение с БД установлено");
            }
            return connection;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}
