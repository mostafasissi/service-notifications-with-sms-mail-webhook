package ehtp.mostafa.webhookservice;

import ehtp.mostafa.webhookservice.service.SlackService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebhookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebhookServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(SlackService slackService){
        return args -> {
            slackService.sendMessageToSlack("Bonjour , c'est le boot de notification ");
            slackService.sendMessageToSlack("Comment alllez vous");

        };
    }
}
