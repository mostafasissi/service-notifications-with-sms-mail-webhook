package ehtp.mostafa.kafkaproducer.service;


import ehtp.mostafa.kafkaproducer.entities.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j

public class TopicProducer {

    private KafkaTemplate<String , Message> kafkaTemplate ;

    @Autowired
    public TopicProducer(KafkaTemplate<String, Message> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(  String topic , Message message ){
        CompletableFuture<SendResult<String, Message>> future =
                kafkaTemplate.send(topic, message);

        future.whenComplete((input, exception) -> {
            if (exception != null) {
                System.out.println("exception occurs");
                System.err.println(exception);
            } else {
                System.out.println("no exception, got result: " + input);
            }
        });



    }
}
