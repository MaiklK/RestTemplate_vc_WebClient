package rest_vc_web.maiklk.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import rest_vc_web.maiklk.service.UserRestTemplateService;
import rest_vc_web.maiklk.service.UserWebClientService;

@Component
@RequiredArgsConstructor
public class UserScheduler {

    private final UserRestTemplateService userRestTemplateService;
    private final UserWebClientService userWebClientService;

    @Scheduled(initialDelay = 2000, fixedRate = 1)
    public void restTemplateScheduling() {
        userRestTemplateService.rtSaveUser();
        userRestTemplateService.rtGetUserById();
        userRestTemplateService.rtUpdateUser();
        userRestTemplateService.rtDeleteUser();
    }

    @Scheduled(initialDelay = 2000, fixedRate = 1)
    public void webClientScheduling() {
        userWebClientService.wcSaveUser();
        userWebClientService.wcGetUserById();
        userWebClientService.wcUpdateUser();
        userWebClientService.wcDeleteUser();
    }
}
