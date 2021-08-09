package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.ws.rs.DELETE;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private final Connection connection = Util.connect();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try(Statement st = connection.createStatement()) {

            st.executeUpdate("CREATE TABLE IF NOT EXISTS task113db (" +
                            "id BIGINT NOT NULL AUTO_INCREMENT," +
                            "name VARCHAR(255), " +
                            "lastname VARCHAR(255), " +
                            "age TINYINT," +
                            "PRIMARY KEY (id)" + ");");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try(Statement st = connection.createStatement()) {

            st.executeUpdate("DROP TABLE IF EXISTS task113db;");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(PreparedStatement st =
                    connection.prepareStatement("INSERT INTO task113db (name, lastname, age) VALUES (?,?,?);")) {

            st.setString(1, name); // index от 1
            st.setString(2, lastName);
            st.setByte(3, age);

            st.executeUpdate();

            System.out.println("Пользователь с именем " + name + " добавлен в базу данных");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(PreparedStatement  st = connection.prepareStatement("DELETE FROM task113db WHERE id = ?;")) {

            st.setLong(1, id);
            st.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (Statement st = connection.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT * FROM task113db;")){

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                Byte age = resultSet.getByte("age");

                User user = new User(name, lastName, age);
                user.setId(id);
                userList.add(user);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try(Statement st = connection.createStatement()) {

            st.executeUpdate("TRUNCATE TABLE task113db;");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
