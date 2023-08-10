package rest_vc_web.maiklk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest_vc_web.maiklk.model.User;
import rest_vc_web.maiklk.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> userFound = userRepository.findById(id);
        return userFound.orElse(null);
    }

    @Override
    public User getUserByName(String name) {
        Optional<User> userFound = userRepository.findByName(name);
        return userFound.orElse(null);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User updateUser) {
        User foundUser = getUserByName(updateUser.getName());
        long id = foundUser.getId();
        updateUser.setId(id);
        userRepository.save(updateUser);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userRepository.delete(getUserById(id));
    }
}
