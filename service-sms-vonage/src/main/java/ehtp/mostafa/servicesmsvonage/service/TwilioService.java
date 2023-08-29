package ehtp.mostafa.servicesmsvonage.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import ehtp.mostafa.servicesmsvonage.config.TwilioConfig;
import ehtp.mostafa.servicesmsvonage.domain.MessageSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.type.PhoneNumber;


@Service
public class TwilioService {
    private final TwilioConfig twilioConfig ;

    @Autowired
    public TwilioService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    void sendSms(MessageSMS message){
        PhoneNumber from = new PhoneNumber(
                twilioConfig.getTrialNumber()
        );
        PhoneNumber to = new PhoneNumber(
                message.getTo()
        );

        MessageCreator creator = Message.creator(
                from ,
                to  ,
                message.getMsgBody()
        );
        creator.create();
    }

}
