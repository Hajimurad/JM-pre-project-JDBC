package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl interconnect = new UserDaoJDBCImpl();

        interconnect.createUsersTable();

        interconnect.saveUser("Ivan", "Ivanov", (byte) 12);
        interconnect.saveUser("Masha", "Sergeeva", (byte) 20);
        interconnect.saveUser("Paul", "Baul", (byte) 17);
        interconnect.saveUser("Jim", "Mim", (byte) 26);

        interconnect.getAllUsers().forEach(System.out::println);
        interconnect.cleanUsersTable();
        interconnect.dropUsersTable();
    }
}
