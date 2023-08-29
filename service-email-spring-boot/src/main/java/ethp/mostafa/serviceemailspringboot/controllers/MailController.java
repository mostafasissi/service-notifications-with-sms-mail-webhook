package ethp.mostafa.serviceemailspringboot.controllers;

import ethp.mostafa.serviceemailspringboot.entities.Message;
import ethp.mostafa.serviceemailspringboot.services.EmailService;
import io.nats.client.Connection;
import io.nats.client.Nats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/mail/api/v1/")
public class MailController {
    @Autowired
    EmailService emailService;
    @PostMapping("simpleMail")
    public  void sendSimpleMail(@RequestBody() Message message) throws IOException, InterruptedException {
        System.out.println("simple mail (waiting to send message =  : "+message);
        emailService.sendSimpleMail(message);
    }
    @PostMapping("templateMail")
    public ResponseEntity<String> sendTemplateMail(@RequestBody() Message message ){

        System.out.println("template Mail : " + message);
        emailService.sendMailTemplate(message);

        return new ResponseEntity<>("message send with sucess" , HttpStatus.OK);
    }
}
