package rest_vc_web.maiklk.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rest_vc_web.maiklk.model.User;
import rest_vc_web.maiklk.service.UserService;

@Component
@RequiredArgsConstructor
public class Init {

    private final UserService userService;

    @PostConstruct
    public void generateUsers() {
        userService.saveUser(new User("Tony", "aaadd321b"));
        userService.saveUser(new User("Liz", "ergRE3e"));
        userService.saveUser(new User("Jon", "WEF3fd"));
        userService.saveUser(new User("Sonya", "FF#Fdfs"));
        userService.saveUser(new User("Bob", "dsaf#sg3"));
        userService.saveUser(new User("Josh", "hsedfgvSd"));
    }
}
