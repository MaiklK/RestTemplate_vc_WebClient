package rest_vc_web.maiklk.service;

import rest_vc_web.maiklk.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByName(String name);

    User getUserById(long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);
}