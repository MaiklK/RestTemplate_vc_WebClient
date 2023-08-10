package rest_vc_web.maiklk.service;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import rest_vc_web.maiklk.model.User;

@Service
public class UserWebClientServiceImpl implements UserWebClientService {

    private User user;
    private final WebClient client;
    private final UserService userService;
    private final String URL = "http://localhost:8080/wc/users";
    private long id;

    public UserWebClientServiceImpl(UserService userService) {
        this.userService = userService;
        this.user = new User("UserTest", "ablablabl");
        this.client = WebClient.builder()
                .baseUrl(URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public void wcGetAllUsers() {
        //TODO
    }

    @Timed("wcSave")
    @Override
    public void wcSaveUser() {
        client.post().uri("")
                .body(Mono.just(user), User.class).retrieve().bodyToMono(String.class).block();
    }

    @Timed("wcGet")
    @Override
    public void wcGetUserById() {
        this.user = userService.getUserByName(this.user.getName());
        this.id = user.getId();

        client.get().uri("/" + id).retrieve().bodyToMono(String.class).block();
    }

    @Timed("wcUpdate")
    @Override
    public void wcUpdateUser() {
        this.user.setName("Garry");
        this.user.setData("The Warrior");

        client.put().uri("")
                .body(Mono.just(user), User.class).retrieve().bodyToMono(String.class).block();
    }

    @Timed("wcDelete")
    @Override
    public void wcDeleteUser() {
        client.delete().uri("/" + id)
                .retrieve().bodyToMono(String.class).block();
    }
}
