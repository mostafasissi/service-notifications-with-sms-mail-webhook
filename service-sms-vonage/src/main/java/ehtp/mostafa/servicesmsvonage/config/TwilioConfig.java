package ehtp.mostafa.servicesmsvonage.config;

import com.twilio.Twilio;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class TwilioConfig {
    @Value("${twilio.account.id}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.trial.number}")
    private String trialNumber;

    public TwilioConfig(){
         Twilio.init(
                accountSid ,
                authToken
        );
    }

}
