package rest_vc_web.maiklk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_vc_web.maiklk.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}