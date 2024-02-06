package peaksoft.services;

import peaksoft.models.User;

public interface UserService{
    String createUser();
    String saveUser(User user);
    User getUserById(Long id);
    String  updateUser(Long id, User user);
    String deleteUser(Long id);
}
