package peaksoft.services.impl;

import peaksoft.dao.UserDao;
import peaksoft.dao.impl.UserDaoImpl;
import peaksoft.models.User;
import peaksoft.services.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public String createUser() {
        return userDao.createUser();
    }

    @Override
    public String saveUser(User user) {
        try {
           return userDao.saveUser(user);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public String updateUser(Long id, User user) {
        try {
            return userDao.updateUser(id, user);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }
}
