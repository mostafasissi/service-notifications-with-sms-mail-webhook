package ehtp.mostafa.kafkaconsumer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ehtp.mostafa.kafkaconsumer.entities.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
public class ConsumerService {
    @Value(value = "${mail.service.url}")
    private String mailUrl ;

    @Value(value = "${sms.service.url}")
    private String smsUrl ;

    @Value(value = "${webhook.service.url}")
    private String webhookUrl ;

    @KafkaListener(topics = "sms" , groupId ="cunsuming" )
    public void smsListener(Message message){
        System.out.println("Received Message in group consuming <sms topic> :" + message);

        try {
            sendMessageToOtherApi(smsUrl , message);
            System.out.println("**********************send sms message with succes*********************");
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

    @KafkaListener(topics = "mail" , groupId ="cunsuming" )
    public void mailListener(Message message){
        System.out.println("Received Message in group consuming <mail topic> :" + message);

        try {
            sendMessageToOtherApi(mailUrl , message);
            System.out.println("**********************send message with succes*********************");
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

    @KafkaListener(topics = "webhook" , groupId ="cunsuming" )
    public void webhookListener(Message message){
        System.out.println("Received Message in group consuming <webhook topic> :" + message);

        try {
            sendMessageToOtherApi(webhookUrl , message);
            System.out.println("**********************send message with succes*********************");
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }

    }
    public void sendMessageToOtherApi(String url , Message message) throws JsonProcessingException {


        // Create headers if needed (e.g., for authentication)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        // Convert the Message object to JSON format
        String requestBody = new ObjectMapper().writeValueAsString(message);

        // Create the HttpEntity with the request body and headers
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send the POST request
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        // The API response (if needed) can be captured in the ResponseEntity<String> returned by exchange() method.
    }



}
