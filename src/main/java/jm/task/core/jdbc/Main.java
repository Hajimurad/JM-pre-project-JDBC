package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();

        service.createUsersTable();

        service.saveUser("Ivan", "Ivanov", (byte) 12);
        service.saveUser("Masha", "Sergeeva", (byte) 20);
        service.saveUser("Paul", "Baul", (byte) 17);
        service.saveUser("Jim", "Mim", (byte) 26);

        // service.removeUserById(2);

        System.out.println(service.getAllUsers());
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
