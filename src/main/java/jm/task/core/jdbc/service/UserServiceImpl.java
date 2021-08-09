package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl daoReuse = new UserDaoJDBCImpl();

    public void createUsersTable() { daoReuse.createUsersTable();
    }

    public void dropUsersTable() { daoReuse.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) { daoReuse.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) { daoReuse.removeUserById(id);
    }

    public List<User> getAllUsers() { return daoReuse.getAllUsers();
    }

    public void cleanUsersTable() { daoReuse.cleanUsersTable();
    }
}
