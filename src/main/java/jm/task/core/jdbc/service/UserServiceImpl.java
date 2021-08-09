package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService { // service переиспользует методы dao
    UserDaoJDBCImpl reuse = new UserDaoJDBCImpl();

    public void createUsersTable() { reuse.createUsersTable();
    }

    public void dropUsersTable() { reuse.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) { reuse.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) { reuse.removeUserById(id);
    }

    public List<User> getAllUsers() { return reuse.getAllUsers();
    }

    public void cleanUsersTable() { reuse.cleanUsersTable();
    }
}
