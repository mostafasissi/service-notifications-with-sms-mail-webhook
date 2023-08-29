package ehtp.mostafa.kafkaproducer;

import ehtp.mostafa.kafkaproducer.controller.SenderController;
import ehtp.mostafa.kafkaproducer.entities.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {

        SpringApplication.run(KafkaProducerApplication.class, args);
    }
    @Bean
    CommandLineRunner start(SenderController productService){
        return args -> {
            // send to sms service
                Message message = Message
                        .builder()
                        .from("service notitication")
                        .to("212628365921")
                        .msgBody("a depacement of temperature was detected !! ")
                        .subject("notifation alert from service notif")
                        .build();
                productService.sendMessageToSMSTopic(message);

                productService.sendMessageToWebHookTopic(message);

                message.setTo("y.ouarrak@digieye.io");
                productService.sendMessageToMailTopic(message);



        };
    }

}
