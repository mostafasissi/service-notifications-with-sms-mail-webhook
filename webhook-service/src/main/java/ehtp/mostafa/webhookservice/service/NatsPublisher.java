package ehtp.mostafa.webhookservice.service;

import io.nats.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NatsPublisher {
    @Autowired
    private Connection nats ;
    public void sendNatsMessage(String subject , String message )  {
        nats.publish(subject , message.getBytes());
    }
}
