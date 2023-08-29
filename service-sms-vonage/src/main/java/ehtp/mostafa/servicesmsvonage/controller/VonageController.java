package ehtp.mostafa.servicesmsvonage.controller;

import ehtp.mostafa.servicesmsvonage.domain.MessageSMS;
import ehtp.mostafa.servicesmsvonage.service.VonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms/vonage/v1")
public class VonageController {
    @Autowired
    private VonageService vs ;
    @PostMapping(path = "/sendSMS")
    public ResponseEntity<String> send(@RequestBody MessageSMS message ){
        System.out.println(message);

        boolean result = vs.SendSMS(message);
        if(result) return new ResponseEntity<>( "Message sent successfully" ,HttpStatus.OK);
        else return new ResponseEntity<>("Message failed with error" , HttpStatus.BAD_REQUEST );
    }
}
