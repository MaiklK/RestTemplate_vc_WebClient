package rest_vc_web.maiklk.service;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rest_vc_web.maiklk.model.User;

import java.util.List;

@Service
public class UserRestTemplateServiceImpl implements UserRestTemplateService {

    private final HttpHeaders headers;
    private RestTemplate restTemplate;
    private long id;
    private User user;
    private final UserService userService;
    private final String URL = "http://localhost:8080/rt/users";

    public UserRestTemplateServiceImpl(UserService userService) {
        this.headers = new HttpHeaders();
        this.headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        this.restTemplate = new RestTemplate();
        this.user = new User("TestUser", "blablabla");
        this.userService = userService;
    }

    @Override
    public void rtGetAllUsers() {
        //TODO
    }

    @Timed("saveUser")
    @Override
    public void rtSaveUser() {
        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        restTemplate.exchange(
                URL, HttpMethod.POST, entity, String.class);
    }

    @Timed("getUserById")
    @Override
    public void rtGetUserById() {
        User user = userService.getUserByName(this.user.getName());
        this.id = user.getId();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        restTemplate.exchange(
                URL + "/" + id, HttpMethod.GET, entity, String.class);
    }

    @Timed("updateUser")
    @Override
    public void rtUpdateUser() {
        this.user.setName("Norris");
        this.user.setData("The Best Clown");
        HttpEntity<User> entity = new HttpEntity<>(this.user, headers);

       restTemplate.exchange(
                URL, HttpMethod.PUT, entity, String.class);
    }

    @Timed("deleteUser")
    @Override
    public void rtDeleteUser() {
        HttpEntity<String> entity = new HttpEntity<>(headers);

        restTemplate.exchange(
                URL + "/" + id, HttpMethod.DELETE, entity, String.class);
    }
}
