package ehtp.mostafa.kafkaproducer.controller;

import ehtp.mostafa.kafkaproducer.entities.Message;
import ehtp.mostafa.kafkaproducer.service.TopicProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SenderController  {
    private TopicProducer producer;
    @Autowired
    public SenderController(TopicProducer prod) {
        this.producer = prod;
    }

    public void sendMessageToSMSTopic(Message message) {
        log.info("[ProductService] send product to topic");
        producer.send("sms", message  );
    }
    public void sendMessageToMailTopic(Message message) {
        log.info("[ProductService] send product to topic");
        producer.send("mail", message  );
    }
    public void sendMessageToWebHookTopic(Message message) {
        log.info("[ProductService] send product to topic");
        producer.send("webhook", message  );
    }

}

