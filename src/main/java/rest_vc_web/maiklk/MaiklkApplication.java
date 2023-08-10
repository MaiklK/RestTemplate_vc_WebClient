package rest_vc_web.maiklk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MaiklkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaiklkApplication.class, args);
    }

}
