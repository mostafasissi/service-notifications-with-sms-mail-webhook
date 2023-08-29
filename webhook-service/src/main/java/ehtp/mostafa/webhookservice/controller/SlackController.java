package ehtp.mostafa.webhookservice.controller;

import ehtp.mostafa.webhookservice.entities.Message;
import ehtp.mostafa.webhookservice.service.SlackService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook/slack/v1")
public class SlackController {
    @Autowired
    private SlackService slackService ;

    @PostMapping(path = "/sendMessage")
    public ResponseEntity<String> send(@RequestBody Message message ) {
           System.out.println(message);
           boolean isSuccessfully =  slackService.sendMessageToSlack(message.getMsgBody());
           if(isSuccessfully){
               return new ResponseEntity<>("Message send successfully !!" , HttpStatus.OK);
           }else {
               return new ResponseEntity<>("Message failed to send" , HttpStatus.FORBIDDEN);
           }
    }
}